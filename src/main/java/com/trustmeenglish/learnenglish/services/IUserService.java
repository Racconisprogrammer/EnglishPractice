package com.trustmeenglish.learnenglish.services;

import com.trustmeenglish.learnenglish.entity.User;

import java.util.List;

public interface IUserService {

    User getUser(Long id);

    List<User> getAllUsers();

}
