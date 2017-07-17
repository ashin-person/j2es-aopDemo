# j2es-aopDemo
手写一个简单的AOP框架

先在config.properties的配置文件上配置好类，如果是需要切面，则需要配置一个
key的value是ljx.ashin.aop.ProxyFactoryBean，然后通过springBeanFactory获取bean，如下面
studentService.advice = ljx.ashin.aop.MyAdvice
studentService.target = ljx.ashin.service.StudentServiceImpl
studentService = ljx.ashin.aop.ProxyFactoryBean

