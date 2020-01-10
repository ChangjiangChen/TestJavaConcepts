package com.algorithm.learn.test.unit1.everything.mzzc;

import com.algorithm.learn.test.unit1.util.ListAllFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/07
 * @description :
 */
public class MzzcStructureBuilder {


    /**
     * 创建模块 模块名称与子模块的名称是靠-来进行区分的 -保证多次运行代码无误
     * <p>
     * 作为工程下的一个子模块，在输入位置后，生成本版本的facade,service,web三个模块以及下面的包
     * 1.建立工程模块-含pom
     * 2.建立子工程模块-含pom，具体的java包以及配置文件
     *
     * @param projectLocation 工程文件夹位置
     * @param moduleName      模块名称
     */
    public static void buildMzzcMavenModule(String projectLocation, String moduleName) {
        File project = new File(projectLocation);
        if (!project.isDirectory()) {
            System.out.println(projectLocation + " 文件夹不存在");
            return;
        }
        //建立工程的子模块
        String moduleDirectory = createModuleDirectory(projectLocation, moduleName, PomText.modulePomText, PomText.modulePomReplacement);
        //建立子模块的子模块
        String facadeModule = moduleName + "-facade";
        String serviceModule = moduleName + "-service";
        String webModule = moduleName + "-web";
        createModuleDirectory(moduleDirectory, facadeModule, PomText.facadePomText, PomText.facadePomReplacement);
        createModuleDirectory(moduleDirectory, serviceModule, PomText.servicePomText, PomText.servicePomReplacement);
        createModuleDirectory(moduleDirectory, webModule, PomText.webPomText, PomText.webPomReplacement);
        //建立子模块下的具体文件包（相对比较特殊）
        File moduleFile = new File(moduleDirectory);
        List<String> fileNames = ListAllFiles.listChildren(moduleFile);
        List<String> directoryNames = new ArrayList<>();
        for (String fileName : fileNames) {
            if (fileName.endsWith(facadeModule + "\\src\\main\\java")) {
                directoryNames.add(createDetailPackageName(moduleName, fileName, "facade"));
                directoryNames.add(createDetailPackageName(moduleName, fileName, "entity"));
            } else if (fileName.endsWith(serviceModule + "\\src\\main\\java")) {
                directoryNames.add(createDetailPackageName(moduleName, fileName, "dao"));
                directoryNames.add(createDetailPackageName(moduleName, fileName, "daoImpl"));
                directoryNames.add(createDetailPackageName(moduleName, fileName, "facadeImpl"));
                directoryNames.add(createDetailPackageName(moduleName, fileName, "service"));
            } else if (fileName.endsWith(webModule + "\\src\\main\\java")) {
                directoryNames.add(createDetailPackageName(moduleName, fileName, "controller"));
            } else if (fileName.endsWith(serviceModule + "\\src\\main\\resources")) {
                try {
                    new File(fileName + "/application.properties").createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (fileName.endsWith(webModule + "\\src\\main\\resources")) {
                try {
                    new File(fileName + "/application.properties").createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        buildDirectory(directoryNames);
    }

    private static String createDetailPackageName(String moduleName, String fileAbsolutePath, String detailPackage) {
        return fileAbsolutePath + "/com/jf/mzzc/" + moduleName + "/" + detailPackage;
    }

    /**
     * 创建模块文件夹
     *
     * @param path
     * @param module
     */
    private static String createModuleDirectory(String path, String module, String pomText, String replacement) {
        //1.创建模块文件夹
        String modulePath = path + "/" + module;
        File moduleProject = new File(modulePath);
        if (!isProjectPomModule(moduleProject)) {
            //如果不是pom工程，即具体的jar，war工程时，需要建立标准的Maven文件结构
            buildMavenDirectory(modulePath);
        }
        //如果模块存在，不创建，如果不存在则创建
        boolean moduleProjectDirectoryBuild;
        if (!moduleProject.exists()) {
            moduleProjectDirectoryBuild = moduleProject.mkdir();
        } else {
            moduleProjectDirectoryBuild = true;
        }
        if (!moduleProjectDirectoryBuild) {
            System.out.println("模块创建失败");
            return null;
        }
        //2.为模块创建pom
        createPomForModule(path, modulePath, pomText, replacement);
        return modulePath;
    }

    private static void buildDirectory(List<String> fileNames) {
        for (String fileName : fileNames) {
            new File(fileName).mkdirs();
        }
    }

    private static void buildMavenDirectory(String modulePath) {
        List<String> fileNames = new ArrayList<>();
        fileNames.add(modulePath + "/src/main/java");
        fileNames.add(modulePath + "/src/main/resources");
        fileNames.add(modulePath + "/src/test/java");
        fileNames.add(modulePath + "/src/main/resources");
        buildDirectory(fileNames);
    }

    /**
     * 创建pom并写入内容 -- 根据通用的模板，替换掉其中的关键字段
     *
     * @param path
     * @param modulePath
     * @param pomText
     * @param replacement
     */
    private static void createPomForModule(String path, String modulePath, String pomText, String replacement) {
        try {
            //1.建pom文件
            String pomFilePath = modulePath + "/pom.xml";
            File file = new File(pomFilePath);
            File moduleFile = new File(modulePath);
            String moduleName = moduleFile.getName();
            //如果是具体的jar，war的pom，其中的关键字段即父工程的文件名
            //避免出现pay-service-service的情况出现
            if (!isProjectPomModule(moduleFile)) {
                moduleName = moduleFile.getParentFile().getName();
            }
            //2.写入具体内容
            FileOutputStream outputStream = new FileOutputStream(file);
            String pomTextString = pomText.replace(replacement, moduleName);
            outputStream.write(pomTextString.getBytes());
            outputStream.close();
            //3.创建
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(path + "下的pom.xml创建失败");
            e.printStackTrace();
        }
    }

    /**
     * 判断该模块是否是<packaging>pom</packaging>，根据判断结果返回可以使用的模块名称
     *
     * @param moduleFile
     * @return
     */
    private static boolean isProjectPomModule(File moduleFile) {
        String moduleName = moduleFile.getName();
        return !moduleName.contains("-");
    }

}
