package com.algorithm.learn.test.unit1.everything;

import com.algorithm.learn.test.unit1.entity.BaseResponse;
import com.algorithm.learn.test.unit1.entity.User;
import com.algorithm.learn.test.unit1.entity.XmlTestEntity;
import com.algorithm.learn.test.unit1.generics.GenericsTestModel;
import com.algorithm.learn.test.unit1.innerclass.Child;
import com.algorithm.learn.test.unit1.innerclass.Father;
import com.algorithm.learn.test.unit1.jpanel.JavaPanelUsageOf520;
import com.algorithm.learn.test.unit1.jpanel.TestJPanel;
import com.algorithm.learn.test.unit1.velocity.VelocityDemo;
import com.algorithm.learn.test.unit1.xml.XmlTools;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Everything {

    /**
     * @param key             对应文件中的属性键名
     * @param projectPath     工程的具体位置
     * @param fileNameFilters 过滤-正向过滤，即包含该内容才会展示出来
     * @throws IOException
     */
    public static void displayValuesInPropertiesOfProject(String key, String projectPath, List<String> fileNameFilters) throws IOException {
        File project = new File(projectPath);
        if (!project.exists()) {
            System.out.println("project path not exist!");
            return;
        }
        Set<String> strings = readAllFiles(project);
        ArrayList<String> fileNames = new ArrayList<>(strings);
        Properties properties = new Properties();
        for (int i = 0; i < fileNames.size(); i++) {
            String fileName = fileNames.get(i);
            boolean pass = true;
            for (int j = 0; j < fileNameFilters.size(); j++) {
                String filter = fileNameFilters.get(j);
                if (!fileName.contains(filter)) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                properties.load(new FileInputStream(fileName));
                String property = properties.getProperty(key);
                //寻找是否在别的文件中
                System.out.println(fileName + " -->");
                System.out.println(property);
                properties.clear();
            }
        }
    }

    public static Set<String> readAllFiles(File file) {
        Set<String> fileNames = new HashSet<>();
        if (file == null) {
            return fileNames;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                fileNames.addAll(readAllFiles(files[i]));
            }
        } else {
            fileNames.add(file.getAbsolutePath());
        }
        return fileNames;
    }

    public static void testXml() {
        XmlTestEntity xmlTestEntity = new XmlTestEntity();
        xmlTestEntity.setErrorcode("1");
        xmlTestEntity.setMessage("提交成功");
        xmlTestEntity.setSMSID("76951651");
        String serialize = XmlTools.serialize(xmlTestEntity);
        System.out.println(serialize);
        System.out.println("=========================");
        String string = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<sendresult>\n" +
                "\t<errorcode>1</errorcode>\n" +
                "\t<message>提交成功</message>\n" +
                "\t<SMSID>76951651</SMSID>\n" +
                "</sendresult>";
        XmlTestEntity deserialize = XmlTools.deserialize(XmlTestEntity.class, string);
        System.out.println(deserialize);

        System.out.println("============================");
        String testWrong = "1234";
        XmlTestEntity deserializeWrong = XmlTools.deserialize(XmlTestEntity.class, testWrong);
        System.out.println(deserializeWrong);
    }

    public static void testJPanel() {
        TestJPanel.init();
    }

    public static void testInnerClass() {
        /// 打开包裹部分可看到为什么要这么设计
        //  System.out.println(new Child().getBoyClass().getBoy());
        System.out.println(new Child().getBoy());
        System.out.println(new Child().getGirl());

    }

    public static void testJPanelFor520() {
        new JavaPanelUsageOf520();
    }

    public static void testVelocity() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "13");
        String filePath = "C:\\Users\\Administrator\\Desktop\\test.html";
        new VelocityDemo(map, filePath).initVecocity();
    }

    /**
     * 简单测试泛型用法
     */
    public static void testGenerics() {
        Father father = new Father();
        GenericsTestModel genericsTestModel = new GenericsTestModel();
        System.out.println(genericsTestModel.getNameFromBean(father));
    }

    public static void testBugOfMessageCode() {
        Object str = "\"936344\"";
        String time = str.toString();
        Long timeCode = Long.parseLong(time.substring(1, time.length() - 1));
        System.out.println(timeCode);
    }

    /**
     * 测试竖线的分割
     */
    public static void testSplitVerticalBar() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        JSONArray jsonArray = new JSONArray();
        String[] nameArray = "ABBDJKLSKELA|TESSKJKLDSA".split("|");
        for (int i = 0; i < nameArray.length; i++) {
            String name = nameArray[i];
            JSONObject json = new JSONObject();
            json.put("name", name);
            json.put("number", i);
            jsonArray.add(json);
        }
        baseResponse.setData(jsonArray);
        JSONObject json = (JSONObject) JSONObject.toJSON(baseResponse);
        System.out.println(json);
    }

    /**
     * 切割的字段越复杂，StringUtils的优势越明显
     * --String的split用的是正则表达式
     */
    public static void compareSplitTimeSpendOfStringAndStringUtils() {
        String innerComma = "1XX2XX3";
        final long stringSplitStartTime = System.currentTimeMillis();
        final int count = 1000000;
        for (int i = 0; i < count; i++) {
            innerComma.split("XX");
        }
        System.out.println("String.split(String separator) -- time consuming:" + Long.toString(System.currentTimeMillis() - stringSplitStartTime));
        final long stringUtilsSplitStartTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            StringUtils.split(innerComma, "XX");
        }
        System.out.println("StringUtils.split(String string,String separator) -- time consuming:" + Long.toString(System.currentTimeMillis() - stringUtilsSplitStartTime));
    }

    /**
     * Pattern的一般用法，注意为什么要定义一个final变量
     */
    private static final Pattern PATTERN = Pattern.compile("123");

    public static void commonUsageOfPattern() {
        boolean matches = PATTERN.matcher("123").matches();
        System.out.println(matches);
    }

    /**
     * alibaba-fastjson
     * 也有可以转为Map.Entry的方法
     */
    public static void parseJsonObjectToMapEntry() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "1");
        jsonObject.put("2", "2");
        jsonObject.put("1", "2");
        for (Map.Entry entry : jsonObject.entrySet()) {
            System.out.println(entry.getKey().toString() + "==" + entry.getValue().toString());
        }
    }

    public static void testSubStringIndex2() {
        String s = UUID.randomUUID().toString() + 1 + 0;
        System.out.println(s.length());
        System.out.println(s.charAt(36));
        System.out.println(s.substring(37));
    }

    /**
     * 比较ArrayList和它的内部类SubList
     */
    public static void compareArrayListAndItsSubList() {
        ArrayList<String> originalArrayList = new ArrayList<>();
        originalArrayList.add("123");
        originalArrayList.add("456");
        ArrayList<String> strings = (ArrayList<String>) originalArrayList.subList(0, 1);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 数组的向上转型和向下转型
     */
    public static void compareCastOfArray() {
        Object[] objects = new Object[]{"1", "2"};
        String[] object = (String[]) objects;
        System.out.println(object);
    }

    /**
     * 比较原生String类和StringUtils的split
     */
    public static void compareSplitOfStringAndStringUtils() {
        String innerComma = "1,2,,,,,,3";
        String outerComma = "1,2,3,,,,,,";
        System.out.println(innerComma.split(",").length);
        System.out.println(StringUtils.split(innerComma, ",").length);
        System.out.println("===============");
        System.out.println(outerComma.split(",").length);
        System.out.println(StringUtils.split(outerComma, ",").length);
    }

    /**
     * 1.if条件里放入"1"和"2"的区别
     * 2.add加入进去的顺序；爆出什么异常，原理解释
     */
    public static void thinkMore1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String string : list) {
            if ("2".equals(string)) {
                System.out.println(string);
                list.remove(string);
            }
        }
    }

    /**
     * 比较Integer的大小
     */
    public static void compareInteger() {
        Integer a = 254;
        Integer b = 254;
        Integer c = 127;
        Integer d = 127;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println("=========");
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
    }

    /**
     * alibaba-fastjson
     * 将JSON字符串转换为对应类型
     */
    public static void parseJsonStringToTypeReference() {
        User user = JSONObject.parseObject("{\"name\":\"用户名\",\"password\":\"123\"}", new TypeReference<User>() {
        });
        System.out.println(user);
    }

    /**
     * 加密显示，但是不确定具体在哪一位
     */
    public static void testSubStringIndex1() {
        String identityNumber = "612426198809030018";
        System.out.println(identityNumber.substring(0, identityNumber.length() - 4) + "****");

        String phoneNumber = "13355884466";
        System.out.println(phoneNumber.substring(0, phoneNumber.length() - 8) + "****" + phoneNumber.substring(phoneNumber.length() - 4));
    }

    /**
     * 测试@JsonIgnore
     */
    public static void testJsonIgnore() {
        User user = new User();
        user.setName("用户名");
        user.setPassword("PASSWORD");
        System.out.println(JSONObject.toJSONString(user));
        try {
            System.out.println(new ObjectMapper().writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static class BooleanPropertyStartWithIs {
        private boolean isReal;

        public boolean isReal() {
            return isReal;
        }

        /**
         * why we don't name a boolean property start with 'is'
         *
         * @param real
         */
        public void setReal(boolean real) {
            isReal = real;
        }
    }


    /**
     * 常用方法，前后相减大于0返回1则是由小到大的顺序排列
     */
    public static void testHowComparatorSort() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 > 0 ? 1 : -1;
            }
        });
        System.out.println(list.toString());
    }

    public static void testWhyOverrideHashcodeWithEquals() {
        OnlyEqualChanged xiaoqiang = new OnlyEqualChanged("xiaoqiang");
        OnlyEqualChanged otherXiaoqiang = new OnlyEqualChanged("xiaoqiang");
        System.out.println("xiaoqiang.equals(otherXiaoqiang) -> " + xiaoqiang.equals(otherXiaoqiang));
        Set<OnlyEqualChanged> set = new HashSet<>();
        set.add(xiaoqiang);
        set.add(otherXiaoqiang);
        System.out.println("2 xiaoqiang with same name in 1 set -> " + set.size());
        System.out.println("重写equals保证属性比较相等，但想判断在集合中是否为同一个对象则要hashcode重写");

        System.out.println("xiaoqiang == otherXiaoqiang -> " + (xiaoqiang == otherXiaoqiang));
    }

    /**
     * 根据name来区分是否为同一个对象
     */
    private static class OnlyEqualChanged {

        OnlyEqualChanged(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            //排除同一个对象与null的情况
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            //避免不同类有相同的属性，为后面的cast准备
            if (getClass() != obj.getClass()) {
                return false;
            }
            OnlyEqualChanged other = (OnlyEqualChanged) obj;
            if (name == null && other.getName() == null) {
                return true;
            } else if (name == null && other.getName() != null) {
                return false;
            } else if (!name.equals(other.getName())) {
                return false;
            }
            return true;
        }
/// 查看hashcode重写前后的结果
//        @Override
//        public int hashCode() {
//            int result = 17;
//            result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
//            return result;
//        }
    }
}
