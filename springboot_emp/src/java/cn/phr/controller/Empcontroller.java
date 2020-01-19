package cn.phr.controller;

import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;
import cn.phr.service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("emp")
@CrossOrigin
public class Empcontroller {
    @Autowired
    private Empservice empservice;

    @RequestMapping("queryemp")
    @ResponseBody
    public DataTablesData queryemp(Dataparams dataparams){
        DataTablesData<Emp>data=empservice.queryemp(dataparams);
        return data;
    }
    @RequestMapping("deleteemp")
    @ResponseBody
    public Map deleteemp(Integer id){
        Map map=new HashMap();
        try{
            empservice.deleteemp(id);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("deleteempall")
    @ResponseBody
    public Map deleteempall(String str){
        Map map=new HashMap();
        try{
            empservice.deleteempall(str);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
