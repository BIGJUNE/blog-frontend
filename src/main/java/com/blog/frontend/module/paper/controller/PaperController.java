package com.blog.frontend.module.paper.controller;

import com.blog.frontend.common.RespResult;
import com.blog.frontend.module.paper.entity.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.PaperDetailDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 文章模块的Controller
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@RestController
@RequestMapping("/v1/papers")
public class PaperController {

    @GetMapping("{id}")
    public RespResult<PaperDetailDTO> getPaperDetail(@PathVariable("id") Integer id) {
        return RespResult.success();
    }

    @GetMapping
    public RespResult<PaperBasicDTO> listPaperBasic(@RequestParam(value = "cur_page", defaultValue = "0") Integer curPage,
                                                    @RequestParam(value = "per_page", defaultValue = "10") Integer perPage) {
        return RespResult.success();
    }
}
