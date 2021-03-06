package com.app.cms.adminapp;


import com.app.cms.adminapp.comon.PageVO;
import com.app.cms.adminapp.domain.User;
import com.app.cms.adminapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    PageVO vo = new PageVO();

    @Test
    public void inspect(){
        //실제 객체의 클래스 이름
        Class<?>    clz     =   userRepository.getClass();
        System.out.println("실제 객체의 클래스 이름 ; " + clz.getName());

        //interface 목록
        Class<?>[]   inerfaces = clz.getInterfaces();
        Stream.of(inerfaces).forEach(inter -> System.out.println("인터페이스 이름 : "+inter.getName()));

        //class's parents class name
        Class<?>    superClasses = clz.getSuperclass();

        System.out.println("부모 클래스 이름 : "+superClasses.getName());
    }

    @Test
    public void 계정추가(){
        User akami = new User();
        akami.setEmpNm("강백석");
        akami.setEmpId("200010001");
        akami.setEmpIp("128.0.0.1");
        akami.setLifeDateStart(new Timestamp(System.currentTimeMillis()));
        akami.setMacAddr("23:GD:5J:23:23");
        akami.setPasswd("passwoooord");
        akami.setSvcNo("01099903141");
        akami.setSessionKey("23rfef2232#wfsf23fdgdgg4gg32");
        akami.setRegEmpSeq(1);
        userRepository.save(akami);
    }

    @Test
    public  void 계정챶기(){

        //Optional<User> user = userRepository.findById();
        //System.out.println(user);
    }

    @Test
    public void 계정삭제(){

        User akami = new User();
        akami.setEmpSeq(5);
        userRepository.delete(akami);
    }

    @Test
    public void 계정200개추가(){

        int addCnt = 200;



        for(int i = 0 ; i < addCnt ; i++){
            User akami = new User();
            akami.setEmpNm("강백석"+i);
            akami.setEmpId("0000100"+i);
            akami.setEmpIp("128.0.0.1");
            akami.setLifeDateStart(new Timestamp(System.currentTimeMillis()));
            akami.setMacAddr("23:GD:5J:23:23");
            akami.setPasswd("passwoooord");
            akami.setSvcNo("01099903141");
            akami.setSessionKey("23rfef2232#wfsf23fdgdgg4gg32");
            akami.setRegEmpSeq(1);
            userRepository.save(akami);
        }

    }

    @Test
    public void 사번으로_계정_찾기(){
        Pageable page = vo.makePageble(0, "empSeq");
        userRepository.findUserByEmpId("0000100198",page).forEach(user -> System.out.println(user));
    }

    @Test
    public void 비슷한_사번으로_계정_찾기(){
        Pageable page = vo.makePageble(0, "empSeq");
        userRepository.findByEmpIdLike("0000100", page).forEach(user -> System.out.println(user));
    }

    @Test
    public void 이름으로_계정_찾기() {
        PageVO vo = new PageVO();
        Pageable page = vo.makePageble(0, "empSeq");
        userRepository.findByEmpNmContaining("강백석100", page).forEach(user -> System.out.println(user));
    }

    @Test
    public void 비슷한_이름으로_계정_찾기(){

        Pageable page = vo.makePageble(0, "empSeq");
        userRepository.findByEmpNmContaining("강백석", page).forEach(user -> System.out.println(user));
    }

    @Test
    public void 페이징과_정렬테스트(){
        Pageable paging = new PageRequest(0,10);
        Collection<User> users = userRepository.findByEmpSeqGreaterThanOrderByEmpSeqDesc(0, paging);

        users.forEach(user -> System.out.println(user));

    }

    //@Test
    //public void 페이징테스트_정렬수동(){
    //    Pageable paging = new PageRequest(0,10, Sort.Direction.ASC, "empSeq");
     //   Collection<User> users = userRepository.findByEmpSeqGreaterThan2(0, paging);
      //  users.forEach(user -> System.out.println(user));
    //}

    @Test
    public void page페이지테스트(){
        //spring boot 2.0.0
        Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "empSeq");
        //Pageable paging = new PageRequest(0,15, Sort.Direction.ASC, "empSeq");
        Page<User>  users = userRepository.findByEmpSeqGreaterThan(0, paging);

        System.out.println("Page size : "+ users.getSize());
        System.out.println("total pages : "+ users.getTotalPages());
        System.out.println("total count  : "+ users.getTotalElements());
        System.out.println("Next : "+ users.nextPageable());
        System.out.println("결과데이터 수 : "+ users.getNumberOfElements());
        System.out.println("조회된 건수 : "+ users.getContent().size());
        System.out.println("검색시 사용된 sort : "+ users.getSort());

        List<User> userList = users.getContent();

        userList.forEach(user -> System.out.println(user));

    }

    //@Test
    //public void 쿼리테스트(){
    //    userRepository.findByEmpNm("강백").forEach(user -> System.out.println(Arrays.toString(user)));
    //}

    @Test
    public void native쿼리테스트(){
        userRepository.findByEmpNmNativeQuery("강백").forEach(user -> System.out.println(Arrays.toString(user)));
    }

    @Test
    public void 페이지테스트(){

        Pageable pageable = PageRequest.of(0, 10);
        userRepository.findBypage(pageable).forEach(user -> System.out.println(user));
    }

    @Test
    public void 한명삭제() {
        userRepository.deleteById(1405);

    }

    //like empId
    @Test
    public void 아이디로검색하기() {
       // userRepository.findByEmpId("akami");
        System.out.println(userRepository.findById(1805).toString());;

    }
}
