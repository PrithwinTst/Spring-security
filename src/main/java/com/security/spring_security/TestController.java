package com.security.spring_security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"ram"),
            new Student(2,"raj")
    ));

    @GetMapping("/hello")
    public String getHello(HttpServletRequest request){
        return "Hello boii"+request.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> getAll(){
        return students;
    }
    @PostMapping("/students")
    public List<Student> getAll(@RequestBody Student student){
        students.add(student);
        return students ;
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return(CsrfToken) request.getAttribute("_csrf");
    }
}
