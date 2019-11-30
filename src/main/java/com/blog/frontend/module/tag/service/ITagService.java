package com.blog.frontend.module.tag.service;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.tag.entity.TagPO;

import java.util.List;

/**
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
public interface ITagService {

    /**
     * 获取paper的标签
     *
     * @param PaperDetailDTO paper对象列表
     * @author JerryGao
     * @date 2019/11/16 15:37
     */
    void listTagsByPaper(PaperDetailDTO PaperDetailDTO);

    /**
     * 给paper列表中的所有paper加上tag
     *
     * @param paperSimpleDTOList paper对象列表
     * @author JerryGao
     * @date 2019/11/16 15:37
     */
    void listTagsByPapers(List<PaperSimpleDTO> paperSimpleDTOList);

    /**
     * 模糊搜索获得匹配的标签列表
     *
     * @param tagName 标签名或名称的部分
     * @return com.blog.frontend.common.PageDTO<java.lang.String>
     * @author JerryGao
     * @date 2019/11/18 23:50
     */
    PageDTO<String> listTagsByTagName(String tagName);

    /**
     * 创建标贴
     * 
     * @param tagList tag列表
     * @return java.lang.Integer看了，哦、，
     * 【】‘【】’
     * @author JerryGao
     * @date 2019/11/20 23:06 
     */
    Integer createTag(List<TagPO> tagList);

    /**
     * 删除掉没用的tag
     *
     * @param paperId 文章的id
     * @author JerryGao
     * @date 2019/11/25 1:31
     */
    void deleteTagByPaperId(Integer paperId);
}
