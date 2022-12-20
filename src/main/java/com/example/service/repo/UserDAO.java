package com.example.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.UserTO;

@Repository
public interface UserDAO extends CrudRepository<UserTO,Long> {

}
