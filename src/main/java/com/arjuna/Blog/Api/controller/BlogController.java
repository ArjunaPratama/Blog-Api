package com.arjuna.Blog.Api.controller;


import com.arjuna.Blog.Api.model.blog;
import com.arjuna.Blog.Api.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/getblog")
    public ResponseEntity<Object> getallbloglist(){
        List<blog> bloglist =  blogService.blogList();
        return new ResponseEntity<Object>(bloglist,HttpStatus.OK);
    }

    @PostMapping("/save")
    public blog saveBlog(@RequestBody blog Blog) {
        blogService.save(Blog);
        return Blog;
    }

    @PostMapping("/update")
    public void updateBlog(@RequestBody blog Blog) {
        blogService.update(Blog);
    }

    @PostMapping("/delete")
    public void deleteblog(@RequestBody blog Blog) {
        blogService.delete(Blog);
    }


    @PostMapping("/getblog-by-id")
    public List<blog> getblogbyid(@RequestBody blog Blog){
        List<blog> bloglist;
        bloglist  = blogService.blogListById(Blog);
        return bloglist;
    }



}
