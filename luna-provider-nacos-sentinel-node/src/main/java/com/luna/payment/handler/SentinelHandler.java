package com.luna.payment.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;

/**
 * @author luna@mac
 * @className SentinelHandler.java
 * @description TODO
 * @createTime 2021年02月04日 00:01:00
 */
public class SentinelHandler {

    public static CommonResult handlerExceptionI(BlockException blockException) {
        return new CommonResult(400, "按客户自定义 1⃣️,global handler", "不🉑️");
    }

    public static CommonResult handlerExceptionII(BlockException blockException) {
        return new CommonResult(400, "按客户自定义 2⃣️,global handler", "不🉑️");
    }
}
