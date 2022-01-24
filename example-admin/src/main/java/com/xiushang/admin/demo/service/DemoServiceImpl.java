package com.xiushang.admin.demo.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.xiushang.admin.demo.dao.DemoDao;
import com.xiushang.common.utils.BaseServiceImpl;
import com.xiushang.entity.demo.DemoEntity;
import com.xiushang.entity.demo.QDemoEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.framework.entity.vo.SearchVo;
import com.xiushang.framework.utils.DeleteEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoEntity> implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Transactional(readOnly=true)
    public PageTableVO findPageList(SearchVo searchVo) {

        QDemoEntity entity = QDemoEntity.demoEntity;
        BooleanExpression ex = entity.deleted.eq(DeleteEnum.VALID);
        String searchKey = searchVo.getKeyword();
        //if(StringUtils.isNotBlank(searchVo.getShopId())){
          //  ex = ex.and(entity.id.eq(searchVo.getShopId()));
        //}
        if(StringUtils.isNotBlank(searchKey)){
            //ex = ex.and(entity.title.like("%" + searchKey + "%").or(entity.content.like("%" + searchKey + "%")));
        }

        Page<DemoEntity> page = findPageList(ex,searchVo.createPageRequest());
        PageTableVO vo = new PageTableVO(page,searchVo);

        return vo;
    }



    @Transactional
    public DemoEntity saveDemo(DemoEntity entity) {

        return demoDao.save(entity);
    }

}
