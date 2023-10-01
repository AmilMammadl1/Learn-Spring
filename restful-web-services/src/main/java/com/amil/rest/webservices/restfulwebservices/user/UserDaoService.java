package com.amil.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int count = 0;

    static {
        users.add(new User(++count, "Amil", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "Ayaz", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "Test", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
