package ljx.ashin.aop;

import ljx.ashin.service.StudentService;
import ljx.ashin.service.StudentServiceImpl;
import ljx.ashin.sspring.SpringBeanFactory;

/**
 * Created by AshinLiang on 2017/7/15.
 */
public class AppMain {
    public static void main(String[] args) {
       /* StudentService studentServiceProxy = (StudentService) ProxyUtils.getProxyObj(new StudentServiceImpl(),new MyAdvice());
        studentServiceProxy.getMsg();*/
        StudentService proxyFactoryBean =(StudentService) SpringBeanFactory.getBeanFromFactory("studentService");
        System.out.println(proxyFactoryBean.getClass().getName());
    }
}
