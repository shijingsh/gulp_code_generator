package com.xiushang.admin.demoPackage.mapper;

import com.xiushang.admin.demoPackage.vo.DemoSaveVo;
import com.xiushang.entity.demoEntityPackage.DemoEntity;
import com.xiushang.framework.model.BaseMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DemoSaveMapper extends BaseMapping<DemoEntity, DemoSaveVo> {

    DemoSaveMapper INSTANCE = Mappers.getMapper( DemoSaveMapper.class );

}
