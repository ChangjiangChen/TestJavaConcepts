package com.algorithm.learn.test.unit1.everything;

import com.algorithm.learn.test.unit1.spring.learn.implementations.SpringDaoImpl;
import com.algorithm.learn.test.unit1.spring.learn.service.SpringDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.algorithm.learn.test.unit1.util.ListAllFiles.listChildren;

/**
 * @author : Chen Changjiang
 * @date : 2019/12/13
 * @description :
 */
@Configuration
@ComponentScan("com.algorithm.learn.test.unit1.spring.learn")
public class Spring {

    public static void testSpringContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring.class);

        testGetBean(context);
        testResourceLoader(context);

        StringUtils.isBlank("12");

    }

    private static void testGetBean(ApplicationContext context) {
        SpringDao springDao = context.getBean(SpringDaoImpl.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        System.out.println("=======================");
        springDao.test();
        System.out.println("=======================");
        SpringDao bean = (SpringDao) context.getBean("springDaoImpl");
        bean.test();
    }

    private static void testResourceLoader(ApplicationContext context) {
        Resource resource = context.getResource("/");
        System.out.println("resource.exists():" + resource.exists());
        File file = null;
        try {
            file = resource.getFile();
            listChildren(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(context.getClassLoader().getParent().toString());
        try {
            Resource[] resources = context.getResources("/*/*/*/*/*/*/*.class");
            System.out.println(Arrays.toString(resources));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
