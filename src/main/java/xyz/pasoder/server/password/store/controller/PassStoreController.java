package xyz.pasoder.server.password.store.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PassStoreController {

    @GetMapping("hello")
    public String hello() {
        return "world";
    }

}
