package com.example.demoClass8.service;

import com.example.demoClass8.entity.Post;
import com.example.demoClass8.entity.PostComment;
import com.example.demoClass8.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

//this is actually the interface
//if you want .Lazy you need SQL way of writing

@Configuration
public class DatabaseInitializer {
    //() inside set the service you will use
    @Bean
    CommandLineRunner configureDatabase(PostAndCommentService postAndCommentService, PostRepository postRepository){
        return args -> {
            Post post1 = new Post("First post", LocalDate.of(2026, 04, 15), null);
            Post post2 = new Post("Second post", LocalDate.of(2026, 04, 22), null);
            postAndCommentService.savePost(post1);
            postAndCommentService.savePost(post2);

            //lista od komenatrite
            List<PostComment> comments = List.of(
                    new PostComment("First comment - first post", LocalDate.of(2026, 04, 15), post1),
                    new PostComment("Second comment - first post", LocalDate.of(2026, 04, 16), post1),
                    new PostComment("First comment - second post", LocalDate.of(2026, 04, 22), post2),
                    new PostComment("Second comment - second post", LocalDate.of(2026, 04, 23), post2),
                    new PostComment("Third comment - second post", LocalDate.of(2026, 04, 24), post2)
            );

            postAndCommentService.saveComments(comments);

            postAndCommentService.getCommentsByDate(post1.getId(), LocalDate.of(2026, 01, 01)).forEach(
                    comment -> System.out.println(comment.getText())
            );
            Post post = postRepository.findById(post1.getId()).get();
            post.getPostComments().forEach(comment -> System.out.println(comment.getText()));

        };
    }
}
