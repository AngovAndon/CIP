package com.example.demoClass8.service;

import com.example.demoClass8.entity.Post;
import com.example.demoClass8.entity.PostComment;
import com.example.demoClass8.repository.PostCommentRepository;
import com.example.demoClass8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostAndCommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<Post> getPostsBeforeDate(LocalDate date){
        return postRepository.findByDateBefore(date);
    }

    public List<Post> getPostsContainingText(String text){
        return postRepository.findByTextContaining(text);
    }

    public List<PostComment> getCommentsByDate(Long postId,LocalDate date){
        return postCommentRepository.findByPostIdAndDateAfter(postId, date);
    }

    public List<PostComment> getCommentsContainingText(String text){
        return postCommentRepository.findByTextContaining(text);
    }


    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public PostComment saveComment(PostComment postComment){
        return postCommentRepository.save(postComment);
    }

    public List<PostComment> saveComments(List<PostComment> comments){
        return postCommentRepository.saveAll(comments);
    }
}
