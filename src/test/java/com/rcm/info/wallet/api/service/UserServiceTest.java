package com.rcm.info.wallet.api.service;

import com.rcm.info.wallet.api.entity.User;
import com.rcm.info.wallet.api.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class UserServiceTest {

	@MockBean
	UserRepository repository;

	@Autowired
	UserService service;

	@Before
	public void setUp() {
		BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
	}

	@Test
	public void testFindByEmail() {
		Optional<User> user = service.findByEmail("email@email.com");
		assertTrue(user.isPresent());
	}

}
