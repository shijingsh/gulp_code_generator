package com.mg.demo.service;

import com.mg.common.utils.BaseService;
import com.mg.entity.info.DemoEntity;
import com.mg.framework.entity.vo.PageTableVO;
import com.mg.util.SearchVo;

public interface DemoService extends BaseService<DemoEntity>{

    PageTableVO findPageList(SearchVo searchVo);
}
