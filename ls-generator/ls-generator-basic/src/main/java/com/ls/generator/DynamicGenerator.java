package com.ls.generator;

import com.ls.model.MainTemplateModel;
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
     * @param inputFilePath 输入文件也就是模板文件地址
     * @param outputFilePath 输出文件地址
     * @param author   作者
     * @param put      输出信息
     * @param isWhile  是否开启循环
     * @throws IOException
     * @throws TemplateException
     */
    public static void dynamicGenerator(String inputFilePath,String outputFilePath,String author,String put ,Boolean isWhile) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        String templatesPath = new File(inputFilePath).getParentFile().getPath();
//        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));
        configuration.setDirectoryForTemplateLoading(new File(templatesPath));

        configuration.setDefaultEncoding("UTF-8");

        // xxx.java.ftl
        String inputName = new File(inputFilePath).getName();


        //加载模板
        Template template = configuration.getTemplate(inputName);


        // 构造数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("author", author);
        data.put("output", put);
        data.put("isWhile", isWhile);

        //xxx.java.ftl ----> xxx.java
        String outputName = inputName.replace(".ftl", "");

        // 生成动态代码位置
//        FileWriter out = new FileWriter(outputName); //默认根路径
        if (outputFilePath == null || outputFilePath.equals("")){
FileWriter out = new FileWriter(outputName); //默认根路径
        }
        FileWriter out = new FileWriter(new File(outputFilePath,outputName));

        // 生成动态代码
        template.process(data, out);

        out.close();
        //项目的根目录
        String rootPath = System.getProperty("user.dir");
        System.out.println("动态生成代码成功：" + rootPath+outputFilePath +"/"+ outputName);


    }

    /**
     *
     * @param inputFilePath
     * @param outputFilePath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */

    public static void dynamicGenerator(String inputFilePath, String outputFilePath, MainTemplateModel model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        String templatesPath = new File(inputFilePath).getParentFile().getPath();
//        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));
        configuration.setDirectoryForTemplateLoading(new File(templatesPath));

        configuration.setDefaultEncoding("UTF-8");

        String inputName = new File(inputFilePath).getName();


        //加载模板
        Template template = configuration.getTemplate(inputName);

        // 构造数据   --- 》 传参model

        //xxx.java.ftl ----> xxx.java
        String outputName = inputName.replace(".ftl", "");

        // 生成动态代码位置
//        FileWriter out = new FileWriter(inputName); //默认根路径
        if (outputFilePath == null || outputFilePath.equals("")){
            FileWriter out = new FileWriter(outputName); //默认根路径
        }
        FileWriter out = new FileWriter(new File(outputFilePath,outputName));

        // 生成动态代码
        template.process(model, out);

        out.close();
        //项目的根目录
        String rootPath = System.getProperty("user.dir");
        System.out.println("动态生成代码成功：" + rootPath+outputFilePath +"/"+ outputName);


    }


    /**
     * 动态代码生成执行入口
     * @param args
     */
    public static void main(String[] args) throws TemplateException, IOException {
        //方法一
        dynamicGenerator("./src/main/resources/templates/AcmTemplate.java.ftl",
                "./src/main/java/com/ls/generator",
                "ls","com.ls.acm",true);


        //方法二
        MainTemplateModel model = new MainTemplateModel();
        model.setAuthor("ls");
        model.setLoop(false);
        model.setOutput("输出");

        dynamicGenerator("./src/main/resources/templates/AcmTemplate.java.ftl",
                "./src/main/java/com/ls/",
                model);


    }

}
