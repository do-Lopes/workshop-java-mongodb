package com.wkmongo.workshopmongo.repository;

import com.wkmongo.workshopmongo.domain.Post;
import com.wkmongo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
