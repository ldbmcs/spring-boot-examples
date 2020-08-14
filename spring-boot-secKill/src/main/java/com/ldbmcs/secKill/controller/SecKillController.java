package com.ldbmcs.secKill.controller;

import com.ldbmcs.secKill.common.web.BaseController;
import com.ldbmcs.secKill.common.web.JsonResult;
import com.ldbmcs.secKill.service.ISecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * 秒杀案例
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
@RestController
@RequestMapping("/secKill")
@Slf4j
public class SecKillController extends BaseController {

    @Autowired
    private ISecKillService secKillService;

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 秒杀一(最low实现，出现超卖)
     *
     * @return JsonResult
     */
    @PostMapping("/start1")
    public JsonResult start1(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start1(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀二(lock)
     *
     * @return JsonResult
     */
    @PostMapping("/start2")
    public JsonResult start2(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start2(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀三(lock + aop)
     *
     * @return JsonResult
     */
    @PostMapping("/start3")
    public JsonResult start3(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start3(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀四(数据库悲观锁)
     *
     * @return JsonResult
     */
    @PostMapping("/start4")
    public JsonResult start4(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start4(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀五(数据库悲观锁)
     *
     * @return JsonResult
     */
    @PostMapping("/start5")
    public JsonResult start5(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start5(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀六(redis分布式锁)
     *
     * @return JsonResult
     */
    @PostMapping("/start6")
    public JsonResult start6(Integer secKillId) {
        int skillNum = 30;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start6(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 秒杀七(数据库悲观锁)
     *
     * @return JsonResult
     */
    @PostMapping("/start7")
    public JsonResult start7(Integer secKillId) {
        int skillNum = 100;
        final CountDownLatch latch = new CountDownLatch(skillNum);
        secKillService.deleteSecKill(secKillId);
        // 模拟10个用户抢5个红包
        for (int i = 1; i <= skillNum; i++) {
            int userId = i;
            Runnable task = () -> {
                JsonResult result = secKillService.start7(secKillId, userId);
                log.info("用户:{}{}", userId, result.get("msg"));
                latch.countDown();
            };
            threadPoolTaskExecutor.execute(task);
        }
        try {
            latch.await();
            log.info("一共秒杀出{}件商品", secKillService.getSecKillCount(secKillId));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
}