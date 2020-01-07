package com.algorithm.learn.test.unit1.everything.mzzc;

public interface PomText {
    String modulePomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
            "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "    <parent>\n" +
            "        <artifactId>parent</artifactId>\n" +
            "        <groupId>com.jf.mzzc</groupId>\n" +
            "        <version>1.0-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "    <artifactId>0575cc6a-d7b2-4bad-abcf-70b794ea6b92</artifactId>\n" +
            "    <packaging>pom</packaging>\n" +
            "    <modules>\n" +
            "        <module>0575cc6a-d7b2-4bad-abcf-70b794ea6b92-facade</module>\n" +
            "        <module>0575cc6a-d7b2-4bad-abcf-70b794ea6b92-service</module>\n" +
            "        <module>0575cc6a-d7b2-4bad-abcf-70b794ea6b92-web</module>\n" +
            "    </modules>\n" +
            "    <dependencies>\n" +
            "        <dependency>\n" +
            "            <groupId>com.jf.mzzc</groupId>\n" +
            "            <artifactId>common</artifactId>\n" +
            "            <version>1.0-SNAPSHOT</version>\n" +
            "        </dependency>\n" +
            "    </dependencies>\n" +
            "</project>";

    String modulePomReplacement = "0575cc6a-d7b2-4bad-abcf-70b794ea6b92";


    String webPomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
            "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "    <parent>\n" +
            "        <artifactId>18cfb20b-b92f-4a00-b6cf-e9cb60ca4ab9</artifactId>\n" +
            "        <groupId>com.jf.mzzc</groupId>\n" +
            "        <version>1.0-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "    <artifactId>18cfb20b-b92f-4a00-b6cf-e9cb60ca4ab9-web</artifactId>\n" +
            "    <dependencies>\n" +
            "        <dependency>\n" +
            "            <groupId>com.jf.platform</groupId>\n" +
            "            <artifactId>core-web</artifactId>\n" +
            "            <version>1.0-SNAPSHOT</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>com.jf.mzzc</groupId>\n" +
            "            <artifactId>18cfb20b-b92f-4a00-b6cf-e9cb60ca4ab9-facade</artifactId>\n" +
            "            <version>1.0-SNAPSHOT</version>\n" +
            "        </dependency>\n" +
            "        <!-- Swagger -->\n" +
            "        <dependency>\n" +
            "            <groupId>io.springfox</groupId>\n" +
            "            <artifactId>springfox-swagger2</artifactId>\n" +
            "            <version>2.9.2</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>io.springfox</groupId>\n" +
            "            <artifactId>springfox-swagger-ui</artifactId>\n" +
            "            <version>2.9.2</version>\n" +
            "        </dependency>\n" +
            "    </dependencies>\n" +
            "    <build>\n" +
            "        <plugins>\n" +
            "            <plugin>\n" +
            "                <groupId>org.springframework.boot</groupId>\n" +
            "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
            "            </plugin>\n" +
            "        </plugins>\n" +
            "    </build>\n" +
            "</project>";

    String webPomReplacement = "18cfb20b-b92f-4a00-b6cf-e9cb60ca4ab9";

    String servicePomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
            "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "    <parent>\n" +
            "        <artifactId>5fe56b16-ca1a-47a7-b7e2-8c9685ff013f</artifactId>\n" +
            "        <groupId>com.jf.mzzc</groupId>\n" +
            "        <version>1.0-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "    <artifactId>5fe56b16-ca1a-47a7-b7e2-8c9685ff013f-service</artifactId>\n" +
            "    <dependencies>\n" +
            "        <dependency>\n" +
            "            <groupId>com.jf.platform</groupId>\n" +
            "            <artifactId>core-service</artifactId>\n" +
            "            <version>1.0-SNAPSHOT</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>com.jf.mzzc</groupId>\n" +
            "            <artifactId>5fe56b16-ca1a-47a7-b7e2-8c9685ff013f-facade</artifactId>\n" +
            "            <version>1.0-SNAPSHOT</version>\n" +
            "        </dependency>\n" +
            "    </dependencies>\n" +
            "    <build>\n" +
            "        <plugins>\n" +
            "            <plugin>\n" +
            "                <groupId>org.springframework.boot</groupId>\n" +
            "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
            "            </plugin>\n" +
            "        </plugins>\n" +
            "    </build>\n" +
            "</project>";

    String servicePomReplacement = "5fe56b16-ca1a-47a7-b7e2-8c9685ff013f";

    String facadePomText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
            "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "    <parent>\n" +
            "        <artifactId>63665a27-e4c4-411c-bdd3-5d0eaa8c8c30</artifactId>\n" +
            "        <groupId>com.jf.mzzc</groupId>\n" +
            "        <version>1.0-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "    <artifactId>63665a27-e4c4-411c-bdd3-5d0eaa8c8c30-facade</artifactId>\n" +
            "</project>";

    String facadePomReplacement = "63665a27-e4c4-411c-bdd3-5d0eaa8c8c30";
}
