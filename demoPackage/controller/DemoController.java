package com.mg.demoPackage.controller;

import com.mg.demoPackage.service.DemoService;
import com.mg.entity.demoEntityPackage.DemoEntity;
import com.mg.framework.entity.vo.PageTableVO;
import com.mg.framework.utils.JsonResponse;
import com.mg.util.SearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(tags = "cnGlobalApiName")
@Controller
@RequestMapping(value = "/demo",
        produces = "application/json; charset=UTF-8")
public class DemoController {
    @Autowired
    private DemoService demoService;
    /**
     * 获取cnApiName
     * @return
     */
    @ApiOperation(value = "根据ID查询cnApiName")
    @ResponseBody
    @RequestMapping("/get")
    public String get(String id) {
        DemoEntity entity = demoService.get(id);

        return JsonResponse.success(entity, null);
    }

    /**
     * 保存cnApiName
     * @return
     */
    @ApiOperation(value = "保存cnApiName")
    @ResponseBody
    @RequestMapping("/post")
    public String post(@RequestBody DemoEntity entity) {
        demoService.saveDemo(entity);
        return JsonResponse.success(entity, null);
    }
    /**
     * cnApiName分页列表
     * @return          PageTableVO
     */
    @ApiOperation(value = "cnApiName查询分页列表")
    @ResponseBody
    @RequestMapping("/listPage")
    public String listPage(@RequestBody SearchVo searchVo) {
        PageTableVO vo = demoService.findPageList(searchVo);

        return JsonResponse.success(vo, null);
    }


}
