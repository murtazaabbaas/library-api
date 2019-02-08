package com.spring.library.service.impl;

import com.spring.library.dao.UserDao;
import com.spring.library.model.User;
import com.spring.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(int id, User user) {
        return userDao.updateUser(id, user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
