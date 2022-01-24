package com.xiushang.admin.demo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xiushang.admin.demo.service.DemoService;
import com.xiushang.entity.demo.DemoEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.framework.entity.vo.SearchVo;
import com.xiushang.framework.log.CommonResult;
import com.xiushang.security.SecurityRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(tags = "cnGlobalApiName")
@Controller
@RequestMapping(value = "/demo",
        produces = "application/json; charset=UTF-8")
public class DemoController {
    @Autowired
    private DemoService demoService;
    /**
     * 获取cnApiName
     */
    @ApiOperation(value = "根据ID查询cnApiName")
    @ResponseBody
    @RequestMapping("/get")
    public CommonResult<DemoEntity> get(String id) {
        DemoEntity entity = demoService.get(id);

        return CommonResult.success(entity);
    }

    /**
     * 保存cnApiName
     */
    @ApiOperation(value = "保存cnApiName")
    @ResponseBody
    @PostMapping("/post")
    @Secured({SecurityRole.ROLE_USER})
    public CommonResult<DemoEntity> post(@RequestBody DemoEntity entity) {
        demoService.saveDemo(entity);
        return CommonResult.success(entity);
    }

    /**
     * 删除
     * @return
     */
    @ApiOperation(value = "删除cnApiName")
    @ResponseBody
    @GetMapping("/delete")
    @Secured({SecurityRole.ROLE_USER})
    public CommonResult<DemoEntity> delete(@ApiParam(value = "id主键",required = true) String id) {
        demoService.delete(id);
        return CommonResult.success();
    }
    /**
     * cnApiName分页列表
     * @return          PageTableVO
     */
    @ApiOperation(value = "cnApiName查询分页列表")
    @ResponseBody
    @RequestMapping("/listPage")
    public CommonResult<PageTableVO<DemoEntity>> listPage(@RequestBody SearchVo searchVo) {
        PageTableVO vo = demoService.findPageList(searchVo);

        return CommonResult.success(vo);
    }


}
