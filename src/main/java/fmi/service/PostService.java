package fmi.service;

import fmi.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.repository.PostRepository;

import java.util.List;

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
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void update(Post post) {
        Post oldPost = postRepository.findById((post.getId())).orElseThrow(()->
                new IllegalArgumentException("Post with this id " + post.getId() +" doesn't exist."));
        oldPost.setDescription(post.getDescription());
        oldPost.setTitle(post.getTitle());
    }
}
