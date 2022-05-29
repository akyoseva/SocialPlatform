package fmi.service;

import fmi.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.repository.PostRepository;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void add(Post post){
        postRepository.save(post);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }

    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Post with this id " + id +" doesn't exist."));
    }
}
