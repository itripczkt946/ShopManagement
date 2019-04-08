package cn.goods.dao;

import cn.goods.entity.GoodsDetail;
import cn.goods.entity.GoodsSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//dao层
public interface GoodsMapper {

    //查询所有的商品分类
    List<GoodsSort> queryAllGoodsSort();

    /**
     * 分页查询所有或指定类别的商品信息，并按编号降序排序
     * @param startPos 位置偏移量，即从第几行数据开始显示，(位置是从0开始)
     * @param pageSize 每页显示的行数
     * @param sortId 商品类别编号
     */
    List<GoodsDetail> queryAllGoodsDetailPage(@Param("startPos") Integer startPos,
                                              @Param("pageSize") Integer pageSize,
                                              @Param("sortId") Integer sortId);

    //查询总的记录数并按商品分类编号去查询
    Integer queryCount(@Param("sortId") Integer sortId);

    //根据商品编号查询商品详细信息
    GoodsDetail queryGoodsDetailById(@Param("id")Integer id);

    //修改商品剩余数量
    Integer updateGoodsDetailById(GoodsDetail detail);

    //删除
    Integer deleteGoodsDetail(@Param("id") Integer id);

    //新增
    Integer insertGoodsDetail(GoodsDetail detail);
}
