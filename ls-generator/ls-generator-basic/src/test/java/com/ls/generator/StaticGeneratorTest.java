package com.ls.generator;

import junit.framework.TestCase;

import java.io.File;

public class StaticGeneratorTest extends TestCase {

    /**
     * 静态代码生成测试（hutool）
     */
    public void testCopyFilesByHutool() {
        //获取根路径
        String rootPath = System.getProperty("user.dir");
        
        // 获取文件路径 用相对路径来获得
        String parentPath = new File(rootPath).getParent();
        String filePath = new File(parentPath,"ls-generator-demo").getAbsolutePath();

        StaticGenerator.copyFilesByHutool(filePath,rootPath);

    }


    public void testCopyFilesByRecursive(){
        //获取项目根路径
        String projectPath = System.getProperty("user.dir");
        //获取父路径
        String parentPath = new File(projectPath).getParent();
        //获取文件路径
        String filePath = new File(parentPath, "ls-generator-demo").getAbsolutePath();
        StaticGenerator.copyFilesByRecursive(filePath, projectPath);


    }
}