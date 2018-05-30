package com.gem.shop.dao;

import com.gem.shop.entity.Goods;
import java.util.List;


public interface GoodsMapper {
//查询所有的商品
    public List<Goods> getGoods();
//根据商品id查询商品
    public Goods selectGoodById(int id);
    //根据id删除商品
    public boolean deleteGood(int id);

    public boolean updateGood(Goods goods);
}
