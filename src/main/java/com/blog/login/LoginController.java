package com.blog.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
public class LoginController extends HttpServlet {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @RequestMapping("/")
    public List hello(HttpServletRequest request) {
        return jdbc.queryForList("SELECT * FROM BL_TB_MEMBER", new HashMap<>());
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
