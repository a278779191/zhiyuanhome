package life.zhiyuanhome.oranger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yzy
 * @create 2019-07-21 20:44
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
