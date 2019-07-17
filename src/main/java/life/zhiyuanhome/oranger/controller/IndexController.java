package life.zhiyuanhome.oranger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzy
 * @create 2019-07-10 21:35
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() { return "index"; }
}
