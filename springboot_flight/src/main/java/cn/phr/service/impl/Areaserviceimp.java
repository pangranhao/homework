package cn.phr.service.impl;

import cn.phr.dao.Areadao;
import cn.phr.entity.po.Areas;
import cn.phr.service.Areaservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Areaserviceimp implements Areaservice {
    @Resource
    private Areadao areadao;

    @Override
    public List<Areas> queryarea() {
        return areadao.selectList(null);
    }
}
