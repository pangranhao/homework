package cn.phr.service;

import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;

import java.util.List;

public interface Empservice {
    DataTablesData<Emp> queryemp(Dataparams dataparams);

    void deleteemp(Integer id);

    void deleteempall(String str);

    List<Emp> queryemptoexcel(Dataparams dataparams);
}
