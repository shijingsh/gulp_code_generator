package com.xiushang.admin.demoPackage.vo;

import com.xiushang.framework.entity.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DemoSaveVo extends BaseVO {

    @ApiModelProperty(value = "名称",required = true)
    private String name;

}
