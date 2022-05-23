package com.example.jwtlogin.param;

/**
 * @author Devil
 * @create 2022-04-03 16:31
 */
public class PageParam {
    private Integer currentPage = 1;

    private Integer pageSize = 10;

    @Override
    public String toString() {
        return "PageParam{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageParam() {
    }

    public PageParam(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
