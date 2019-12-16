package com.algorithm.learn.TestJavaConcepts.observe;

import com.algorithm.learn.TestJavaConcepts.observe.worker.CommonWorker;

import java.util.ArrayList;
import java.util.List;

public class RegisterCenter {
    private List<CommonWorker> list = new ArrayList<CommonWorker>();
    private int state = 0;


    //全体通知
    private void notifyAllWorker() {
        for (CommonWorker worker : list) {
            worker.update();
        }
    }

    //注册时，给它自己一个提示，不通知其它worker
    public void register(CommonWorker worker) {
        list.add(worker);
        worker.update(state);
    }

    public int getState() {
        return state;
    }

    //通知到全体的方法
    public void notifyBehavior(int state) {
        notifyAllWorker();
    }
}
