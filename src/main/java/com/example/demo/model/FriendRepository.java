package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    Iterable<Friend> findAllByOfUser_Username(String username);
}
