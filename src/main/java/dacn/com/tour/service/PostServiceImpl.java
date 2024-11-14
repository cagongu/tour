package dacn.com.tour.service;

import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.model.Post;
import dacn.com.tour.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post createNewPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post, Long postId) {
        Post updated = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_FOUND));

        if(StringUtils.hasText(post.getContentPost())){
            updated.setContentPost(post.getContentPost());
        }

        if(StringUtils.hasText(post.getDescription())){
            updated.setContentPost(post.getDescription());
        }

        if(StringUtils.hasText(post.getTitlePost())){
            updated.setContentPost(post.getTitlePost());
        }

        return postRepository.save(updated);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }



    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).get();
    }
}
