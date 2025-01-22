package com.ls.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DynamicGenerator {
    public static void dynamicGenerator(String author,String output ,Boolean isWhile) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));

        configuration.setDefaultEncoding("UTF-8");

        //加载模板
        Template template = configuration.getTemplate("AcmTemplate.java.ftl");

        // 构造数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("author", author);
        data.put("output", output);
        data.put("isWhile", isWhile);

        // 生成动态代码位置
        FileWriter out = new FileWriter("acmTemplate.java");

        // 生成动态代码
        template.process(data, out);

        out.close();


    }

}
