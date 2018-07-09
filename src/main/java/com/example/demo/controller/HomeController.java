package com.example.demo.controller;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.config.CloudinaryConfig;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    AppUserRepository users;

    @Autowired
    UserRoleRepository roles;

    @Autowired
    FriendRepository friends;

    @Autowired
    RankRepository ranks;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/friends")
    public String showFriendsList(Principal principal, Model model) {
        List<Friend> userFriends = (List) friends.findAllByOfUser_Username(principal.getName());
        Collections.sort(userFriends, (a, b) -> Integer.compare(b.getRank().getNumeric(), a.getRank().getNumeric()));
        model.addAttribute("friends", userFriends);
        return "friends";
    }

    @GetMapping("/addfriend")
    public String getFriend(Model model) {
        model.addAttribute("ranks", ranks.findAll());
        model.addAttribute("friend", new Friend());
        return "addfriend";
    }

    @PostMapping("/addfriend")
    public String saveFriend(Principal principal, @Valid @ModelAttribute("friend") Friend friend, BindingResult result, @RequestParam("file") MultipartFile file, RedirectAttributes rediAtt) {

        if (result.hasErrors() || file.isEmpty()) {
            rediAtt.addFlashAttribute("emptyFile", file.isEmpty());
            rediAtt.addFlashAttribute("nameErr", result.hasFieldErrors());
            return "redirect:/addfriend";
        }

        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            friend.setImageurl(uploadResult.get("url").toString());
            friend.setOfUser(users.findByUsername(principal.getName()));
            friends.save(friend);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/addfriend";
        }

        return "redirect:/friends";
    }

    @GetMapping("/register")
    public String regiter(Model model) {
        model.addAttribute("user", new AppUser());
        return "registerform";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user, BindingResult result, Principal principal, Model model) {

        AppUser currentUser = ((AppUser)result.getModel().get("user"));
        if(users.existsByUsername(currentUser.getUsername())){
            model.addAttribute("usernameErr", users.existsByUsername(currentUser.getUsername()));
            return "registerform";
        }

        UserRole role = new UserRole("USER");
        roles.save(role);

        user.addRole(role);
        users.save(user);
        return "redirect:/";
    }
}
