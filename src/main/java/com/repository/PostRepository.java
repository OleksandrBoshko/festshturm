package com.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{
	public Post findOneBySlug (String slug);
	public Post findOneById(int parseInt);
	@Query("SELECT p FROM Post p where p.slug = :slugg order by p.publishedDate desc") 
	Iterable<Post> findPostsBySlug(@Param("slugg") String slug);

}
