package cn.phr.service.impl;

import cn.phr.dao.Flightdao;
import cn.phr.dao.Ticketdao;
import cn.phr.entity.po.Flight;
import cn.phr.entity.po.Ticket;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;
import cn.phr.service.Flightservice;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class Flightserviceimpl implements Flightservice {
    @Resource
    private Flightdao flightdao;
    @Resource
    private Ticketdao ticketdao;

    @Override
    public DataTablesData<Flight> queryflight(Dataparams dataparams) {
        DataTablesData<Flight>data=new DataTablesData<Flight>();
        data.setDraw(dataparams.getDraw());
        long count=flightdao.querycount(dataparams);
        data.setRecordsTotal((int) count);
        data.setRecordsFiltered((int) count);
        List<Flight>list=flightdao.queryflight(dataparams);
        data.setData(list);
        return data;
    }

    @Override
    public Flight queryid(Integer id) {
        return flightdao.queryid(id);
    }

    @Override
    public void updateisup(Flight flight) {
        flightdao.updateisup(flight);
    }

    @Override
    public void updateisupall(String str) {
        Map map=new HashMap();
        map.put("str",str);
        flightdao.updateisupall(map);
    }

    @Override
    public void addflight(Flight flight,Ticket ticket) {
        flightdao.addflight(flight);

        ticket.setFlightid(flight.getId());
        ticketdao.addtickets(ticket);
    }

    @Override
    public List<Flight> queryflightbylist() {
        return flightdao.queryflightbylist();
    }

    @Override
    public void updateflight(Flight flight) {
        flightdao.updateflight(flight);
    }

}
