package ljx.ashin.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理bean的父类
 * Created by AshinLiang on 2017/7/17.
 */
public class ProxyFactoryBean {
    /**
     * 通告
     */
    private Advice advice;
    /**
     * 目标类
     */
    private Object target;

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 获取代理类
     * @param advice 通告
     * @param target 目标类
     * @return
     */
    public Object getProxyObj(final Advice advice, final Object target){
        this.advice = advice;
        this.target = target;

        Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.beforMethodAdvice(method);

                        Object obj =   method.invoke(target,args);
                        advice.afterMethodAdvice(method);

                        return obj;
                    }
                });
        return object;
    }
}
