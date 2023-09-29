package com.blog.login;

import com.blog.login.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @PostMapping("/insertArticle")
    public Integer insertArticle(@RequestBody Article article) {
        String subject = article.getSubject();
        String content = article.getContent();
        System.out.println("aaa");
        Map<String, Object> args = new HashMap<>();
        args.put("SUBJECT", subject);
        args.put("CONTENT", content);
        return jdbc.update("INSERT INTO ARTICLE (SUBJECT, CONTENT) VALUES (:SUBJECT, :CONTENT)", args);
    }



    @RequestMapping("/")
    public String begin(Model model) {
//        model.addAttribute("test", "test");
        return "index";
    }


    @RequestMapping("/login")
    public String login(Model model) {
model.addAttribute("test", "test");
        return "bbb";
    }

    @RequestMapping("/register")
    public List register() {
        return jdbc.queryForList("SELECT * FROM BL_TB_MEMBER", new HashMap<>());
    }
}
