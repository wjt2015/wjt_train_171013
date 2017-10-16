/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.controller;

import com.google.common.base.Preconditions;
import javaweb.model.LoginUserModel;
import javaweb.util.MD5String;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jintao.wang Date: 17-10-16 Time: 下午8:31
 */
@Controller
public class InfoController {

    private static final String ID = "ID";
    private static final String USER_INFO = "USER_INFO";

    @RequestMapping(value = { "/a.h" })
    public ModelAndView getModelAndView(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            @RequestParam("av") Integer a) {
        ModelAndView mv = new ModelAndView("a");
        mv.addObject("a",httpServletRequest);
        System.out.println("mv=" + mv + ";a=" + a);

        return mv;
    }

    @RequestMapping(value = { "/b.h" },method = { RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getModelAndViewByAuthModel(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, @RequestBody(required = false)LoginUserModel loginUserModel) {
        ModelAndView mv = new ModelAndView("b");
        mv.addObject("b", loginUserModel);
        System.out.println("mv=" + mv + ";authModel=" + loginUserModel);

        addCookieUponLogin(httpServletResponse, loginUserModel);

        return mv;
    }

    @RequestMapping(value = {"/c.h"})
    public ModelAndView getModelAndViewFromPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@RequestBody(required = false) String password){
        ModelAndView mv = new ModelAndView("c");
        mv.addObject("c","c=" + httpServletRequest);
        mv.addObject("password",password);
        System.out.println("\tmv=" + mv);
        return mv;
    }

    /**
     * 成功登录后为客户端种植cookie
     *
     * @param httpServletResponse
     * @param loginUserModel
     * @return
     */
    private int addCookieUponLogin(HttpServletResponse httpServletResponse, LoginUserModel loginUserModel) {
        Preconditions.checkNotNull(httpServletResponse);
        Preconditions.checkNotNull(loginUserModel);

        /* 记录种植的cookie个数 */
        int nCookie = 0;
        Integer id = loginUserModel.getId();
        String userName = loginUserModel.getUserName();
        String password = loginUserModel.getPassword();
        Long loginTime = loginUserModel.getLoginTime();

        String domain = "localhost";
        Cookie cookie = new Cookie(ID, id.toString());
        cookie.setDomain(domain);
        httpServletResponse.addCookie(cookie);

        String md5 = MD5String.getMD5String(userName, password, loginTime);
        cookie = new Cookie(USER_INFO, md5);
        cookie.setDomain(domain);
        httpServletResponse.addCookie(cookie);

        nCookie += 2;

        return nCookie;
    }
}
