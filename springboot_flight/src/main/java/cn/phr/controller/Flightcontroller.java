package cn.phr.controller;

import cn.phr.entity.po.Flight;
import cn.phr.entity.po.Ticket;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;
import cn.phr.service.Flightservice;
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
@CrossOrigin
@RequestMapping("flight")
public class Flightcontroller {
    @Autowired
    private Flightservice flightservice;


    @RequestMapping("queryflight")
    @ResponseBody
    public DataTablesData queryflight(Dataparams dataparams){
        DataTablesData<Flight>data=flightservice.queryflight(dataparams);
        return data;
    }

    @RequestMapping("queryid")
    @ResponseBody
    public Flight queryid(Integer id){
        Flight flight=flightservice.queryid(id);
        return flight;
    }

    @RequestMapping("updateisup")
    @ResponseBody
    public Map updateisup(Flight flight){
        Map map=new HashMap();
        try{
            flightservice.updateisup(flight);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    @RequestMapping("updateisupall")
    @ResponseBody
    public Map updateisupall(String str){
        Map map=new HashMap();
        try{
            flightservice.updateisupall(str);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("addflight")
    @ResponseBody
    public Map addflight(Flight flight,Ticket ticket){
        Map map=new HashMap();
        try{
            String startterminalid = flight.getStartterminalid();
            flight.setStartterminalid(startterminalid.substring(2,startterminalid.length()-2));
            String endterminalid = flight.getEndterminalid();
            flight.setEndterminalid(endterminalid.substring(2,endterminalid.length()-2));
            flight.setIsup(1);
            flightservice.addflight(flight,ticket);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("Excelpro")
    public void Excelpro(HttpServletResponse response){
        List<Flight>list=flightservice.queryflightbylist();
        ExcelUtils.excelutil(list,response);
    }
    @RequestMapping("updateflight")
    @ResponseBody
    public Map updateflight(Flight flight){
        Map map=new HashMap();
        try{
            flightservice.updateflight(flight);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
