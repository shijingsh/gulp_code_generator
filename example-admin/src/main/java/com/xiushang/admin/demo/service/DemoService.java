package com.xiushang.admin.demo.service;


import com.xiushang.common.utils.BaseService;
import com.xiushang.entity.demo.DemoEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.framework.entity.vo.SearchVo;

public interface DemoService extends BaseService<DemoEntity> {

    PageTableVO findPageList(SearchVo searchVo);

    DemoEntity saveDemo(DemoEntity entity);
}
