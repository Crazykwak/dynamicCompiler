package com.odinue.dynamiccompiler.util;

import com.odinue.dynamiccompiler.entity.Answer;

public interface LanguageCompiler {

    Answer answer(long solutionNumber, String code);
}
