package com.algorithm.learn.test.unit1.everything.mzzc;

import com.algorithm.learn.test.unit1.util.HttpRequestUtil;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : Chen Changjiang
 * @date : 2019/12/30
 * @description :
 */
public class MzzcPay {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final String SYS_ID = "1902271423530473681";
    private static final String KEY = "123456";
    private static final String SOURCE_ACCOUNT_SET_NO = "100001";
    private static final String TARGET_ACCOUNT_SET_NO = "200126";
    private static final String ADDRESS_CREATE_MEMBER = "http://180.141.91.144:6462/system/yst/foreign/createMember";
    private static final String ADDRESS_MEMBER_QUERY = "http://180.141.91.144:6462/system/yst/foreign/memInfoQueryForPerson";

    private static final String MEMBER_PERSON = "3";
    private static final String MEMBER_COMPANY = "1";

    public static void testCreateMemberForCompany() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("sysId", SYS_ID);
        params.put("change", MEMBER_COMPANY);
        params.put("useId", "YY06");
        params.put("v", "1.0");
        params.put("timestamp", SDF.format(new Date()));
        params.put("companyName", "United States of America.ctd");
        params.put("uniCredit", "1142092201131905X1");
        params.put("legalName", getBase64CodeOfString("龙中豪"));
        params.put("legalIds", "612426197309040017");
        params.put("legalPhone", "18140245582");
        params.put("accountNo", "15000098774790");
        params.put("bankName", getBase64CodeOfString("中国工商银行股份有限公司绵阳火炬支行"));
        params.put("parentBankName", getBase64CodeOfString("中国工商银行"));
        params.put("unionBank", "102659000813");
        String generatedUrlWithSign = generatedParamsUrlWithSign(params);
        String response = new HttpRequestUtil().sendPost(ADDRESS_CREATE_MEMBER, generatedUrlWithSign);
        System.out.println(response);
    }

    /**
     * {
     * "realName": "王大锤",
     * "yunid": "9b267a8f16d045b1bdd93376f6e60abf",
     * "code": "0000",
     * "memberType": 3
     * }
     */
    public static void memInfoQueryForPerson() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("yunid", "9b267a8f16d045b1bdd93376f6e60abf");
        params.put("timestamp", SDF.format(new Date()));
        params.put("v", "1.0");
        String urlParamsWithSign = generatedParamsUrlWithSign(params);
        String response = new HttpRequestUtil().sendPost(ADDRESS_MEMBER_QUERY, urlParamsWithSign);
        System.out.println(response);
    }

    /**
     * {
     * "yunid": "9b267a8f16d045b1bdd93376f6e60abf",
     * "code": "0000"
     * }
     */
    public static void testCreateMemberForPerson() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("sysId", SYS_ID);
        params.put("change", MEMBER_PERSON);
        params.put("useId", "XX06");
        params.put("v", "1.0");
        params.put("timestamp", SDF.format(new Date()));
        params.put("name", getBase64CodeOfString("王大锤"));
        params.put("identityNo", "612426198809040013");
        String generatedUrlWithSign = generatedParamsUrlWithSign(params);
        String response = new HttpRequestUtil().sendPost(ADDRESS_CREATE_MEMBER, generatedUrlWithSign);
        System.out.println(response);
    }

    private static String getBase64CodeOfString(String value) {
        String baseCode = "";
        try {
            byte[] encode = Base64.getEncoder().encode(value.getBytes("UTF-8"));
            baseCode = new String(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return baseCode;
    }

    private static String generatedParamsUrlWithSign(TreeMap<String, Object> sortedMap) {
        if (sortedMap.isEmpty()) {
            return null;
        }
        sortedMap.put("key", KEY);
        String paramsForSign = getParamUrlFromMap(sortedMap);
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(paramsForSign.getBytes());
        sortedMap.remove("key");
        sortedMap.put("sign", md5DigestAsHex);
        return getParamUrlFromMap(sortedMap);
    }

    private static String getParamUrlFromMap(TreeMap<String, Object> sortedMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
        }
        if (stringBuilder.length() != 0) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return "";
    }

}
