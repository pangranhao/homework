package cn.phr.controller;

import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;
import cn.phr.service.Empservice;
import cn.phr.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    @RequestMapping("exclepro")
    @ResponseBody
    public void exclepro(HttpServletResponse response,Dataparams dataparams){
        List<Emp> list=empservice.queryemptoexcel(dataparams);
        ExcelUtils.excelutil(list,response);
    }

    @RequestMapping("addempsd")
    @ResponseBody
    public Map addempsd(Emp emp){
        Map map=new HashMap();
        Emp emp1=empservice.queryempbuname(emp.getName());
        try{
            if (emp1==null){
                String deptid = emp.getDeptid();
               emp.setDeptid(deptid.substring(0,deptid.length()-2));
               emp.setLeadername(deptid.substring(2,3));
                empservice.addempsd(emp);
                map.put("code",200);
            }else {
                map.put("remark","员工们已存在！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
