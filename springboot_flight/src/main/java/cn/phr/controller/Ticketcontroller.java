package cn.phr.controller;

import cn.phr.entity.po.Ticket;
import cn.phr.service.Ticketservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("ticket")
public class Ticketcontroller {
    @Autowired
    private Ticketservice ticketservice;

    @RequestMapping("queryticketid")
    @ResponseBody
    public Ticket queryticketid(Integer id){
        Ticket ticket=ticketservice.queryticketid(id);
        return ticket;
    }

    @RequestMapping("updateticket")
    @ResponseBody
    public Map updateticket(Ticket ticket){
        Map map=new HashMap();
        try{
            ticketservice.updateticket(ticket);
            map.put("code",200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("queryticket")
    @ResponseBody
    public List<Ticket>queryticket(){
        List<Ticket>list=ticketservice.queryticket();
        return list;
    }


}
