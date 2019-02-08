package com.spring.library.dao.impl;

import com.spring.library.dao.UserDao;
import com.spring.library.model.User;
import com.spring.library.util.FileSystemDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    FileSystemDataHolder fileSystemDataHolder;

    @Override
    public List<User> getAllUsers() {
        return fileSystemDataHolder.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return fileSystemDataHolder.getUsers().stream().filter( r -> r.getId() == id).findFirst().get();
    }

    @Override
    public boolean addUser(User user) {
        boolean addStatus = fileSystemDataHolder.getUsers().add(user);
        fileSystemDataHolder.persistUsersData();
        return addStatus;
    }

    @Override
    public boolean updateUser(int id, User user) {
        if(deleteUser(id)) {
            boolean addStatus = fileSystemDataHolder.getUsers().add(user);
            fileSystemDataHolder.persistUsersData();
            return addStatus;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean removeStatus =  fileSystemDataHolder.getUsers().removeIf(x -> x.getId() == id);
        fileSystemDataHolder.persistUsersData();
        return removeStatus;
    }
}
