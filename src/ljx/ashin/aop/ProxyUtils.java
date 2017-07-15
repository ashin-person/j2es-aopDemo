package ljx.ashin.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jvm动态代理的工具类，用于获取动态代理类
 * Created by AshinLiang on 2017/7/15.
 */
public class ProxyUtils {
    //传入 目标类target 通告advice
    public static Object getProxyObj(final Object target, final Advice advice){

        Object proxyObj = (Object) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //添加通告
                        advice.beforMethodAdvice(method);
                        //调用目标类的业务方法
                       Object resultObj =  method.invoke(target,args);
                        //添加通告
                        advice.afterMethodAdvice(method);
                        return resultObj;
                    }
                });

        return proxyObj;
    }
}
