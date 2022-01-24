package com.xiushang.admin.demoPackage.service;


import com.xiushang.admin.demoPackage.vo.DemoSaveVo;
import com.xiushang.common.utils.BaseService;
import com.xiushang.entity.demoEntityPackage.DemoEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.framework.entity.vo.SearchVo;

public interface DemoService extends BaseService<DemoEntity> {

    PageTableVO findPageList(SearchVo searchVo);

    DemoEntity saveDemo(DemoSaveVo entity);
}
