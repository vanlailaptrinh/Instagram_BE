package com.instagram;

import com.instagram.model.entity.CommentDomainEntity;
import com.instagram.model.entity.UserDomainEntity;
import com.instagram.services.comment.CommentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentServices commentServices;

    @GetMapping("/parentComments/{id}")
    public List<CommentDomainEntity> getCommentsByParent(@PathVariable UUID parentId) {
        return commentServices.getByParentCommentId(parentId);
    }

    @GetMapping("/postComments/{id}")
    public List<CommentDomainEntity> getCommentsByPost(@PathVariable UUID postId) {
        return commentServices.getByPostId(postId);
    }

    @PostMapping("/create")
    public CommentDomainEntity createUser(@RequestBody CommentDomainEntity comment) {
        return commentServices.createComment(comment);
    }

    @PutMapping("/update")
    public CommentDomainEntity updateComment(@RequestBody CommentDomainEntity comment) {
        return commentServices.updateComment(comment);
    }

    @PatchMapping("/reply/{parentId}")
    public CommentDomainEntity replyComment(@RequestBody CommentDomainEntity comment, @PathVariable UUID parentId) {
        return commentServices.replyComment(comment, parentId);
    }

    @DeleteMapping("{userId}/delete/{commentId}")
    public void deleteComment(@PathVariable UUID userId, @PathVariable UUID commentId) {
        commentServices.deleteComment(commentId, userId);
    }

}
