package com.example.demoClass8.repository;

import com.example.demoClass8.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//metodite so koi pristapuvas vo bazata
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

    List<Post> findByDateBefore(LocalDate date);

    List<Post> findByTextContaining(String text);
}
