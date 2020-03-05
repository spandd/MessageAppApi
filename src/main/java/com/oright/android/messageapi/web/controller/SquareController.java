package com.oright.android.messageapi.web.controller;


import com.oright.android.messageapi.web.model.User;
import com.oright.android.messageapi.web.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("square")
public class SquareController {

    @Autowired
    private SquareService squareService;

    @PostMapping("editUserHeadPortrait")
    public int editUserHeadPortrait(@RequestBody User user) {
        return squareService.editUserHeadPortrait(user);
    }
}
