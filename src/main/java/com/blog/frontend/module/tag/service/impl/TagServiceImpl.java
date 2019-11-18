package com.blog.frontend.module.tag.service.impl;

import com.blog.frontend.common.Constant;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
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
    public void bindTags2Paper(PaperDetailDTO paperDetailDTO) {
        Integer paperId = paperDetailDTO.getId();

        TagQuery tagQuery = new TagQuery();
        tagQuery.setPaperId(paperId);
        List<String> tagList = tagDao.listTagName(tagQuery);
        paperDetailDTO.setTagList(tagList);
    }

    @Override
    public void bindTags2PaperList(List<PaperBasicDTO> paperBasicList) {

        if (paperBasicList.isEmpty()) {
            return;
        }

        // 构造字典
        Map<Integer, PaperBasicDTO> paperBasicDict = paperBasicList.stream()
                .collect(Collectors.toMap(PaperBasicDTO::getId, paperBasicDTO -> paperBasicDTO));

        List<TagPO> tagList = tagDao.listTagsByPaperIdList(new ArrayList<>(paperBasicDict.keySet()));
        tagList.forEach( item -> {
            PaperBasicDTO paperBasicDTO = paperBasicDict.get(item.getPaperId());

            if (paperBasicDTO.getTagList() == null) {
                paperBasicDTO.setTagList(new ArrayList<>());
            }
            paperBasicDTO.getTagList().add(item.getTagName());
        });
    }

    @Override
    public void createTag(Integer paperId, String tagName) {
        TagPO tagPO = new TagPO(paperId, tagName);
        tagDao.createTag(tagPO);
    }

    @Override
    public PageDTO<String> listTagsByTagName(String tagName) {

        TagQuery tagQuery = new TagQuery();
        tagQuery.setTagName(tagName);

        PageUtils.paging(1, Constant.DEFAULT_PER_PAGE);
        Page<String> result = tagDao.listTagName(tagQuery);

        return new PageDTO<>(result.getTotal(), result);
    }
}
