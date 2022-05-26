package br.com.mariojp.blog.controller;

import br.com.mariojp.blog.models.Post;
import br.com.mariojp.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {


    @Autowired
    private PostService postService;


    @GetMapping(path = {"","/index"})
    public String index(Model model ){
        List<Post> posts = postService.findAllOrderByDate();
        model.addAttribute("posts",posts);
        return "index";
    }

}
