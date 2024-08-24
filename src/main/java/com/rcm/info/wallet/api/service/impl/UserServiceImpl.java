package com.rcm.info.wallet.api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rcm.info.wallet.api.entity.User;
import com.rcm.info.wallet.api.repository.UserRepository;
import com.rcm.info.wallet.api.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public User save(User user) {
		return this.repository.save(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return this.repository.findByEmailEquals(email);
	}

}
