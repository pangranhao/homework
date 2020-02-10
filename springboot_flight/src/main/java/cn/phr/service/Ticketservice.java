package cn.phr.service;

import cn.phr.entity.po.Ticket;

import java.util.List;

public interface Ticketservice {
    Ticket queryticketid(Integer id);

    void updateticket(Ticket ticket);

    List<Ticket> queryticket();


}
