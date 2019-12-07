package com.blog.frontend.paper;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.module.tag.service.ITagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/30
 */
@SpringBootTest
public class PaperTest {

    @Autowired
    private IPaperService paperService;
    /**
     * 测试文章的创建
     *
     * @param
     * @return void
     * @author JerryGao
     * @date 2019/11/30 13:58
     */
    @Test
    void createPaper() throws BaseException {
        PaperDetailDTO paperDetailDTO = new PaperDetailDTO();
        paperDetailDTO.setTitle("单元测试12-5");
        paperDetailDTO.setMenuId(1);
        paperDetailDTO.setText("asdjfkjakljldkjflad");

        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        paperDetailDTO.setTagList(tags);

        PaperDetailDTO result = paperService.getPaperDetail(paperService.createPaper(paperDetailDTO));

        Assert.notNull(result, "对象为空");
        Assert.notEmpty(result.getTagList(), "标签为空");
        Assert.isTrue(paperDetailDTO.getText().equals(result.getText()), "text不一致");
        Assert.isTrue((paperDetailDTO.getText() + "...").equals(result.getSummary()), "summary错误");
        Assert.isTrue(paperDetailDTO.getTitle().equals(result.getTitle()), "标题错误");
        Assert.isTrue(result.getTagList().containsAll(tags), "标签错误");
        Assert.isTrue(paperDetailDTO.getMenuId().equals(result.getMenuId()), "菜单Id错误");

        System.out.println(result.toString());
    }

    @Test
    void testEnable() throws BaseException {
        PaperDetailDTO oldPaper = paperService.getPaperDetail(12);
        paperService.enablePaper(12);
        PaperDetailDTO newPaper = paperService.getPaperDetail(12);

        Assert.isTrue(oldPaper.getEnable() == 1 || newPaper.getEnable() == 1, "enable的值不对");
        Assert.isTrue(oldPaper.getEnable() == 0 || newPaper.getEnable() == 0, "enable的值不对");
    }

    @Test
    void testListPaper() throws BaseException {
        PaperQuery paperQuery = new PaperQuery();
        paperQuery.setCurPage(1);
        paperQuery.setPerPage(10);
        PageDTO<PaperSimpleDTO> result = paperService.listPaperBasic(paperQuery );
        Assert.notNull(result, "result为空");
        Assert.isTrue(result.getCount() > 0, "count为0");
        Assert.notEmpty(result.getList(), "list为空");
        List<PaperSimpleDTO> paperList = result.getList();
        PaperSimpleDTO paperSimpleDTO = paperList.get(0);
        Assert.isTrue(paperList.size() == 10, "分页没有生效");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getId()), "id为空");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getCommentCount()), "comment_count is null");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getCreateTime()), "create_time is null");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getMenuId()), "menuId is null");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getReadCount()), "read_count is null");
        Assert.isTrue(Objects.nonNull(paperSimpleDTO.getSummary()), "summary is null");

        Assert.notNull(paperSimpleDTO.getTagList(), "tag_list is null");
        Assert.notEmpty(paperSimpleDTO.getTagList(), "tag_list is empty");
        System.out.println(result);
    }

    @Test
    void updatePaper() throws BaseException {
        PaperDetailDTO paperDetailDTO = new PaperDetailDTO();
        paperDetailDTO.setTitle("单元测试12-5-update");
        paperDetailDTO.setMenuId(5);
        paperDetailDTO.setText("FFF");
        paperDetailDTO.setId(20);

        List<String> tags = new ArrayList<>();
        tags.add("update1");
        tags.add("tag2");
        tags.add("tag3");
        tags.add("update4");
        paperDetailDTO.setTagList(tags);

        paperService.updatePaper(paperDetailDTO);

        PaperDetailDTO result = paperService.getPaperDetail(20);

        System.out.println(result.toString());

        Assert.notNull(result, "对象为空");
        Assert.notEmpty(result.getTagList(), "标签为空");
        Assert.isTrue(paperDetailDTO.getText().equals(result.getText()), "text不一致");
        Assert.isTrue((paperDetailDTO.getText() + "...").equals(result.getSummary()), "summary错误");
        Assert.isTrue(paperDetailDTO.getTitle().equals(result.getTitle()), "标题错误");
        Assert.isTrue(result.getTagList().containsAll(tags), "标签错误");
        Assert.isTrue(paperDetailDTO.getMenuId().equals(result.getMenuId()), "菜单Id错误");
    }

    @Test
    void deletePaper() throws BaseException {
        paperService.deletePaper(21);
        try {
            PaperDetailDTO paperDetailDTO = paperService.getPaperDetail(21);
        } catch (BaseException be) {
            Assert.isTrue(be.getMessage().equals("文章不存在"), "Exception message is error");
        }
    }
}