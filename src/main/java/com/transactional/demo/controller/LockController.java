package com.transactional.demo.controller;

import com.transactional.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/lock")
public class LockController {

    @Resource
    OrderService orderService;

    //购买商品,方法内没有捕捉异常
    @GetMapping("/lock")
    @ResponseBody
    public String buyLock() {
        try {
            int goodsId = 3;
            orderService.decrementProductStoreLock(goodsId,1);
            return "success";
        } catch (Exception e){
            System.out.println("捕捉到了异常 in controller");
            e.printStackTrace();
            String errMsg = e.getMessage();
            return errMsg;
        }
    }

    //购买商品，方法内捕捉异常
    @GetMapping("/lockcatch")
    @ResponseBody
    public String buyLockCatch() {
        try {
            int goodsId = 3;
            orderService.decrementProductStoreLockWithCatch(goodsId,1);
            return "success";
        } catch (Exception e){
            System.out.println("捕捉到了异常 in controller");
            e.printStackTrace();
            String errMsg = e.getMessage();
            return errMsg;
        }
    }

    //购买商品，方法内捕捉异常
    @GetMapping("/lockcatch1")
    @ResponseBody
    public String buyLockCatch1() {
        try {
            int goodsId = 3;
            orderService.decrementProductStoreLockWithCatch1(goodsId,1);
            return "success";
        } catch (Exception e){
            System.out.println("捕捉到了异常 in controller");
            e.printStackTrace();
            String errMsg = e.getMessage();
            return errMsg;
        }
    }

    //购买商品，方法内捕捉异常
    @GetMapping("/lockcatch2")
    @ResponseBody
    public String buyLockCatch2() {
        try {
            int goodsId = 3;
            orderService.decrementProductStoreLockWithCatch2(goodsId,1);
            return "success";
        } catch (Exception e){
            System.out.println("捕捉到了异常 in controller");
            e.printStackTrace();
            String errMsg = e.getMessage();
            return errMsg;
        }
    }

}



