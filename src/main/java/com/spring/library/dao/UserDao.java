package com.spring.library.dao;

import com.spring.library.model.User;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
public interface UserDao {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public boolean addUser(User user);
    public boolean updateUser(int id, User user);
    public boolean deleteUser(int id);
}
