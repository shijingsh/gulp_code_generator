package com.xiushang.admin.demo.mapper;

import com.xiushang.admin.demo.vo.DemoSaveVo;
import com.xiushang.entity.demo.DemoEntity;
import com.xiushang.framework.model.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DemoSaveMapper extends BaseMapping<DemoEntity, DemoSaveVo> {

    DemoSaveMapper INSTANCE = Mappers.getMapper( DemoSaveMapper.class );

}
