package peaksoft.springbootanddatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springbootanddatajpa.entities.Post;
import peaksoft.springbootanddatajpa.entities.User;
import peaksoft.springbootanddatajpa.repository.PostRepository;
import peaksoft.springbootanddatajpa.repository.UserRepository;

import java.util.List;
@Service

@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }


    @Override
    public void savePost(Long userId, Post post) {
        User user = userRepo.findById(userId).orElseThrow(() ->
                new NullPointerException(String.format("User with id %s not found",userId)));
        post.setUser(user);
        postRepo.save(post);
    }

    @Override
    public List<Post> getAllPostByUserId(Long userId) {
        return postRepo.getAllPostByUserId(userId);
    }

    @Override
    public Post getById(Long postId) {
        return null;
    }

    @Override
    public void updatePost(Long postId, Post newPost) {

    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public Post searchPostByName(String word) {
        return postRepo.searchPostByTitle(word);
    }
}
