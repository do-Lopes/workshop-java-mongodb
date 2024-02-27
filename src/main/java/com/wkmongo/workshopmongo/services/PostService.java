package com.wkmongo.workshopmongo.services;

import com.wkmongo.workshopmongo.domain.Post;
import com.wkmongo.workshopmongo.domain.User;
import com.wkmongo.workshopmongo.dto.UserDTO;
import com.wkmongo.workshopmongo.repository.PostRepository;
import com.wkmongo.workshopmongo.repository.UserRepository;
import com.wkmongo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
