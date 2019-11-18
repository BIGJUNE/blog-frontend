package com.blog.frontend.module.tag.service;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;

import java.util.List;

/**
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
public interface ITagService {
    /**
     * 给paper加上tag
     *
     * @param paperDetailDTO paper对象
     * @return 查询结果
     * @author JerryGao
     * @date 2019/11/16 15:37
     */
    void bindTags2Paper(PaperDetailDTO paperDetailDTO);

    /**
     * 给paper列表中的所有paper加上tag
     *
     * @param paperBasicDTOList paper对象列表
     * @return 查询结果
     * @author JerryGao
     * @date 2019/11/16 15:37
     */
    void bindTags2PaperList(List<PaperBasicDTO> paperBasicDTOList);

    /**
     * 创建标签
     *
     * @param paperId 文章主键
     * @param tagName 标签名
     * @author JerryGao
     * @date 2019/11/18 23:07
     */
    void createTag(Integer paperId, String tagName);

    /**
     * 模糊搜索获得匹配的标签列表
     *
     * @param tagName 标签名或名称的部分
     * @return com.blog.frontend.common.PageDTO<java.lang.String>
     * @author JerryGao
     * @date 2019/11/18 23:50
     */
    PageDTO<String> listTagsByTagName(String tagName);
}
