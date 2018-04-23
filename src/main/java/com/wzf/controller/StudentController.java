package com.wzf.controller;

import com.wzf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/add")
    public String addStudent(){
        return "/student/add";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteStudent(){
        return "/student/delete";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateStudent(){
        return "/student/update";
    }

    @ResponseBody
    @RequestMapping("/select")
    public String selectStudent(){
        return "/student/select";
    }
}
