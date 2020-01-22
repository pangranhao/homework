package cn.phr.service.impl;

import cn.phr.dao.Deptdao;
import cn.phr.entity.po.Dept;
import cn.phr.service.Deptservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Deptserviceimp implements Deptservice {
    @Resource
    private Deptdao deptdao;

    @Override
    public List<Dept> querydept() {
        return deptdao.selectList(null);
    }
}
