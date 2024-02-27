package com.jobsearch.joblist.Controller;

import com.jobsearch.joblist.Model.Post;
import com.jobsearch.joblist.Repository.OwnRepo;
import com.jobsearch.joblist.Repository.PostRepository;
import com.jobsearch.joblist.SearchOwn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    OwnRepo newrepo;
    @RequestMapping("/posts")
    @CrossOrigin
    public List<Post> getallposts()
    {
        return repo.findAll();
    }
    @GetMapping("posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return newrepo.findbyText(text);
    }
    @PostMapping("/posts")
    @CrossOrigin
    public Post addpost(@RequestBody Post post)
    {
        repo.save(post);
        return post;
    }

}
