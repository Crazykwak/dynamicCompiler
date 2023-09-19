package com.odinue.dynamiccompiler.service;

import com.odinue.dynamiccompiler.entity.Answer;
import com.odinue.dynamiccompiler.util.DynamicCompiler;
import com.odinue.dynamiccompiler.util.LanguageCompiler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SolutionService {

    private final DynamicCompiler dynamicCompiler;

    public Answer answer(long solutionNumber, String language, String code) {
        LanguageCompiler compiler = dynamicCompiler.getCompiler(language);
        return compiler.answer(solutionNumber, code);
    }
}
