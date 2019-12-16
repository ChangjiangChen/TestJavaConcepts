package com.algorithm.learn.TestJavaConcepts.observe.worker;

import com.algorithm.learn.TestJavaConcepts.observe.RegisterCenter;

public class WorkerB extends CommonWorker {
    private RegisterCenter registerCenter;

    public WorkerB(RegisterCenter registerCenter) {
        this.registerCenter = registerCenter;
        this.registerCenter.register(this);
    }

    @Override
    public void update() {
        System.out.println("this is B");
    }

    @Override
    public String toString() {
        return "WorkerB";
    }
}
