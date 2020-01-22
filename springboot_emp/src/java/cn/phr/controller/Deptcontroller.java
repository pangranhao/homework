package cn.phr.controller;

import cn.phr.entity.po.Dept;
import cn.phr.service.Deptservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dept")
@CrossOrigin
public class Deptcontroller {
    @Autowired
    private Deptservice deptservice;


    @RequestMapping("querydept")
    @ResponseBody
    public List<Dept>querydept(){
        List<Dept>list=deptservice.querydept();
        return list;
    }
}
