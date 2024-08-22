package com.rcm.info.wallet.api.repository;

import com.rcm.info.wallet.api.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final String EMAIL = "email@email.com";

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User();
        user.setName("Fernanda");
        user.setPassword("123");
        user.setEmail("email@email.com");
        userRepository.save(user);
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setName("Fernanda");
        user.setPassword("123");
        user.setEmail("email@email.com");

        User response = userRepository.save(user);
        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {
        Optional<User> response = userRepository.findByEmailEquals(EMAIL);
        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
