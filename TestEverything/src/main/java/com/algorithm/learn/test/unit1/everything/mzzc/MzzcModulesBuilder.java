package com.algorithm.learn.test.unit1.everything.mzzc;

import com.algorithm.learn.test.unit1.util.ListAllFiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/07
 * @description :
 */
public class MzzcModulesBuilder {

    public static void main(String[] args) {
        List<String> filters = new ArrayList<>();

        MzzcModulesBuilder.buildMzzcMavenModuleStructureCode("C:\\Users\\Administrator\\Desktop\\manage", null, null);
    }

    /**
     * 根据entity创建其它模块-保证多次运行代码无误
     * <p>
     * 1.根据subProject获取到其下的所有模块与文件名
     * 2.根据模块名在facade，dao,daoImpl,facadeImpl,service，controller几个包中创建对应模块
     * 如果已经有模块，跳过
     * 3.根据entity中的模块-文件名，创建具体模块的文件，如果有该文件，则不填入
     *
     * @param subProject 子工程位置
     * @param filters    过滤-去掉不要的或者放入要进行自动编码的部分
     * @param moduleName 模块名称
     */
    public static void buildMzzcMavenModuleStructureCode(String subProject, List<String> filters, String moduleName) {
        File subProjectFile = new File(subProject);
        if (!subProjectFile.exists() || !subProjectFile.isDirectory()) {
            System.out.println("请输入正确的entity文件夹位置");
            return;
        }
        String entityDirectionLocation = findModuleLocation(subProjectFile, "entity");
        Map<String, List<String>> javaFileMap = getJavaFileMapFromEntity(entityDirectionLocation);
        List<String> modules = new ArrayList<>();
        modules.add("facade");
        modules.add("dao");
        modules.add("daoImpl");
        modules.add("service");
        modules.add("facadeImpl");
        modules.add("controller");
        buildFrequencyUsedFiles(subProjectFile, javaFileMap, modules);
    }

    private static void buildFrequencyUsedFiles(File subProjectFile, Map<String, List<String>> infoMap, List<String> modules) {
        buildDetailModuleFile(subProjectFile, infoMap, modules);

    }

    private static void buildDirectory(String moduleFileLocation) {
        File directory = new File(moduleFileLocation);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private static void buildJavaFile(String moduleLocation, List<String> javaEntities) {
        File directDirectory = new File(moduleLocation);
        String moduleName = directDirectory.getParentFile().getName();
        String moduleNameFirstUpper = moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1);
        for (String javaEntity : javaEntities) {
            String[] javaName = javaEntity.split(".java");
            String facadeJavaName = javaName[0] + moduleNameFirstUpper + ".java";
            String facadeFilePath = directDirectory.getAbsolutePath() + "/" + facadeJavaName;
            File file = new File(facadeFilePath);
            if (file.exists()) {
                System.out.println(facadeFilePath + " 已存在");
            } else {
                //TODO 书写内容，考虑使用VELOCITY实现，以具体的file来获取对应的模板
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void buildDetailModuleFile(File subProjectFile, Map<String, List<String>> infoMap, List<String> modules) {
        for (String module : modules) {
            String facadeDirectionLocation = findModuleLocation(subProjectFile, module);
            for (Map.Entry entry : infoMap.entrySet()) {
                String moduleName = entry.getKey().toString();
                String moduleFileLocation = facadeDirectionLocation + "/" + moduleName;
                buildDirectory(moduleFileLocation);
                buildJavaFile(moduleFileLocation, (List<String>) entry.getValue());
            }
        }
    }

    private static Map<String, List<String>> getJavaFileMapFromEntity(String entityDirecLocation) {
        File entityDirec = new File(entityDirecLocation);
        Map<String, List<String>> entityJavaFilesMap = new HashMap<>();
        File[] moduleFiles = entityDirec.listFiles();
        for (int i = 0; i < moduleFiles.length; i++) {
            String key = moduleFiles[i].getName();
            String absolutePath = moduleFiles[i].getAbsolutePath();
            File[] javaFiles = new File(absolutePath).listFiles();
            List<String> value = new ArrayList<>();
            for (int j = 0; j < javaFiles.length; j++) {
                value.add(javaFiles[j].getName());
            }
            entityJavaFilesMap.put(key, value);
        }
        return entityJavaFilesMap;
    }

    private static String findModuleLocation(File subProject, String moduleName) {
        List<String> filterList = new ArrayList<>();
        filterList.add("\\src\\main\\java\\");
        filterList.add(moduleName);
        List<String> allFiles = ListAllFiles.listChildrenWithFilters(subProject, filterList);
        String location = null;
        for (String file : allFiles) {
            if (file.endsWith(moduleName)) {
                location = file;
            }
        }
        return location;
    }

}
