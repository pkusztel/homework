package com.silenteight.homework.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {
    private final String VERSION = "v1";

    @Autowired
    GenderService svc;

    @RequestMapping("/" + VERSION)
    public GenderWrapper guessGender(@RequestParam String name) {
        return new GenderWrapper(svc.decideGender(name));
    }
}
