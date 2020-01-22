package cn.phr.service.impl;

import cn.phr.dao.Jobdao;
import cn.phr.entity.po.Job;
import cn.phr.service.Jobservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Jobserviceimp implements Jobservice {
    @Resource
    private Jobdao jobdao;

    @Override
    public List<Job> queryjob() {
        return jobdao.selectList(null);
    }
}
