package com.blog.frontend.module.tag.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ITagDao {

    List<String> listTagsByPaperId(@Param("paperId") Integer paperId);
}
