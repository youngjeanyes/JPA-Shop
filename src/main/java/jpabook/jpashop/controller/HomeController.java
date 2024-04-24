package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class HomeController {

    public String home(){
        log.info("::::: home controller invoked. :::::");
        return "home";
    }

}
