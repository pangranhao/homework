package cn.phr.service.impl;

import cn.phr.dao.Typedao;
import cn.phr.entity.po.Types;
import cn.phr.service.Typeservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Typeserviceimp implements Typeservice {
    @Resource
    private Typedao typedao;

    @Override
    public List<Types> querytype() {
        return typedao.selectList(null);
    }
}
