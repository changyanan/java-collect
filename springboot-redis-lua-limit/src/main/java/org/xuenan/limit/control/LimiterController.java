package org.xuenan.limit.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xuenan.limit.annotation.Limiter;
import org.xuenan.limit.type.LimitType;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changyanan1
 * @version 1.0.0
 * @date 2020/4/24 11:30
 */
@RestController
public class LimiterController {
    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_2 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_3 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_4 = new AtomicInteger();

    @RequestMapping("/limit1")
    @Limiter(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.CUSTOMER)
    public int customer() {
        return ATOMIC_INTEGER_1.incrementAndGet();
    }
    @RequestMapping("/limit2")
    @Limiter(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.IP)
    public int ip() {
        return ATOMIC_INTEGER_2.incrementAndGet();
    }
    @RequestMapping("/limit3")
    @Limiter(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.USER_ID)
    public int userId() {
        return ATOMIC_INTEGER_3.incrementAndGet();
    }
    @RequestMapping("/limit4")
    @Limiter(key = "ip_limit_test", period = 10, count = 3)
    public int defult() {
        return ATOMIC_INTEGER_4.incrementAndGet();
    }

}
