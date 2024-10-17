package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID idPost;

    String titlePost;
    String Description;
    String contentPost;//Nội dung bài viết (html)
    String status;
    int vote;
    String type;
    int view;

    UUID tagId;

    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
//    Timestamp dateDeleted;

    @ManyToOne
    Account account;

}
