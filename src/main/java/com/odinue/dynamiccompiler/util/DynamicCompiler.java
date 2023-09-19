package com.odinue.dynamiccompiler.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DynamicCompiler {

    public LanguageCompiler getCompiler(String language) {
        if (language.equals("java")) {
            return new CustomJavaCompiler();
        }
        if (language.equals("freemarker")) {
            return new CustomFreemarkerCompiler();
        }
        return null;
    }
}
