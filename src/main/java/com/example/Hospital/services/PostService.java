package com.example.Hospital.services;

import com.example.Hospital.domain.Post;
import com.example.Hospital.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addNewPosition(Post post) {
        postRepository.addPosition(post);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }
}
