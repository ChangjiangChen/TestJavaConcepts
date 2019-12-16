package com.algorithm.learn.TestJavaConcepts.observe.worker;

import com.algorithm.learn.TestJavaConcepts.observe.RegisterCenter;

public class WorkerA extends CommonWorker {

    private RegisterCenter registerCenter;

    public WorkerA(RegisterCenter registerCenter) {
        this.registerCenter = registerCenter;
        this.registerCenter.register(this);
    }

    @Override
    public void update() {
        System.out.println("this is A");
    }

    @Override
    public String toString() {
        return "WorkerA";
    }
}
