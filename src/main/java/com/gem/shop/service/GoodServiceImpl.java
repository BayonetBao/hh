package com.gem.shop.service;

import com.gem.shop.dao.GoodsCatoryMapper;
import com.gem.shop.dao.GoodsMapper;
import com.gem.shop.entity.Goods;
import com.gem.shop.entity.GoodsCatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsCatoryMapper goodsCatoryMapper;
    @Override
    public List<Goods> selectAllGoods() {

        return goodsMapper.getGoods();
    }

    @Override
    public List<GoodsCatory> selectAllCatory() {
        return goodsCatoryMapper.getAllGoodCatory();
    }

    @Override
    public Goods selectGoodById(int id) {
        return goodsMapper.selectGoodById(id);
    }

    @Override
    public boolean deleteGood(int id) {
        return goodsMapper.deleteGood(id);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public boolean updateGood(Goods goods) {
        return goodsMapper.updateGood(goods);
    }
}
