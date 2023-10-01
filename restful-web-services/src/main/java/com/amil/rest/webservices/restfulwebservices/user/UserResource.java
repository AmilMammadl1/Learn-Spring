package com.amil.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.amil.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.amil.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;

@RestController
public class UserResource {
    //    @Autowired
//    UserDaoService userDaoService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/users")
    public List<User> retrieveAllUser() {
        return userRepository.findAll();
//        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id) {
//        User user = userDaoService.findById(id);
        User user = userRepository.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("can not find id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user2 = userRepository.save(user);
//        User user2 = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user2.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Integer id) {
//        userDaoService.deleteById(id);
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("can not find id: " + id);
        }
        return user.getPostList();
    }
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = userRepository.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("can not find id: " + id);
        }
        post.setUser(user);
        Post post2 = postRepository.save(post);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
