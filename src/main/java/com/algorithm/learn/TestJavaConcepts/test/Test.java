package com.algorithm.learn.TestJavaConcepts.test;

import com.algorithm.learn.TestJavaConcepts.observe.RegisterCenter;
import com.algorithm.learn.TestJavaConcepts.observe.worker.WorkerA;
import com.algorithm.learn.TestJavaConcepts.observe.worker.WorkerB;

import java.util.Arrays;

/**
 * @Author Chen Changjiang
 * @Date 2018/9/21 16:36
 * @Description
 */
public class Test {

    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("123");
//        sb.deleteCharAt(sb.length()-1);
//        sb.append("444");
//        System.out.println(sb);
// String string = "SELECT REPLACE(UUID(),'-','') AS id," +
//         "c.source,c.patient_id,c.visit_type," +
//         "c.product_name,c.product_order_state," +
//         "c.product_hospital_name,c.case_diagnosis_info," +
//         "c.case_creator_name,c.gmt_create FROM ((SELECT '订单表' as source, " +
//         "po.patient_id, po.product_type_id as visit_type, po.product_name, " +
//         "po.order_state as product_order_state, po.hospital_name as product_hospital_name, " +
//         "'' as case_diagnosis_info, '' as case_creator_name, po.gmt_create " +
//         "FROM product_order_info po WHERE po.patient_id=:patientId) " +
//         "UNION (SELECT '健康档案表' as source, pc.patient_id, '5' as visit_type, " +
//         "'健康档案' as product_name, 0 as product_order_state, '' as product_hospital_name, " +
//         "pc.diagnosis_info as case_diagnosis_info, pc.case_creator_name, pc.gmt_create " +
//         "FROM patient_case_info pc WHERE pc.patient_id=:patientId)) AS c " +
//         "ORDER BY c.gmt_create DESC";
//        System.out.println(string);

        RegisterCenter center = new RegisterCenter();
        new WorkerA(center);
        new WorkerB(center);
        center.notifyBehavior(12);

    }
}
