package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    private String imageurl;

    @ManyToOne
    private AppUser ofUser;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rank rank;

    public Friend() {
    }

    public Friend(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public Friend(String name, String imageurl, Rank rank) {
        this.name = name;
        this.imageurl = imageurl;
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public AppUser getOfUser() {
        return ofUser;
    }

    public void setOfUser(AppUser ofUser) {
        this.ofUser = ofUser;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
