package fmi.controller;

import fmi.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import fmi.service.PostService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/posts")
@Transactional
@CrossOrigin
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(consumes = {"application/json"})
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

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PutMapping
    public void update(@RequestBody Post post) {
        postService.update(post);
    }
}
