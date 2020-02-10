package cn.phr.dao;

import cn.phr.entity.po.Ticket;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface Ticketdao extends BaseMapper<Ticket> {
    void updateticket(Ticket ticket);


    void addtickets(Ticket ticket);
}
