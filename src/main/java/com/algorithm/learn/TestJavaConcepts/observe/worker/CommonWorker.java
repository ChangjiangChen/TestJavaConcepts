package com.algorithm.learn.TestJavaConcepts.observe.worker;

import com.algorithm.learn.TestJavaConcepts.observe.RegisterCenter;

public class CommonWorker {

    public void update(int state) {
        System.out.println(this.toString() + " ==> state初始值为" + state);
    }

    public void update() {
    }

}
