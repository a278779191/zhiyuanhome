package life.zhiyuanhome.oranger.controller;

import life.zhiyuanhome.oranger.dto.AccessTokenDTO;
import life.zhiyuanhome.oranger.dto.GithubUser;
import life.zhiyuanhome.oranger.mapper.UserMapper;
import life.zhiyuanhome.oranger.model.User;
import life.zhiyuanhome.oranger.porvider.GithubProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author yzy
 * @create 2019-07-10 21:35
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser!=null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
           user.setName(user.getName());
           user.setAccountId(String.valueOf(githubUser.getId()));
           user.setGmtCreate(System.currentTimeMillis());
           user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("user",githubUser);
            //登录成功，写cookie 和session
             return "redirect:/";
        }else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}