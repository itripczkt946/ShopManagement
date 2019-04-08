package cn.goods.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品明细实体类
 */
public class GoodsDetail {
    private Integer id;
    private GoodsSort goodsSort;   //配置多对一。 多个商品明细对应一个商品分类。

    private Integer sortId;
    private String name;
    private String address;
    private BigDecimal price;
    private Date createDate;
    private int remaining;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoodsSort getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(GoodsSort goodsSort) {
        this.goodsSort = goodsSort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
