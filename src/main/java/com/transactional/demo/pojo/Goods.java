package com.transactional.demo.pojo;

public class Goods {

    //商品id
    private int goodsId;
    public int getGoodsId() {
        return this.goodsId;
    }
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    //商品名字
    private String goodsName;
    public String getGoodsName() {
        return this.goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    //商品库存数
    private int stock;
    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
