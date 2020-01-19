package cn.phr.service.impl;

import cn.phr.dao.Empdao;
import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;
import cn.phr.service.Empservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class Empserviceiml implements Empservice {
    @Resource
    private Empdao empdao;

    @Override
    public DataTablesData<Emp> queryemp(Dataparams dataparams) {
        DataTablesData<Emp>data=new DataTablesData<Emp>();
        data.setDraw(dataparams.getDraw());
        long count=empdao.querycount(dataparams);
        data.setRecordsFiltered((int) count);
        data.setRecordsTotal((int) count);
        List<Emp>list=empdao.queryemp(dataparams);
        data.setData(list);
        return data;
    }

    @Override
    public void deleteemp(Integer id) {
        empdao.deleteById(id);
    }

    @Override
    public void deleteempall(String str) {
        Map map=new HashMap<>();
        map.put("str",str);
        empdao.deleteempall(map);
    }
}
