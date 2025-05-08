package com.stavaray.challenge_tenpo.controller;

import com.stavaray.challenge_tenpo.util.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.PERCENTAGE_ROUTE)
public class MockPercentageController {

    @GetMapping
    public double percentage() {
        return 42.0;
    }
}
