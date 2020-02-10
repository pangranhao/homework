package cn.phr.service;

import cn.phr.entity.po.Flight;
import cn.phr.entity.po.Ticket;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;

import java.util.List;

public interface Flightservice {
    DataTablesData<Flight> queryflight(Dataparams dataparams);

    Flight queryid(Integer id);

    void updateisup(Flight flight);

    void updateisupall(String str);

   /* void addflight(Flight flight);*/

    void addflight(Flight flight, Ticket ticket);

    List<Flight> queryflightbylist();

    void updateflight(Flight flight);
}
