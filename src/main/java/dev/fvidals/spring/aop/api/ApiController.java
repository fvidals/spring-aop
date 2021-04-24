package dev.fvidals.spring.aop.api;

import dev.fvidals.spring.aop.advice.Audit;
import dev.fvidals.spring.aop.advice.TimeElapsed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Audit
    @TimeElapsed
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
