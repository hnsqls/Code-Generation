package com.ls.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public  void freeMarkerTest() throws IOException, TemplateException {
        //// 创建FreeMarker配置实例
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件的所在路径
        configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));

        //设置默认编码
        configuration.setDefaultEncoding("utf-8");

        //加载模板
        Template template = configuration.getTemplate("myweb.html.ftl");



        //创建数据模型
        Map<String,Object> dataModel = new HashMap<String,Object>();
        dataModel.put("currentYear", LocalDate.now().getYear());

        ArrayList<Map<String, String>> lists = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("url","www.baidu.com");
        map.put("label","百度");
        lists.add(map);
        map.clear();
        map.put("url","www.google.com");
        map.put("label","谷歌");
        lists.add(map);

        dataModel.put("menuItems",lists);

        // 指定生成的文件 路径以及名称
        FileWriter out = new FileWriter("myweb.html");
        // 生成代码
        template.process(dataModel, out);

        out.close();


    }

}
