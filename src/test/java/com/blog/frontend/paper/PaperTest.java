package com.blog.frontend.paper;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.module.tag.service.ITagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        paperDetailDTO.setTitle("单元测试1");
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
    }

    @Test
    void testEnable() throws BaseException {
        PaperDetailDTO oldPaper = paperService.getPaperDetail(12);
        paperService.enablePaper(12);
        PaperDetailDTO newPaper = paperService.getPaperDetail(12);

        Assert.isTrue(oldPaper.getEnable() == 1 || newPaper.getEnable() == 1, "enable的值不对");
        Assert.isTrue(oldPaper.getEnable() == 0 || newPaper.getEnable() == 0, "enable的值不对");
    }
}
