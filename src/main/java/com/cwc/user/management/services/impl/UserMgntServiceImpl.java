package com.cwc.user.management.services.impl;

import com.cwc.user.management.entity.UserMgnt;
import com.cwc.user.management.model.User;
import com.cwc.user.management.repository.UserMgntRepository;
import com.cwc.user.management.services.UserMgntService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserMgntServiceImpl implements UserMgntService {

    @Autowired
    private UserMgntRepository userMgntRepository;

    @Override
    public User addUserDetails(User user) {
        //generated id
        String userId = UUID.randomUUID().toString();
        System.out.println("////////////////////////////" + userId);
        UserMgnt userMgnt =  new UserMgnt();
        user.setUserId(userId);

        BeanUtils.copyProperties(user,userMgnt);
        userMgntRepository.save(userMgnt);
        return user;
    }

    @Override
    public User updateUserDetails(String userId,User user) {
       UserMgnt userMgnt = userMgntRepository.findById(userId).get();
        userMgnt.setFirstname(user.getFirstname());
        userMgnt.setLastname(user.getLastname());
        userMgnt.setEmailId(user.getEmailId());
        userMgntRepository.save(userMgnt);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        //Interact with database
        List<UserMgnt> userMgntList = userMgntRepository.findAll();
        //Interact with controller
       List<User> users =  userMgntList
                .stream()
                .map(userMgnt -> new User(
                        userMgnt.getUserId(),
                        userMgnt.getFirstname(),
                        userMgnt.getLastname(),
                        userMgnt.getEmailId()
                )).collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(String userId) {
      UserMgnt userMgnt = userMgntRepository.findById(userId).get();
        User user = new User();
        BeanUtils.copyProperties(userMgnt,user);
        return user;
    }

    @Override
    public boolean deleteUserById(String userId) {
    UserMgnt userMgnt = userMgntRepository.findById(userId).get();
    userMgntRepository.delete(userMgnt);
        return true;
    }

    @Override
    public UserMgnt searchUserByKeyWord(String keyword) {
        return null;
    }
}
