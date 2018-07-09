package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "rank")
    private Set<Friend> rankedFriends;

    private int numeric;
    private String adjective;

    public Rank() {
        this.rankedFriends = new HashSet<>();
    }

    public Rank(int number, String adjective) {
        this.numeric = number;
        this.adjective = adjective;
        this.rankedFriends = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Friend> getRankedFriends() {
        return rankedFriends;
    }

    public void setRankedFriends(Set<Friend> rankedFriends) {
        this.rankedFriends = rankedFriends;
    }

    public void addRankedFriend(Friend friend){
        rankedFriends.add(friend);
    }

    public int getNumeric() {
        return numeric;
    }

    public void setNumeric(int numeric) {
        this.numeric = numeric;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }
}
