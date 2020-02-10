package cn.phr.controller;

import cn.phr.entity.po.Types;
import cn.phr.service.Typeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("type")
public class Typecontroller {

    @Autowired
    private Typeservice typeservice;

    @RequestMapping("querytype")
    @ResponseBody
    public List<Types>querytype(){
        List<Types>list=typeservice.querytype();
        return list;
    }
}
