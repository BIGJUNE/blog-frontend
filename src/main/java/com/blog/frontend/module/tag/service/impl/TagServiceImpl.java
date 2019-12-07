package com.blog.frontend.module.tag.service.impl;

import com.blog.frontend.common.Constant;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.tag.dao.ITagDao;
import com.blog.frontend.module.tag.entity.TagPO;
import com.blog.frontend.module.tag.entity.TagQuery;
import com.blog.frontend.module.tag.service.ITagService;
import com.blog.frontend.util.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Tag的service实现类
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagDao tagDao;

    @Override
    public void bindTagsOnPaper(PaperDetailDTO paperDetailDTO) {
        List<TagPO> tagList = tagDao.bindTagsOnPapers(Arrays.asList(paperDetailDTO.getId()));
        List<String> tagNameList = tagList.stream().map(TagPO::getTagName).collect(Collectors.toList());
        paperDetailDTO.setTagList(tagNameList);
    }

    @Override
    public void bindTagsOnPapers(List<PaperSimpleDTO> paperBasicList) {

        if (paperBasicList.isEmpty()) {
            return;
        }

        // 构造字典Map<paperId, paperObject>
        Map<Integer, PaperSimpleDTO> paperBasicDict = paperBasicList.stream()
                .collect(Collectors.toMap(PaperSimpleDTO::getId, paperBasicDTO -> paperBasicDTO));

        // 遍历tag，贴在对应Paper上
        List<TagPO> tagList = tagDao.bindTagsOnPapers(new ArrayList<>(paperBasicDict.keySet()));
        tagList.forEach( item -> {
            PaperSimpleDTO paperSimpleDTO = paperBasicDict.get(item.getPaperId());

            if (paperSimpleDTO.getTagList() == null) {
                paperSimpleDTO.setTagList(new ArrayList<>());
            }
            paperSimpleDTO.getTagList().add(item.getTagName());
        });
    }

    @Override
    public Integer createTag(List<TagPO> tagList) {
        return tagDao.createTag(tagList);
    }

    @Override
    public void deleteTagByPaperId(Integer paperId) {
        tagDao.deleteTagByPaperId(paperId);
    }

    @Override
    public PageDTO<String> listTags(TagQuery tagQuery) {

        PageUtils.paging(tagQuery);
        Page<String> result = tagDao.listTagName(tagQuery);

        return new PageDTO<>(result.getTotal(), result);
    }
}
