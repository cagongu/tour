package dacn.com.tour.service;


import dacn.com.tour.model.Post;

import java.util.List;


public interface PostService {
    Post createNewPost(Post post);

    Post updatePost(Post post, Long postId);

    List<Post> getAll();

    Post getById(Long id);
}
