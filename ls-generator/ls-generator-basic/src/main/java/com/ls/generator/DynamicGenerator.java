package com.ls.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DynamicGenerator {
    /**
     *
     * @param input 输入文件也就是模板文件地址

     * @param author   作者
     * @param put      输出信息
     * @param isWhile  是否开启循环
     * @throws IOException
     * @throws TemplateException
     */
    public static void dynamicGenerator(String input,String author,String put ,Boolean isWhile) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        String templatesPath = new File(input).getParentFile().getPath();
//        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));
        configuration.setDirectoryForTemplateLoading(new File(templatesPath));

        configuration.setDefaultEncoding("UTF-8");

        String inputName = new File(input).getName();


        //加载模板
        Template template = configuration.getTemplate(new File(input).getName());

        // 构造数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("author", author);
        data.put("output", put);
        data.put("isWhile", isWhile);

        // 生成动态代码位置
        FileWriter out = new FileWriter(inputName);

        // 生成动态代码
        template.process(data, out);

        out.close();
        //项目的根目录
        String rootPath = System.getProperty("user.dir");
        System.out.println("动态生成代码成功：" + rootPath +"/"+ inputName);


    }

    /**
     * 动态代码生成执行入口
     * @param args
     */
    public static void main(String[] args) throws TemplateException, IOException {
        dynamicGenerator("./src/main/resources/templates/AcmTemplate.java.ftl",
                "ls","com.ls.acm",true);


    }

}
