package com.ldbmcs.redPacket.controller;

import com.ldbmcs.redPacket.common.annotation.ServiceLimit;
import com.ldbmcs.redPacket.common.uitls.DoubleUtil;
import com.ldbmcs.redPacket.common.uitls.RedisUtil;
import com.ldbmcs.redPacket.common.web.BaseController;
import com.ldbmcs.redPacket.common.web.JsonResult;
import com.ldbmcs.redPacket.service.IRedPacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * 高并发抢红包案例
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
@RestController
@RequestMapping("/redPacket")
@Slf4j
public class RedPacketController extends BaseController {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IRedPacketService redPacketService;

    /**
     * 抢红包
     *
     * @return JsonResult
     */
    @PostMapping("/start")
    @ServiceLimit
    public JsonResult start(Integer redPacketId) {
        int skillNum = 20;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        // 初始化红包数据，抢红包拦截
        redisUtil.cacheValue(redPacketId + "-num", "5");
        // 初始化剩余人数，拆红包拦截
        redisUtil.cacheValue(redPacketId + "-restPeople", "5");
        // 初始化红包金额，单位为分
        redisUtil.cacheValue(redPacketId + "-money", "20000");
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                long count = redisUtil.decr(redPacketId + "-num", 1);
                if (count >= 0) {
                    Integer amount = redPacketService.startSecKill(redPacketId, userId);
                    Double redPacketAmount = DoubleUtil.divide(Double.parseDouble(String.valueOf(amount)), (double) 100);
                    log.info("用户{}抢红包成功，金额：{}", userId, redPacketAmount);
                } else {
                    log.info("用户{}抢红包失败", userId);
                }
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            Integer restMoney = Integer.parseInt(redisUtil.getValue(redPacketId + "-money").toString());
            log.info("剩余金额：{}", restMoney);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
}