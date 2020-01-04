package com.blog.frontend.module.paper.controller;

import com.blog.frontend.common.HomeDTO;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.service.IPaperService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public RespResult<PageDTO<PaperSimpleDTO>> listPaperBasic(@RequestParam(value = "cur_page", defaultValue = "1") Integer curPage,
                                                              @RequestParam(value = "per_page", defaultValue = "10") Integer perPage,
                                                              @RequestParam(value = "title", required = false) String title,
                                                              @RequestParam(value = "paper_type", required = false) Integer paperType)
            throws BaseException {
        PaperQuery paperQuery = new PaperQuery();
        paperQuery.setTitle(title);
        paperQuery.setPaperType(paperType);
        paperQuery.setCurPage(curPage);
        paperQuery.setPerPage(perPage);

        PageDTO<PaperSimpleDTO> result = paperService.listPaperBasic(paperQuery);

        return RespResult.success(result);
    }

    @GetMapping("/home_papers")
    public RespResult<HomeDTO> listHomePaper() throws BaseException {
        return RespResult.success(paperService.listHomePapers());
    }

    @PostMapping
    public RespResult<Integer> createPaper(@RequestBody PaperDetailDTO paperDetailDTO) throws BaseException {

        return RespResult.success(paperService.createPaper(paperDetailDTO));
    }

    @PutMapping("/{paper_id}")
    public RespResult updatePaper(@PathVariable("paper_id") Integer paperId,
                                  @RequestBody PaperDetailDTO paperDetailDTO) throws BaseException {
        paperDetailDTO.setId(paperId);

        paperService.updatePaper(paperDetailDTO);
        return RespResult.success();
    }

    @PutMapping("/{paper_id}/enable")
    public RespResult enablePaper(@PathVariable("paper_id") Integer paperId) throws BaseException {

        paperService.enablePaper(paperId);
        return RespResult.success();
    }

    @DeleteMapping("/{paper_id}")
    public RespResult deletePaper(@PathVariable("paper_id") Integer paperId) throws BaseException {

        paperService.deletePaper(paperId);
        return RespResult.success();
    }
}
