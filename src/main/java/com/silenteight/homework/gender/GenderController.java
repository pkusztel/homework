package com.silenteight.homework.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/males", produces = "text/plain;charset=UTF-8")
    public byte[] getMales() {
        return svc.getMales();
    }

    @RequestMapping(value = "/females", produces = "text/plain;charset=UTF-8")
    public byte[] getFemales() {
        return svc.getFemales();
    }
}
