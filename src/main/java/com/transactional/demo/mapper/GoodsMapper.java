package com.transactional.demo.mapper;

import com.transactional.demo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {

    Goods selectOneGoods(int goods_id);
    int updateOneGoodsStock(Goods goodsOne);
    int insertOneGoods(Goods goodsOne);
}