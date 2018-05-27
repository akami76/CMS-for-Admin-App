package com.app.cms.adminapp.controller;

import com.app.cms.adminapp.domain.vo.User;
import com.app.cms.adminapp.domain.vo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class UserController {

    //@Autowired
    // private UserDao userDao;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/users2")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello world\"");
        return "users";
    }

    @GetMapping("/user2/list")
    public String getList2(Model model){
       // model.addAttribute("users", userDao.getList());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("message", "hello world");
        return "users";
    }
    @GetMapping("/user/list")
    public String getList(Model model){
        // model.addAttribute("users", userDao.getList());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("message", "hello world");
        return "userlist";
    }
    @GetMapping("/user/addForm")
    public String userAddForm(){
        return "addForm";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("serverTime", "24:00:00");
        return "home";
    }

    @GetMapping("/layout")
    public void layout(Model model){
    }


    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setEmpId("akami");
        user.setEmpNm("관리자");
        userRepository.save(user);
        return "Saved";
    }
}
