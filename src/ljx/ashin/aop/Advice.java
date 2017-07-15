package ljx.ashin.aop;

import java.lang.reflect.Method;

/**
 * 通告接口
 * Created by AshinLiang on 2017/7/15.
 */
public interface Advice {
    public void beforMethodAdvice(Method method);
    public void afterMethodAdvice(Method method);
}
