package com.algorithm.learn.test.unit1.spring.learn.implementations;
import com.algorithm.learn.test.unit1.spring.learn.service.SpringDao;
import org.springframework.stereotype.Service;

/**
 * @author : Chen Changjiang
 * @date : 2019/11/21
 * @description :
 */
@Service
public class SpringDaoImpl implements SpringDao {
    @Override
    public void test() {
        System.out.println("SpringDao implementation: SpringDaoImpl");
    }
}
