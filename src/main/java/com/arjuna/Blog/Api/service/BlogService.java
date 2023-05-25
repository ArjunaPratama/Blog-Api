package com.arjuna.Blog.Api.service;

import com.arjuna.Blog.Api.model.Blog;
import com.arjuna.Blog.Api.repo.BlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> blogList(){
        return (List<Blog>) blogRepository.findAllBlog();
    }

    public List<Blog> blogListById(Blog mdlBlog){
        return (List<Blog>) blogRepository.findBlogbyId(mdlBlog.getId());
    }

    public void save(Blog blogParam) {
        Blog save = blogRepository.save(blogParam);
        System.out.println(save);
    }

    public void update(Blog blog){
        blogRepository.updateBlog(blog.getId(), blog.getTitle(), blog.getBody(), blog.getAuthor());
    }

    public void delete(Blog blog){
        blogRepository.deleteBlog(blog.getId());
    }
}
