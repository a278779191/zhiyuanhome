package life.zhiyuanhome.oranger.controller;

import life.zhiyuanhome.oranger.mapper.UserMapper;
import life.zhiyuanhome.oranger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yzy
 * @create 2019-07-10 21:35
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.finByToken(token);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index"; }
}
