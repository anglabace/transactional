package com.transactional.demo.service.impl;

import com.transactional.demo.mapper.GoodsMapper;
import com.transactional.demo.pojo.Goods;
import com.transactional.demo.service.OrderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {


    @Resource
    private GoodsMapper goodsMapper;

    /*
     *   减库存
     * */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public boolean decrementProductStoreLock(int goodsId, int buyNum) {
        Goods goodsOne = goodsMapper.selectOneGoods(goodsId);
        System.out.println("-------------------------当前库存:"+goodsOne.getStock()+"-------购买数量:"+buyNum);
        if (goodsOne.getStock() < buyNum || goodsOne.getStock() <= 0) {
            System.out.println("------------------------fail:buy fail,return");
            return false;
        }
        int upStock = goodsOne.getStock()-buyNum;
        goodsOne.setStock(upStock);
        int upNum = goodsMapper.updateOneGoodsStock(goodsOne);
        System.out.println("-------------------------success:成交订单数量:"+upNum);

        int insNum = goodsMapper.insertOneGoods(goodsOne);
        System.out.println("-------------------------success:ins数量:"+insNum);
        return true;
    }


    /*
     *   减库存
     * */
    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean decrementProductStoreLockWithCatch(int goodsId, int buyNum) {
        try {
            Goods goodsOne = goodsMapper.selectOneGoods(goodsId);
            System.out.println("-------------------------当前库存:"+goodsOne.getStock()+"-------购买数量:"+buyNum);
            if (goodsOne.getStock() < buyNum || goodsOne.getStock() <= 0) {
                System.out.println("------------------------fail:buy fail,return");
                return false;
            }
            int upStock = goodsOne.getStock()-buyNum;
            goodsOne.setStock(upStock);
            int upNum = goodsMapper.updateOneGoodsStock(goodsOne);
            System.out.println("-------------------------success:成交订单数量:"+upNum);

            int insNum = goodsMapper.insertOneGoods(goodsOne);
            System.out.println("-------------------------success:ins数量:"+insNum);
            return true;
        } catch (Exception e) {
            System.out.println("捕捉到了异常in service method");
            e.printStackTrace();
            String errMsg = e.getMessage();
            //throw e;
            return false;
        }
    }


    /*
     *   减库存
     * */
    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean decrementProductStoreLockWithCatch1(int goodsId, int buyNum) {
        try {
            Goods goodsOne = goodsMapper.selectOneGoods(goodsId);
            System.out.println("-------------------------当前库存:"+goodsOne.getStock()+"-------购买数量:"+buyNum);
            if (goodsOne.getStock() < buyNum || goodsOne.getStock() <= 0) {
                System.out.println("------------------------fail:buy fail,return");
                return false;
            }
            int upStock = goodsOne.getStock()-buyNum;
            goodsOne.setStock(upStock);
            int upNum = goodsMapper.updateOneGoodsStock(goodsOne);
            System.out.println("-------------------------success:成交订单数量:"+upNum);

            int insNum = goodsMapper.insertOneGoods(goodsOne);
            System.out.println("-------------------------success:ins数量:"+insNum);

            return true;
        } catch (Exception e) {
            System.out.println("捕捉到了异常in service method");
            e.printStackTrace();
            String errMsg = e.getMessage();
            throw e;
        }
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    //@Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    //@Transactional(rollbackFor={Exception.class})
    public boolean decrementProductStoreLockWithCatch2(int goodsId, int buyNum) {
        try {
            Goods goodsOne = goodsMapper.selectOneGoods(goodsId);
            System.out.println("-------------------------当前库存:"+goodsOne.getStock()+"-------购买数量:"+buyNum);
            if (goodsOne.getStock() < buyNum || goodsOne.getStock() <= 0) {
                System.out.println("------------------------fail:buy fail,return");
                return false;
            }
            int upStock = goodsOne.getStock()-buyNum;
            goodsOne.setStock(upStock);
            int upNum = goodsMapper.updateOneGoodsStock(goodsOne);
            System.out.println("-------------------------success:成交订单数量:"+upNum);

            int insNum = goodsMapper.insertOneGoods(goodsOne);
            System.out.println("-------------------------success:ins数量:"+insNum);

            return true;
        } catch (Exception e) {
            System.out.println("捕捉到了异常in service method");
            e.printStackTrace();
            String errMsg = e.getMessage();

            //手动rollback
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

}
