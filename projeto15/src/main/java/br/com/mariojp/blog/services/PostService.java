package br.com.mariojp.blog.services;

import br.com.mariojp.blog.models.Post;
import br.com.mariojp.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> findAllOrderByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"dateTime");
        return postRepository.findAll(sort);
    }



}
