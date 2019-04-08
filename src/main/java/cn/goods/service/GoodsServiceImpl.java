package cn.goods.service;

import cn.goods.dao.GoodsMapper;
import cn.goods.entity.GoodsDetail;
import cn.goods.entity.GoodsSort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*等价于： <bean id="goodsService" class="cn.goods.service.GoodsServiceImpl"></bean>*/
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsSort> queryAllGoodsSort() {
        return goodsMapper.queryAllGoodsSort();
    }

    @Override
    public List<GoodsDetail> queryAllGoodsDetailPage(Integer startPos, Integer pageSize, Integer sortId) {
        return goodsMapper.queryAllGoodsDetailPage(startPos, pageSize, sortId);
    }

    @Override
    public Integer queryCount(Integer sortId) {
        return goodsMapper.queryCount(sortId);
    }

    @Override
    public GoodsDetail queryGoodsDetailById(Integer id) {

        return goodsMapper.queryGoodsDetailById(id);
    }

    @Override
    public Integer updateGoodsDetailById(GoodsDetail detail) {
        return goodsMapper.updateGoodsDetailById(detail);
    }
}
