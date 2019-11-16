package com.blog.frontend.util;

import com.github.pagehelper.PageHelper;

public class PageUtils {

    private final static Integer DEFAULT_CUR_PAGE = 1;
    private final static Integer DEFAULT_PER_PAGE = 10;
    private final static Integer DISABLE_PAGING = 0;

    private PageUtils() {

    }

    public static void paging(Integer curPage, Integer perPage) {

        if (curPage == null || curPage < 1) {
            curPage = DEFAULT_CUR_PAGE;
        }

        if (perPage == null || perPage < 0) {
            perPage = DEFAULT_PER_PAGE;
        }

        // 不进行分页
        if (perPage == DISABLE_PAGING) {
            PageHelper.clearPage();
        } else {
            PageHelper.startPage(curPage, perPage);
        }
    }
}
