package com.algorithm.learn.test.unit1.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author : Chen Changjiang
 * @date : 2019/12/16
 * @description :
 */
public class VelocityDemo {
    private Map<String, Object> paramMaps;

    private String filePath;

    public VelocityDemo(Map<String, Object> paramMaps, String filePath) {
        this.paramMaps = paramMaps;
        this.filePath = filePath;
    }

    public void initVecocity() {
        VelocityEngine ve = new VelocityEngine();
        //设置模板加载路径，这里设置的是class下
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            //进行初始化操作
            ve.init();
            //加载模板，设定模板编码
            Template t = ve.getTemplate("initVelocity.vm", "UTF-8");
            //设置初始化数据
            VelocityContext context = new VelocityContext();
            for (Map.Entry entry : paramMaps.entrySet()) {
                context.put(entry.getKey().toString(), entry.getValue());
            }

            //设置输出
            PrintWriter writer = new PrintWriter(filePath);
            //将环境数据转化输出
            t.merge(context, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
