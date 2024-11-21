package dacn.com.tour.controller;


import dacn.com.tour.configuration.Environment;
import dacn.com.tour.dto.request.ConfirmTransactionRequest;
import dacn.com.tour.dto.request.CreateOrderATMRequest;
import dacn.com.tour.dto.request.CreateOrderMoMoRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.enums.ConfirmRequestType;
import dacn.com.tour.enums.RequestType;
import dacn.com.tour.model.momo.ConfirmResponse;
import dacn.com.tour.model.momo.PaymentResponse;
import dacn.com.tour.processor.ConfirmTransaction;
import dacn.com.tour.processor.CreateOrderMoMo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private Environment environment;

    @PostMapping("/confirm")
        public ApiResponse<ConfirmResponse> confirmTransactionATMType(@RequestBody ConfirmTransactionRequest confirmTransactionRequest) {
        try {
            String amount = Long.toString(confirmTransactionRequest.getAmount());
            environment = Environment.selectEnv("dev");

            ConfirmResponse confirmResponse = ConfirmTransaction.process(
                   environment,
                    confirmTransactionRequest.getOrderId(),
                    confirmTransactionRequest.getRequestId(),
                    amount,
                    ConfirmRequestType.CAPTURE,
                    ""
            );

            return ApiResponse.<ConfirmResponse>builder()
                    .code(200)
                    .result(confirmResponse)
                    .build();
        }catch (Exception e) {
            return ApiResponse.<ConfirmResponse>builder()
                    .code(500)
                    .message("Transaction confirmation failed! ")
                    .build();
        }
    }

    @PostMapping("/create/atm")
    public ApiResponse<PaymentResponse> createPaymentATM(@RequestBody CreateOrderATMRequest paymentRequestDTO) {
        try {
            String amount = Long.toString(paymentRequestDTO.getAmount());
            environment = Environment.selectEnv("dev");

            // Gọi hàm xử lý thanh toán
            PaymentResponse paymentResponse = CreateOrderMoMo.process(
                    environment,
                    paymentRequestDTO.getOrderId(),
                    paymentRequestDTO.getRequestId(),
                    amount,
                    paymentRequestDTO.getOrderInfo(),
                    paymentRequestDTO.getReturnURL(),
                    paymentRequestDTO.getNotifyURL(),
                    paymentRequestDTO.getExtraData(),
                    RequestType.PAY_WITH_ATM,
                    Boolean.TRUE
            );

            // Kiểm tra phản hồi từ MoMo
            if (paymentResponse != null && paymentResponse.getResultCode() == 0) {
                return ApiResponse.<PaymentResponse>builder()
                        .code(200)
                        .result(paymentResponse)
                        .build();
            } else {
                return ApiResponse.<PaymentResponse>builder()
                        .code(500)
                        .result(paymentResponse)
                        .message("Error occurred while processing MoMo payment!")
                        .build();
            }

        } catch (Exception e) {
            return ApiResponse.<PaymentResponse>builder()
                    .code(500)
                    .message("Error occurred while processing MoMo payment! " + e.getMessage())
                    .build();
        }
    }

    @PostMapping("/create")
    public ApiResponse<PaymentResponse> createPayment(@RequestBody CreateOrderMoMoRequest paymentRequestDTO) {
        try {
            String amount = Long.toString(paymentRequestDTO.getAmount());
            environment = Environment.selectEnv("dev");

            // Gọi hàm xử lý thanh toán
            PaymentResponse paymentResponse = CreateOrderMoMo.process(
                    environment,
                    paymentRequestDTO.getOrderId(),
                    paymentRequestDTO.getRequestId(),
                    amount,
                    paymentRequestDTO.getOrderInfo(),
                    paymentRequestDTO.getReturnURL(),
                    paymentRequestDTO.getNotifyURL(),
                    paymentRequestDTO.getExtraData(),
                    RequestType.CAPTURE_WALLET,
                    Boolean.TRUE
            );

            // Kiểm tra phản hồi từ MoMo
            if (paymentResponse != null && paymentResponse.getResultCode() == 0) {
                return ApiResponse.<PaymentResponse>builder()
                        .code(200)
                        .result(paymentResponse)
                        .build();
            } else {
                return ApiResponse.<PaymentResponse>builder()
                        .code(500)
                        .result(paymentResponse)
                        .message("Error occurred while processing MoMo payment!")
                        .build();
            }

        } catch (Exception e) {
            return ApiResponse.<PaymentResponse>builder()
                    .code(500)
                    .message("Error occurred while processing MoMo payment! " + e.getMessage())
                    .build();
        }
    }
}