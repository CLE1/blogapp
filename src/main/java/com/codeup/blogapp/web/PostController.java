package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostController {

    private final EmailService emailService;
    private final PostsRepository postsRepository;


    public PostController(EmailService emailService, PostsRepository postsRepository){
        this.emailService = emailService;
        this.postsRepository = postsRepository;
    }

    @GetMapping
    private List<Post> getPost() {
        return postsRepository.findAll();

    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.findById(id).get();
    }

    @PostMapping()
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth){

        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
        postsRepository.save(newPost);
        emailService.prepareAndSend(newPost, "what it do", "does it work or not?");
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println("updating post with id" + id);
        System.out.println(post);
        System.out.println(id);
        postsRepository.save(post);
    }

    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id) {
        System.out.println("Deleting post with id" + id);
        postsRepository.deleteById(id);
    }



}