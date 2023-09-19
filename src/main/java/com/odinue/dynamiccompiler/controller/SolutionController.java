package com.odinue.dynamiccompiler.controller;

import com.odinue.dynamiccompiler.entity.Answer;
import com.odinue.dynamiccompiler.service.SolutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/solution")
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    public ResponseEntity getSolution(@RequestParam long solutionNumber) {
        log.info("getSolution 진입");
        return new ResponseEntity("int a와 int b가 주어 진다. a와 b의 합을 return 하시오.", HttpStatus.OK);
    }

    @PostMapping("/test-case")
    public ResponseEntity postSolutionForTestCase(@RequestBody String code,
                                        @RequestBody long solutionNumber,
                                        @RequestBody String language) {
        log.info("/test-case 진입!");
        Answer answer = solutionService.answer(solutionNumber, language, code);
        return new ResponseEntity(answer, HttpStatus.OK);
    }
}
