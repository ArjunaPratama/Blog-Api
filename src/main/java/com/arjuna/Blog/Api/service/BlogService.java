package com.arjuna.Blog.Api.service;

import com.arjuna.Blog.Api.model.blog;
import com.arjuna.Blog.Api.repo.BlogRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<blog> blogList(){
        return (List<blog>) blogRepository.findAllBlog();
    }

    public List<blog> blogListById(blog mdlBlog){
        return (List<blog>) blogRepository.findBlogbyId(mdlBlog.getId());
    }

    public void save(blog Blog) {
        blogRepository.insertBlog(Blog.getId(), Blog.getTitle(), Blog.getBody(), Blog.getAuthor());
        System.out.println(Blog.getId());
    }

    public void update(blog Blog){
        blogRepository.updateBlog(Blog.getId(), Blog.getTitle(), Blog.getBody(), Blog.getAuthor());
    }

    public void delete(blog Blog){
        blogRepository.deleteBlog(Blog.getId());
    }
}
