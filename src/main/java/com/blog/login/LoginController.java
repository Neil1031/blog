package com.blog.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController extends HttpServlet {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @RequestMapping("/")
    public void doPost(HttpServletRequest request, HttpServletResponse res) {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        System.out.println("aaa");
        Map<String, Object> args = new HashMap<>();
        args.put("SUBJECT", subject);
        args.put("CONTENT", content);
        jdbc.update("INSERT INTO ARTICLE (SUBJECT, CONTENT) VALUES (:SUBJECT, :CONTENT)", args);
    }

    @RequestMapping("/insertArticle")
    public void insertArticle() {
        jdbc.update("insert into BL_TB_ARTICLE (SEQNO, subject, content, crt_dt, crt_user) values (BL_SQ_ARTICLE_SEQNO.NEXTVAL, 'aaa', 'bbb', sysdate, 'Neil')", new HashMap<>());
    }


    @RequestMapping("/login")
    public List login() {
        return jdbc.queryForList("SELECT * FROM BL_TB_MEMBER", new HashMap<>());
    }

    @RequestMapping("/register")
    public List register() {
        return jdbc.queryForList("SELECT * FROM BL_TB_MEMBER", new HashMap<>());
    }
}
