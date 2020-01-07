package com.algorithm.learn.test.unit1.generics;

/**
 * @author : ChenChangjiang
 */
public class GenericsTestModel {
    public <T> String getNameFromBean(T bean) {
        return bean.toString();
    }
}
