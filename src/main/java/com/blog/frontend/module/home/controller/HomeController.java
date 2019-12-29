package com.blog.frontend.module.home.controller;

import com.blog.frontend.common.HomeDTO;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章模块的Controller
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@RestController
@RequestMapping("/v1/home")
public class HomeController {

    @Autowired
    IPaperService paperService;

    @GetMapping
    public RespResult<HomeDTO> listHomePaper() throws BaseException {
        return RespResult.success(paperService.listHomePapers());
    }

}
