package com.amil.rest.webservices.restfulwebservices.jpa;

import com.amil.rest.webservices.restfulwebservices.user.Post;
import com.amil.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
