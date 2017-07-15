package ljx.ashin.aop;

import java.lang.reflect.Method;

/**
 * Created by AshinLiang on 2017/7/15.
 */
public class MyAdvice implements Advice {
    @Override
    public void beforMethodAdvice(Method method) {
        System.out.println("执行方法"+method.getName()+"之前，添加日志");
    }

    @Override
    public void afterMethodAdvice(Method method) {
        System.out.println("执行方法"+method.getName()+"后，处理相关的东西");
    }
}
