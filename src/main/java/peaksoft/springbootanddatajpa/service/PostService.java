package peaksoft.springbootanddatajpa.service;

import peaksoft.springbootanddatajpa.entities.Post;

import java.util.List;

public interface PostService {
    void savePost(Long userId, Post post);
    List<Post> getAllPostByUserId(Long userId);
    Post getById(Long postId);
    void updatePost(Long postId,Post newPost);
    void deletePost(Long postId);


    Post searchPostByName(String word);
}
