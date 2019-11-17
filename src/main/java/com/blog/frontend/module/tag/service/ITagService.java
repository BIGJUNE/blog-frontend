package com.blog.frontend.module.tag.service;

import java.util.List;

public interface ITagService {
    List<String> listTagsByPaperId(Integer paperId);
}
