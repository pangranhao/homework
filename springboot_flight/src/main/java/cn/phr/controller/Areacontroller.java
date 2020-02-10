package cn.phr.controller;

import cn.phr.entity.po.Areas;
import cn.phr.service.Areaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("area")
public class Areacontroller {
    @Autowired
    private Areaservice areaservice;

    @RequestMapping("queryarea")
    @ResponseBody
    public List<Areas>queryarea(){
        List<Areas> list=areaservice.queryarea();
        return list;
    }
}
