package com.mg.demo.service;

import com.mg.common.utils.BaseServiceImpl;
import com.mg.demo.dao.DemoDao;
import com.mg.entity.info.DemoEntity;
import com.mg.framework.entity.vo.PageTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoEntity> implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Transactional
    public PageTableVO findPageList(PageTableVO pageTableVO) {

        return null;
    }

}
