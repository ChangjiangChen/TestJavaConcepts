package com.algorithm.learn.test.unit1;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author : ChenChangjiang
 */

public class TestEverything {

    public static void main(String[] args) throws IOException {
//        String fileLocation = "D:\\platform\\pom.xml";
//        addModuleForPom(fileLocation);
        System.out.println(UUID.randomUUID().toString());
    }

    private static void addModuleForPom(String pomFileLocation) throws IOException {
        FileInputStream fis = new FileInputStream(new File(pomFileLocation));
        MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
        try {
            Model model = mavenXpp3Reader.read(fis);
            model.addModule("test");
            new MavenXpp3Writer().write(new FileOutputStream(new File(pomFileLocation)), model);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }


}
