package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {



    @GetMapping
    private List<Post> getPosts() {
        User user = new User("Espi");
        List<Category> categories = new ArrayList<>(){{

            add(new Category(1L, "Spring boot"));
            add(new Category(2L, "What in the hell bobby"));
        }};

        return new ArrayList<Post>() {{
            add(new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", user, categories));
            add(new Post(2L, "A new Post",
                    "this is a brilliant post. 11/10", user, categories));
            add(new Post(3L, "A new Post",
                    "this is a brilliant post. 12/10", user, categories));

        }};

    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        User user = new User("Espi");
        if (id == 1) {
            return new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", user, categories);
        } else {
            return null;
        }
    }

    @PostMapping()
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping({"/{id}"})
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post);
        System.out.println(id);
    }

    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println(id);
    }


}
