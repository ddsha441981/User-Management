package com.cwc.user.management.repository;

import com.cwc.user.management.entity.UserMgnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMgntRepository extends JpaRepository<UserMgnt ,String> {

}
