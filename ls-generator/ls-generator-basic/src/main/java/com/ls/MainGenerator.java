package com.ls;

import com.ls.generator.DynamicGenerator;
import com.ls.generator.StaticGenerator;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 代码生成
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        //获取项目根路径
        String rootPath = System.getProperty("user.dir");
        //获取静态模板路径
        String parentPath = new File(rootPath).getParent();
        File staticfile = new File(parentPath, "ls-generator-demo/acm-template/readme.md");
        System.out.println("静态代码生成："+ rootPath +"/" +staticfile.getName());
        //获取动态模板路径

       String dynamicPath =  "./src/main/resources/templates/AcmTemplate.java.ftl";

        //生成静态代码
        StaticGenerator.copyFilesByRecursive(staticfile.getPath(),rootPath);

        //生成动态代码
        DynamicGenerator.dynamicGenerator(dynamicPath,"ls","ls-generator-demo",true);
    }


}