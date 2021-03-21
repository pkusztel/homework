package com.silenteight.homework.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {
    private final String VERSION_SUPPORT = "v1";
    private final String VERSION_LATEST = "v2";

    @Autowired
    GenderService svc;

    @RequestMapping("/" + VERSION_SUPPORT)
    public GenderWrapper guessGender(@RequestParam String name) {
        return new GenderWrapper(svc.decideGender(name));
    }

    @RequestMapping("/" + VERSION_LATEST)
    public GenderWrapper guessGenderTokenized(@RequestParam String name) {
        return new GenderWrapper(svc.decideGenderTokenized(name));
    }
}
