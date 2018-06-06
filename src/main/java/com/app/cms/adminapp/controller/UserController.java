package com.app.cms.adminapp.controller;

import com.app.cms.adminapp.comon.PageMaker;
import com.app.cms.adminapp.comon.PageVO;
import com.app.cms.adminapp.domain.User;
import com.app.cms.adminapp.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@Log
public class UserController {

    //@Autowired
    // private UserDao userDao;
    @Autowired
    private UserRepository userRepository;

    //전체 목록 조회
    //// http://localhost:8080/users/page/type/k




    @GetMapping(value = {"/users/{pageNum}/{type}/{keyword}", "/users/{pageNum}", "/users"})
    public String getList(
            @PathVariable(value = "pageNum", required = false) Integer pageNum,
            @PathVariable(value = "type", required = false) String type,
            @PathVariable(value = "keyword", required = false) String keyword,
            Model model){
        // model.addAttribute("users", userDao.getList());
        //model.addAttribute("users", userRepository.findAll());
        //model.addAttribute("message", "hello world");

        /*
        public Page<Emp> getAll(@PathVariable Integer pNo,
        		                   @PathVariable Integer size,
        		                   @PathVariable String sort) {
        	   PageRequest request = new PageRequest(pNo-1,
								        			   size,
								        			   Sort.Direction.DESC,
								        			   sort);
         */

        System.out.println("============================");
        System.out.println("pageNum : " + pageNum);
        System.out.println("type : " + type);
        System.out.println("keyword : " + keyword);
        PageVO vo = new PageVO();

        if(pageNum != null)
        vo.setPage(pageNum);

        Pageable page = vo.makePageble(0, "empSeq");

        //Pageable page = vo.makePageble(0, "empSeq");
        log.info("" + page);

        Page<User> users = userRepository.findByEmpSeqGreaterThan(0, page);


            //spring boot 2.0.0
            //Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "empSeq");
            //Pageable paging = new PageRequest(0,15, Sort.Direction.ASC, "empSeq");
            //Page<User> users = userRepository.findByEmpSeqGreaterThan(0, paging);

            System.out.println("Page size : "+ users.getSize());
            System.out.println("total pages : "+ users.getTotalPages());
            System.out.println("total count  : "+ users.getTotalElements());
            System.out.println("Next : "+ users.nextPageable());
            System.out.println("결과데이터 수 : "+ users.getNumberOfElements());
            System.out.println("조회된 건수 : "+ users.getContent().size());
            System.out.println("검색시 사용된 sort : "+ users.getSort());

            List<User> userList = users.getContent();

           // userList.forEach(user -> System.out.println(user));
        //model.addAttribute("users", userList);
        model.addAttribute("page", new PageMaker(users));
        //model.addAttribute("userPage", users);

        return "user/userlist";
    }

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

    @GetMapping("/user/add")
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
