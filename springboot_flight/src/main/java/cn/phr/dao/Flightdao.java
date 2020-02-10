package cn.phr.dao;

import cn.phr.entity.po.Flight;
import cn.phr.entity.vo.Dataparams;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface Flightdao extends BaseMapper<Flight> {
    long querycount(Dataparams dataparams);

    List<Flight> queryflight(Dataparams dataparams);

    Flight queryid(Integer id);

    void updateisup(Flight flight);

    void updateisupall(Map map);

    void addflight(Flight flight);

    List<Flight> queryflightbylist();

    void updateflight(Flight flight);
}
