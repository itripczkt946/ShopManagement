package cn.goods.entity;
//分页所需要的实体类
public class Page {
    private Integer currPageNo;  //当前页码    curr 是current单词的简写，当前的意思
    private Integer pageSize;  //每页显示的数据行数
    private Integer totalCount;  //总的记录数
    private Integer totalPageCount;  //总的页数

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    //给总的记录数赋值
    public void setTotalCount(Integer totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;

            //根据总的记录数和每页显示的数据行数计算总的页数。15  5  问总的页数为多少？14 % 5 == 0 ? 14 / 5 : 14 / 5 + 1
            this.totalPageCount = this.totalCount % this.pageSize == 0 ?
                    this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        }
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
