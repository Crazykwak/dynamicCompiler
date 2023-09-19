package com.odinue.dynamiccompiler.util;

import com.odinue.dynamiccompiler.entity.Answer;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@NoArgsConstructor
public class CustomFreemarkerCompiler implements LanguageCompiler {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
    private StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
    Map<String, Object> map = new HashMap<>();

    long startTime;
    long endTime;

    @Override
    public Answer answer(long solutionNumber, String code) {

        stringTemplateLoader.putTemplate("Solution", code);
        cfg.setTemplateLoader(stringTemplateLoader);

        try {

            Template template = cfg.getTemplate("Solution");
            StringWriter output = new StringWriter();

            startTime = System.nanoTime();
            template.process(map, output);
            endTime = System.nanoTime();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

        Object processAnswer = map.get("answer");
        boolean correct = assertAnswer(processAnswer);
        double processMilsTime = getMillstimeFromNanoTime();
        return new Answer(processMilsTime, correct);
    }

    private double getMillstimeFromNanoTime() {
        return (double) (endTime - startTime) / 1000000;
    }

    private boolean assertAnswer(Object processAnswer) {

        return true;
    }
}
