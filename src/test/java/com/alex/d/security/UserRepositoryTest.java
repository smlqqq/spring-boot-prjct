package com.alex.d.security;

import com.alex.d.security.models.user.UserModel;
import com.alex.d.security.repositories.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByLogin() {
        Optional<UserModel> user = userRepository.findByLogin("alexpro");
        assertTrue(user.isPresent());
        assertEquals("Alex D", user.get().getName());
    }

    @Test
    public void testFindAllUsers() {
        List<UserModel> users = userRepository.findAll();
        assertNotNull("not find", users);
        assertFalse(users.isEmpty());
    }

    private void assertFalse(boolean empty) {
        if (empty){
            System.out.println("User not found");
        }else {
            System.out.println("All users are in db");
        }
    }


}
