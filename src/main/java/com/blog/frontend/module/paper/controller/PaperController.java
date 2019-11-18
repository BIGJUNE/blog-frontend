package com.blog.frontend.module.paper.controller;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
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
@RequestMapping("/v1/papers")
public class PaperController {

    @Autowired
    IPaperService paperService;

    @GetMapping("{id}")
    public RespResult<PaperDetailDTO> getPaperDetail(@PathVariable("id") Integer id) throws BaseException {
        return RespResult.success(paperService.getPaperDetail(id));
    }

    @GetMapping
    public RespResult<PageDTO<PaperBasicDTO>> listPaperBasic(@RequestParam(value = "cur_page", defaultValue = "0") Integer curPage,
                                                    @RequestParam(value = "per_page", defaultValue = "10") Integer perPage,
                                                    @RequestParam(value = "title", required = false) String title)
            throws BaseException {
        PaperQuery paperQuery = new PaperQuery();
        paperQuery.setTitle(title);
        paperQuery.setCurPage(curPage);
        paperQuery.setPerPage(perPage);

        PageDTO<PaperBasicDTO> result = paperService.listPaperBasic(paperQuery);

        return RespResult.success(result);
    }
}
