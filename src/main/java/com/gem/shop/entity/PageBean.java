package com.gem.shop.entity;

import java.util.List;

//页面显示的所有内容封装成一个分页实体类
public class PageBean {
    private List<Goods> goodsList;//页面内容  ,数据库获取的，根据页面的要求去获取部分数据
    private int curPage;//当前页面
    private int prePage;//上一页
    private int nextPage;//下一页
    private int totalPage;//总共的页面数
    private int totalSize;//数据库总条数
    private int pageSize;//每页显示的条数

    //哪些属性是外部传入的，通过构造方法传入
    public PageBean() {
    }

    public PageBean(List<Goods> goodsList, int curPage, int totalSize, int pageSize) {
        this.goodsList = goodsList;
        this.curPage = curPage;
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        //内部计算//        上一页
        this.prePage=this.curPage==1?1:this.curPage-1;
//         尾页
         this.totalPage= (int)Math.ceil(totalSize*1.0/pageSize);
//     下一页
        this.nextPage= this.curPage==this.totalPage? this.totalPage: this.curPage+1; }
    //自己计算
    public int getPrePage() { return getCurPage()==1?1:getCurPage()-1;
    }
    //自己计算
    public int getNextPage() { return getCurPage()==getTotalPage()?getTotalPage():getCurPage()+1;
    }
    //自己计算
    public int getTotalPage() { return  (int) Math.ceil(getTotalSize()*1.0/getPageSize());
    }
    //外部传入值
    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //外部获得属性值  getter方法


    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public int getCurPage() {
        return curPage;
    }



    public int getTotalSize() {
        return totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }
}
