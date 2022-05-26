package br.com.mariojp.blog.repositories;

import br.com.mariojp.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}