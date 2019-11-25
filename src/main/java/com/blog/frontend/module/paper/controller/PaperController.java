package com.blog.frontend.module.paper.controller;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.po.PaperVO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

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

    @PostMapping
    public RespResult createPaper(@RequestBody PaperDetailDTO paperDetailDTO) throws BaseException {
        paperService.createPaper(paperDetailDTO);
        return RespResult.success();
    }

    @PutMapping("/{paper_id}")
    public RespResult updatePaper(@PathVariable("paper_id") Integer paperId,
                                  @RequestBody PaperDetailDTO paperDetailDTO) {
        return null;
    }

    @PutMapping("/{paper_id}/enable")
    public RespResult enablePaper(@PathVariable("paper_id") Integer paperId) {
        return null;
    }

    @DeleteMapping("/{paper_id}")
    public RespResult deletePaper(@PathVariable("paper_id") Integer paperId) {
        return null;
    }
}
