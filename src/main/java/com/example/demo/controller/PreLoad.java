package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class PreLoad {
    @Autowired
    AppUserRepository users;

    @Autowired
    UserRoleRepository roles;

    @Autowired
    FriendRepository friends;

    @Autowired
    RankRepository ranks;

    @PostConstruct() public void setRanks(){
        //higher number, better friendship
        Rank rank = new Rank(8, "Bad Friend"); ranks.save(rank);
        rank = new Rank(9, "Ok Friend"); ranks.save(rank);
        rank = new Rank(10, "Fav Friend"); ranks.save(rank);
    }

    @PostConstruct() public void addFriend(){

    }
}
