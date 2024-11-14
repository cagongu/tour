package dacn.com.tour.controller;

import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.model.Post;
import dacn.com.tour.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private static final String POST_PATH = "/post";
    private static final String POST_PATH_ID = POST_PATH + "/{postId}";



    @PostMapping(POST_PATH)
    public ApiResponse<Post> saveNewPost(@RequestBody Post post){

        return ApiResponse.<Post>builder()
                .result(postService.createNewPost(post))
                .build();
    }

    @GetMapping(POST_PATH)
    public ApiResponse<List<Post>> getAll(){

        return ApiResponse.<List<Post>>builder()
                .result(postService.getAll())
                .build();
    }

    @PutMapping(POST_PATH_ID)
    public ApiResponse<Post> updatePost(@PathVariable("postId") Long id, @RequestBody Post post){

        return ApiResponse.<Post>builder()
                .result(postService.updatePost(post, id))
                .build();
    }

    @GetMapping(POST_PATH_ID)
    public ApiResponse<Post> getById(@PathVariable("postId") Long id){

        return ApiResponse.<Post>builder()
                .result(postService.getById(id))
                .build();
    }


}
