package com.rcm.info.wallet.api.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("Fernanda");
        user.setPassword("123");
        user.serEmail("fernanda@email.com");

        User response = userRepository.save(user);
        assertNotNull(response);
    }
}
