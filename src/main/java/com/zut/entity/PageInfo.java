package com.zut.entity;

import java.util.List;

/**
 * @author 45188
 * @since
 * @param <T>
 */
public class PageInfo<T> {
    // ��ҳ����Ҫչʾ�ļ���
    private List<T> list;
    // ��ʾ���ܼ�¼��
    private Integer totalNum;
    // ��ҳ��
    private Integer totalPage;

    // ��ǰҳ
    private Integer currentPage;
    // ÿҳ��ʾ����Ŀ (Ϊ�˷�ֹӲ�������д�������ļ���)
    private Integer pageSize;

    // ��������������ʾ��ҳ�� ����startΪ1 pageNoΪ5����ô��ʾ��ҳ��������1��2��3��4��5
    private Integer start;
    private Integer pageNo;

    public PageInfo(Integer totalNum, Integer currentPage, Integer pageSize, Integer pageNo) {
        this.totalNum = totalNum;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        /*this.pageNo = pageNo;*/

        // ������ҳ��
        if (totalNum % this.pageSize == 0)
            this.totalPage = totalNum / this.pageSize;
        else
            this.totalPage = (totalNum / this.pageSize) + 1;

        this.start = currentPage;
        // ����������5���������ҳ����ֻ����������ô�϶�����ȫ����ʾŶ
        if (pageNo+currentPage-1>=this.totalPage)
            this.pageNo = pageNo;
        else this.pageNo = this.totalPage-currentPage+1;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    
}