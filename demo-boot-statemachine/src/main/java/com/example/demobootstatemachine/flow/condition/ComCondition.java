package com.example.demobootstatemachine.flow.condition;

import com.alibaba.cola.statemachine.Condition;
import com.example.demobootstatemachine.flow.dto.ComContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ComCondition {

    /**
     * 条件/这里是个默认通过的
     */
    public Condition<ComContext> defaultPassCondition(){
        return (ctx) -> true; // 默认返回true
    }

    /**
     * 模拟 审核验证
     * @return
     */
    public Condition<ComContext> auditCondition(){
        return (ctx) -> {
            boolean equals = Objects.equals(ctx.getSessionUserId(), ctx.getCurrentNodeUserId());
            if(equals){
                return true;
            }
            throw new RuntimeException("操作用户错误");
        };
    }
}
