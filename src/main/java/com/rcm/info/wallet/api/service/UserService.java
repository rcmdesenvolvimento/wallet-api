package com.rcm.info.wallet.api.service;

import java.util.Optional;

import com.rcm.info.wallet.api.entity.User;

public interface UserService {

	User save(User user);

	Optional<User> findByEmail(String email);

}
