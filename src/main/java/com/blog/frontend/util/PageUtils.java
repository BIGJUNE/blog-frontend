package com.blog.frontend.util;

import com.blog.frontend.common.BaseQuery;
import com.github.pagehelper.PageHelper;

public class PageUtils {

    public final static Integer DEFAULT_CUR_PAGE = 1;
    public final static Integer DEFAULT_PER_PAGE = 10;
    public final static Integer DISABLE_PAGING = 0;

    private PageUtils() {

    }

    public static void paging(BaseQuery baseQuery) {
        PageUtils.paging(baseQuery.getCurPage(), baseQuery.getPerPage());
    }

    public static void paging(Integer curPage, Integer perPage) {

        if (curPage == null || curPage < 1) {
            curPage = DEFAULT_CUR_PAGE;
        }

        if (perPage == null || perPage < 0) {
            perPage = DEFAULT_PER_PAGE;
        }

        PageHelper.clearPage();
        if (!DISABLE_PAGING.equals(perPage)) {
            PageHelper.startPage(curPage, perPage);
        }
    }
}
