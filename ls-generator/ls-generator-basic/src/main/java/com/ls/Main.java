package com.ls;

import com.ls.generator.StaticGenerator;

import java.io.File;

import static com.ls.generator.StaticGenerator.traverseFiles;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
//        System.out.println("projectPath = " + projectPath);
        // 获取项目根路径的父路径
//        File parentFile = new File(projectPath).getParentFile();
//        System.out.println("parentFile = " + parentFile);
        // 输入路径：ACM 示例代码模板目录
//        String inputPath = new File(parentFile, "ls-generator-demo/acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
//        String outputPath = projectPath;
//        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        traverseFiles(new File(projectPath));
    }
}