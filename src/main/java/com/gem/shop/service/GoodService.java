package com.gem.shop.service;

import com.gem.shop.entity.Goods;
import com.gem.shop.entity.GoodsCatory;

import java.util.List;

public interface GoodService {
    //查询所有商品
    public List<Goods> selectAllGoods();
    //查询所有类别
    public List<GoodsCatory> selectAllCatory();
    //根据id查询商品
    public Goods selectGoodById(int id);

    public boolean deleteGood(int id);

    public boolean updateGood(Goods goods);
}
