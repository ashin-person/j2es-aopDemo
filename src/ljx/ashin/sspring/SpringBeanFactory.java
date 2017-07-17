package ljx.ashin.sspring;

import ljx.ashin.aop.Advice;
import ljx.ashin.aop.ProxyFactoryBean;

import java.io.InputStream;
import java.util.Properties;

/**
 * 简单的一个spring框架
 * Created by AshinLiang on 2017/7/17.
 */
public class SpringBeanFactory {
    private static Properties properties;
    private static InputStream inputStream;
    private SpringBeanFactory(){};

    //初始化
    static {
        init();
    }

    //初始化方法
    private static void init(){
        properties = new Properties();
        try {
            inputStream = SpringBeanFactory.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取工厂的bean
     * @param beanName
     * @return
     */
    public static Object getBeanFromFactory(String beanName){
        Object proxyObj = null;
        String beanNameValue = "";
        String beanNameAdviceValue = "";
        String beanNameTargetValue = "";
        if(null!=beanName&&!"".equals(beanName)){
            try {
                beanNameValue = properties.getProperty(beanName);
                Class clazz = Class.forName(beanNameValue);
                Object clazzObj = clazz.newInstance();
                if(clazzObj instanceof ProxyFactoryBean){
                    //获取该类的advice和target
                    beanNameAdviceValue =properties.getProperty( beanName+".advice");
                    beanNameTargetValue =properties.getProperty( beanName+".target");
                    Advice advice = (Advice) Class.forName(beanNameAdviceValue).newInstance();
                    Object target = Class.forName(beanNameTargetValue).newInstance();
                    ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)clazzObj;
                    proxyFactoryBean.setAdvice(advice);
                    proxyFactoryBean.setTarget(target);

                    proxyObj = proxyFactoryBean.getProxyObj(advice,target);
                }else {
                    proxyObj = clazzObj;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("类名不能为空");

        }

        return proxyObj;
    }


}
