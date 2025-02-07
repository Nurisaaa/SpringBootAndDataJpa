package peaksoft.springbootanddatajpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootanddatajpa.entities.Post;
import peaksoft.springbootanddatajpa.service.PostService;

@Controller
@RequestMapping("/post/{userId}")
public class PostApi {
    private final PostService postService;

    @Autowired
    public PostApi(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getAll(Model model, @PathVariable Long userId){
        model.addAttribute("posts",
                postService.getAllPostByUserId(userId));
        return "allPosts";
    }

    @GetMapping("/new")
    public String create(Model model ,@PathVariable Long userId){
        model.addAttribute("newPost",new Post());
        model.addAttribute("userId",userId);
        return "/newPost";
    }
    @PostMapping("/save")
    public String savePost(@ModelAttribute("newPost") Post post,
                           @PathVariable Long userId){
        postService.savePost(userId,post);
        return "redirect:/post/" + userId;
    }

    @GetMapping("/search")
    public String search(@RequestParam String word,Model model){
        model.addAttribute("posts",
                postService.searchPostByName(word));
        model.addAttribute("word",word);
        return "searchResult";
    }
}
