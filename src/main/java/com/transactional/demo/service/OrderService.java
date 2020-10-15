package com.transactional.demo.service;

public interface OrderService {
    public boolean decrementProductStoreLock(int goodsId, int buyNum);
    public boolean decrementProductStoreLockWithCatch(int goodsId, int buyNum);
    public boolean decrementProductStoreLockWithCatch1(int goodsId, int buyNum);
    public boolean decrementProductStoreLockWithCatch2(int goodsId, int buyNum);
}
