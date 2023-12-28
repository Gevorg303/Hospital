package com.example.Hospital.controllers;

import org.springframework.ui.Model;
import com.example.Hospital.domain.Post;
import com.example.Hospital.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post()); // Added for form binding
        return "posts";
    }

    @PostMapping("/add")
    public String addNewPost(@ModelAttribute("newPost") Post newPost) {
        postService.addNewPosition(newPost);
        return "redirect:/posts/all";
    }
}