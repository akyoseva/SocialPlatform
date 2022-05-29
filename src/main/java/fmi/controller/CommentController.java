package fmi.controller;

import fmi.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fmi.service.CommentService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/comments")
@Transactional
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void add(@RequestBody Comment comment){
        commentService.add(comment);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        Comment comment = commentService.findById(id);
        commentService.delete(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id){
        return commentService.findById(id);
    }
}
