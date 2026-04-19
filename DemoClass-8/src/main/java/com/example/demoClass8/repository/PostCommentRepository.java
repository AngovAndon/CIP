package com.example.demoClass8.repository;

import com.example.demoClass8.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    Optional<PostComment> findById(Long id);

    List<PostComment> findByPostIdAndDateAfter(Long postId, LocalDate date);

    List<PostComment> findByTextContaining(String text);

}
