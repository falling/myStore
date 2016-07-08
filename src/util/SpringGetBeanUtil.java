package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by falling on 16/7/6.
 */
public class SpringGetBeanUtil {
    public static Object getBean(String BeanId){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        return context.getBean(BeanId);
    }
}
