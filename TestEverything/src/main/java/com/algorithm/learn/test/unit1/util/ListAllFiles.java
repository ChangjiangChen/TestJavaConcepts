package com.algorithm.learn.test.unit1.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/07
 * @description :
 */
public class ListAllFiles {
    public static List<String> listChildren(File file) {
        List<String> fileNames = new ArrayList<>();
        if (file == null) {
            return fileNames;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String absolutePath = files[i].getAbsolutePath();
                fileNames.add(absolutePath);
                System.out.println(absolutePath);
                fileNames.addAll(listChildren(files[i]));
            }
        }
        return fileNames;
    }
}
