package com.xiushang.admin.demoPackage.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.xiushang.admin.demoPackage.mapper.DemoSaveMapper;
import com.xiushang.admin.demoPackage.vo.DemoSaveVo;
import com.xiushang.common.utils.BaseServiceImpl;
import com.xiushang.entity.demoEntityPackage.DemoEntity;
import com.xiushang.entity.demoEntityPackage.QDemoEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.framework.entity.vo.SearchVo;
import com.xiushang.framework.utils.DeleteEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoEntity> implements DemoService {

    @Transactional(readOnly=true)
    public PageTableVO findPageList(SearchVo searchVo) {

        QDemoEntity entity = QDemoEntity.demoEntity;
        BooleanExpression ex = entity.deleted.eq(DeleteEnum.VALID);
        String searchKey = searchVo.getKeyword();

        if(StringUtils.isNotBlank(searchKey)){
            ex = ex.and(entity.name.like("%" + searchKey + "%"));
        }

        Page<DemoEntity> page = findPageList(ex,searchVo.createPageRequest(new Sort.Order(Sort.Direction.DESC,"createdDate")));
        PageTableVO vo = new PageTableVO(page,searchVo);

        return vo;
    }


    @Transactional
    public DemoEntity saveDemo(DemoSaveVo demoSaveVo) {

        DemoEntity entity = DemoSaveMapper.INSTANCE.targetToSource(demoSaveVo);
        return saveAndGet(entity);
    }

}
