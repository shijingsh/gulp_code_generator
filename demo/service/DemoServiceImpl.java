package com.mg.demo.service;

import com.mg.common.utils.BaseServiceImpl;
import com.mg.common.utils.LazyLoadUtil;
import com.mg.demo.dao.DemoDao;
import com.mg.entity.custom.CustomEntity;
import com.mg.entity.info.DemoEntity;
import com.mg.entity.info.HelpEntity;
import com.mg.entity.info.QDemoEntity;
import com.mg.entity.info.QHelpEntity;
import com.mg.entity.shop.ShopEntity;
import com.mg.framework.entity.vo.PageTableVO;
import com.mg.framework.utils.RequestHolder;
import com.mg.framework.utils.WebUtil;
import com.mg.info.vo.HelpSearchVo;
import com.mg.util.SearchVo;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoEntity> implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Transactional(readOnly=true)
    public PageTableVO findPageList(SearchVo searchVo) {


        QDemoEntity entity = QDemoEntity.demoEntity;
        BooleanExpression ex = entity.id.isNotNull();
        String searchKey = searchVo.getKeyword();
        if(StringUtils.isNotBlank(searchVo.getShopId())){
          //  ex = ex.and(entity.id.eq(searchVo.getShopId()));
        }
        if(StringUtils.isNotBlank(searchKey)){
            //ex = ex.and(entity.title.like("%" + searchKey + "%").or(entity.content.like("%" + searchKey + "%")));
        }

        Page<DemoEntity> page = findPageList(ex,searchVo.createPageRequest());
        PageTableVO vo = new PageTableVO(page,searchVo);

        return vo;
    }

    @Transactional(readOnly = true)
    public DemoEntity getFull(String id) {

        Optional<DemoEntity> optional = demoDao.findById(id);
        DemoEntity entity = null;
        if(optional.isPresent()){
            entity = optional.get();
        }

        LazyLoadUtil.fullLoad(entity);

        return entity;
    }

    @Transactional
    public DemoEntity deleteDemo(DemoEntity entity) {
        demoDao.delete(entity);

        return entity;
    }

    @Transactional
    public DemoEntity saveDemo(DemoEntity entity) {

        return demoDao.save(entity);
    }

}
