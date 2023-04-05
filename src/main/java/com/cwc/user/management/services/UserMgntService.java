package com.cwc.user.management.services;

import com.cwc.user.management.entity.UserMgnt;
import com.cwc.user.management.model.User;


import java.util.List;

public interface UserMgntService {
    public User addUserDetails(User user);
    public User updateUserDetails(String userId,User user);
    public List<User> getAllUser();
    public User getUserById(String userId);
    public boolean deleteUserById(String userId);
    //Business methods
    public UserMgnt searchUserByKeyWord(String keyword);
}
