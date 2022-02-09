package com.huminxi.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * https://javadoop.com/post/spring-ioc
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/28 11:36
 */
public class Application {
    public static void main(String[] args) {
        //用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("启动成功");
        //从 context 中取出我们的 bean，而不是用 new MessageServiceImpl() 这种方式。
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
