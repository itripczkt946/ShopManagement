package cn.goods.controller;

import cn.goods.entity.GoodsDetail;
import cn.goods.entity.GoodsSort;
import cn.goods.entity.Page;
import cn.goods.service.GoodsService;
import javafx.scene.input.MouseDragEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    //新增添加商品信息的方法
    @RequestMapping("/saveAdd")
    public String saveAdd(GoodsDetail detail) {
        return "redirect:/goods/list";
    }

    /**
     *分页查询商品详细信息列表
     * @param currPageNo 当前页码
     * @param sortId 商品分类编号
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value="currPageNo", required = false) Integer currPageNo,
                       @RequestParam(value="sortId", required = false) Integer sortId, Model model) {
        //1、查询所有的商品分类信息
        List<GoodsSort> goodsSortsList = goodsService.queryAllGoodsSort();
        //2、获取总记录数
        Integer totalCount = goodsService.queryCount(sortId);
        //3、封装Page对象
        Integer pageNo = currPageNo == null ? 1 : currPageNo;  //当前页码
        Page page = new Page();
        page.setCurrPageNo(pageNo);
        page.setPageSize(3);  //每页显示3条记录
        page.setTotalCount(totalCount);
        //4、按条件分页查询商品列表信息
        Integer startPos = (page.getCurrPageNo() - 1) * page.getPageSize();
        List<GoodsDetail> goodsDtailList = goodsService.queryAllGoodsDetailPage(startPos, page.getPageSize(), sortId);
        //保存数据
        model.addAttribute("goodsSortsList", goodsSortsList);  //商品分类
        model.addAttribute("page", page);  //page对象
        model.addAttribute("goodsDtailList", goodsDtailList);  //商品详细分页列表信息
        return "goodsList";  //返回逻辑视图名
    }

    //通过id查询商品详情对象信息
    @RequestMapping("/toUpdatePage/{id}")
    public String toUpdatePage (@PathVariable Integer id, Model model) {
        GoodsDetail detail = goodsService.queryGoodsDetailById(id);
        model.addAttribute("detail",detail);
        return "goodsUpdate";
    }

    @RequestMapping("/updateGoods")
    public String updateGoods(GoodsDetail detail) {
        Integer count = goodsService.updateGoodsDetailById(detail);
        if (count > 0) {
            return "redirect:/goods/list";  //修改成功
        } else {
            //return "redirect:/goods/toUpdatePage/" + detail.getId();
            return "redirect:/goods/list";  //修改成功
        }
    }
}
