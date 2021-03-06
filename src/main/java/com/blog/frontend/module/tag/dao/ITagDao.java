package com.blog.frontend.module.tag.dao;

import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.tag.entity.TagPO;
import com.blog.frontend.module.tag.entity.TagQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author JerryGao
 * @date 2019/11/16
 */
@Mapper
public interface ITagDao {

    /**
     * 获取Paper的tag列表
     *
     * @param tagQuery tag查询对象
     * @return java.util.List<java.lang.String>
     * @author JerryGao
     * @date 2019/11/17 21:27
     */
    Page<String> listTagName(TagQuery tagQuery);

    /**
     * 根据PaperId列表获取Tag对象列表
     *
     * @param paperIdList paperId列表
     * @return java.util.List<java.lang.String>
     * @author JerryGao
     * @date 2019/11/18 00:15
     */
    List<TagPO> bindTagsOnPapers(List<Integer> paperIdList);

    /**
     * 批量创建标签
     *
     * @param tagList 标题列表
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/11/18 23:04
     */
    Integer createTag(@Param("tagList") List<TagPO> tagList);

    /**
     * 删除文章
     *
     * @param paperId 文章id
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/11/30 12:01
     */
    Integer deleteTagByPaperId(@Param("paperId") Integer paperId);
}
