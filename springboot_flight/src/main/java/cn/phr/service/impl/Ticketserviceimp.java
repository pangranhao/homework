package cn.phr.service.impl;

import cn.phr.dao.Ticketdao;
import cn.phr.entity.po.Ticket;
import cn.phr.service.Ticketservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Ticketserviceimp implements Ticketservice {
    @Resource
    private Ticketdao ticketdao;

    @Override
    public Ticket queryticketid(Integer id) {
        return ticketdao.selectById(id);
    }

    @Override
    public void updateticket(Ticket ticket) {
        ticketdao.updateticket(ticket);
    }

    @Override
    public List<Ticket> queryticket() {
        return ticketdao.selectList(null);
    }


}
