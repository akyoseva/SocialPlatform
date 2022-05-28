package controller;

import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PostService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/posts")
@Transactional
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void add(@RequestBody Post post){
        postService.add(post);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        Post post = postService.findById(id);
        postService.delete(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.findById(id);
    }
}
