package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostsRepository postsRepository;

    public PostController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    @GetMapping
    private List<Post> getPost() {
        return postsRepository.findAll();

    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.getById(id);
    }

    @PostMapping()
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
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