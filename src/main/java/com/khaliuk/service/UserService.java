package com.khaliuk.service;

import com.khaliuk.model.User;
import java.util.Optional;

public interface UserService {

    Optional<User> authorize(User user);

}
