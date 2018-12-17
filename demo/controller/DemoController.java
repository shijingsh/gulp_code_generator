package com.mg.demo.controller;

import com.mg.demo.service.DemoService;
import com.mg.entity.info.DemoEntity;
import com.mg.framework.entity.vo.PageTableVO;
import com.mg.framework.utils.JsonResponse;
import com.mg.framework.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/demo",
        produces = "application/json; charset=UTF-8")
public class DemoController {
    @Autowired
    private DemoService demoService;
    /**
     * 获取
     * @return
     */
    @ResponseBody
    @RequestMapping("/get")
    public String get(String id) {
        DemoEntity entity = demoService.get(id);

        return JsonResponse.success(entity, null);
    }

    /**
     * 保存
     * @return
     */
    @ResponseBody
    @RequestMapping("/post")
    public String post(HttpServletRequest req) {
        DemoEntity entity = WebUtil.getRequstBody(req,DemoEntity.class);
        demoService.save(entity);
        return JsonResponse.success(entity, null);
    }
    /**
     * 分页列表
     * @param req   请求
     * @return          PageTableVO
     */
    @ResponseBody
    @RequestMapping("/listPage")
    public String listPage(HttpServletRequest req) {
        PageTableVO vo = demoService.findPageList();

        return JsonResponse.success(vo, null);
    }


}
