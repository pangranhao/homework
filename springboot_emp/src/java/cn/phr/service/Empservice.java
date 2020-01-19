package cn.phr.service;

import cn.phr.entity.po.Emp;
import cn.phr.entity.vo.DataTablesData;
import cn.phr.entity.vo.Dataparams;

public interface Empservice {
    DataTablesData<Emp> queryemp(Dataparams dataparams);
}
