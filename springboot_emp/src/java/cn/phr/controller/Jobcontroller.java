package cn.phr.controller;

import cn.phr.entity.po.Job;
import cn.phr.service.Jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("job")
@CrossOrigin
public class Jobcontroller {
    @Autowired
    private Jobservice jobservice;

    @RequestMapping("queryjob")
    @ResponseBody
    public List<Job>queryjob(){
        List<Job>list=jobservice.queryjob();
        return list;
    }
}
