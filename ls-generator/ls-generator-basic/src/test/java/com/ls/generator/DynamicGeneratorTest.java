package com.ls.generator;

import freemarker.template.TemplateException;
import junit.framework.TestCase;

import java.io.IOException;

public class DynamicGeneratorTest extends TestCase {
    public static void main(String[] args) throws TemplateException, IOException {
        DynamicGenerator.dynamicGenerator("ls0","总和是",true);
    }

}