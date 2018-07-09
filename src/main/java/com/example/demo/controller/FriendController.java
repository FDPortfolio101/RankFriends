package com.example.demo.controller;


/*
import com.example.demo.config.CloudinaryConfig;
import com.example.demo.model.Friend;
import com.example.demo.model.UserRoleRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private CloudinaryConfig cloudc;

    @Autowired
    FriendService friends;

    @Autowired
    UserRoleRepository role;

    @RequestMapping("/")
    public String showFriends(Model model, Authentication authentication)
    {
        model.addAttribute("myFriends", friends.getMyFriends(authentication));
        if (authentication.getAuthorities().contains(roles.findByRole("ADMIN")))
            return "redirect:/frineds/ranked";
        else
            return "/friends/list";
    }
    @RequestMapping("/add")
    public String addFriend (Model model)
    {
        model.addAttribute("aFriend", new Friend());
        return "/friends/add";
    }
    @RequestMapping("/save")
    public String saveFriend (@ModelAttribute("aFriend") Friend theFriend, Authentication myDetails, MultipartHttpServletRequest request)
    {
        MultipartFile f = request.getFile("file");
        if (f!=null && !f.isEmpty()){
            try{
                Map uploadResult
            }
        }
    }

}
*/
