package com.arjuna.Blog.Api.repo;

import com.arjuna.Blog.Api.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from mst_blog", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from mst_blog where id = :id", nativeQuery = true)
    List<Blog> findBlogbyId(@Param("id") Integer id);

    @Modifying
    @Query(value = "INSERT INTO mst_blog (id, title, body, author) values (:id,:title,:body,:author)", nativeQuery = true)
    int insertBlog(@Param("id")  Integer id, @Param("title") String title, @Param("body") String body, @Param("author") String author);

    @Modifying
    @Query(value = "Update mst_blog  set title = :title, body = :body, author = :author where id = :id", nativeQuery = true)
    void updateBlog(@Param("id")  Integer id, @Param("title") String title, @Param("body") String body, @Param("author") String author);

    @Modifying
    @Query(value = "Delete FROM mst_blog where id = :id", nativeQuery = true)
    void deleteBlog(@Param("id")  Integer id);
}
