package com.project;

import com.project.user.User;
import com.project.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    public void TestAddNew() {
        User user = new User();
        user.setEmail("test388@gmail.com");
        user.setPassword("12345");
        user.setFirstName("Tester");
        user.setLastName("Testing");
        User savedUser = repo.save(user);

        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedUser.getId());
    }

    @Test
    public void TestListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertNotNull(users);

        for (User user : users)
            System.out.println(user);
    }

    @Test
    void TestUpdate() {
        Optional<User> optionalUser = repo.findById(1);
        User user = optionalUser.get();
        user.setPassword("12Test");
        repo.save(user);

        Assertions.assertEquals(repo.findById(1).get().getPassword(), "12Test");
    }

    @Test
    public void TestGet() {
        Optional<User> optionalUser = repo.findById(1);
        Assertions.assertTrue(optionalUser.isPresent());
        System.out.println(optionalUser.get());
    }
}
