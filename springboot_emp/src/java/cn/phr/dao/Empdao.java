package cn.phr.dao;

import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.Dataparams;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface Empdao extends BaseMapper<Emp> {
    long querycount(Dataparams dataparams);

    List<Emp> queryemp(Dataparams dataparams);

    void deleteempall(Map map);
}
