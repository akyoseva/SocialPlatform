package fmi.service;

import fmi.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.repository.CommentRepository;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void add(Comment comment){
        commentRepository.save(comment);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }

    public Comment findById(Long id){
        return commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Comment doesn't exist."));
    }
}
