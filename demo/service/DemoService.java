package com.mg.demo.service;

import com.mg.common.utils.BaseService;
import com.mg.entity.info.DemoEntity;
import com.mg.framework.entity.vo.PageTableVO;

public interface DemoService extends BaseService<DemoEntity>{

    PageTableVO findPageList(PageTableVO pageTableVO);
}
