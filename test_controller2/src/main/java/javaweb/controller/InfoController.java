/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qunar.scm.common.result.ApiResult;
import javaweb.model.CookieInfo;
import javaweb.model.LoginUserModel;
import javaweb.util.MD5String;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jintao.wang Date: 17-10-16 Time: 下午8:31
 */
@Controller
public class InfoController {

    private static final String ID = "ID";
    private static final String USER_INFO = "USER_INFO";

    @RequestMapping(value = { "loginUserModelView.h" })
    public ModelAndView getTestPage() {
        ModelAndView mv = new ModelAndView("loginUserModel");
        System.out.println("\tmv=" + mv);
        return mv;
    }

    @RequestMapping(value = { "/a.h" })
    public ModelAndView getModelAndView(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            @RequestParam("av") Integer a) {
        ModelAndView mv = new ModelAndView("a");
        mv.addObject("a", httpServletRequest);
        System.out.println("mv=" + mv + ";a=" + a);

        return mv;
    }

    @RequestMapping(value = { "/loginUserModel.h" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getModelAndViewByAuthModel(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, @RequestBody(required = false) LoginUserModel loginUserModel) {
        ModelAndView mv = new ModelAndView("b");
        mv.addObject("b", loginUserModel);
        System.out.println("mv=" + mv + ";authModel=" + loginUserModel);
        if (loginUserModel == null) {
            loginUserModel = new LoginUserModel(1232, "Bill-Gates", "windows vs others", new DateTime().getMillis(),
                    (byte) 1, (byte) 1);
        }
        mv.addObject("loginUserModel", loginUserModel);
        addCookieUponLogin(httpServletRequest, httpServletResponse, loginUserModel);

        return mv;
    }

    @RequestMapping(value = { "modelList.h" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            @RequestBody List<LoginUserModel> loginUserModelList) {
        ModelAndView mv = new ModelAndView("modelList");
        mv.addObject("modelList", loginUserModelList);
        return mv;
    }

    @RequestMapping(value = { "/id.h" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getModelAndViewByPost(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Integer id, String userName) {
        ModelAndView mv = new ModelAndView("id");
        mv.addObject("id", id);
        mv.addObject("userName", userName);
        return mv;
    }

    @RequestMapping(value = { "/c.h" })
    public ModelAndView getModelAndViewFromPost(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, @RequestBody(required = false) String password) {
        ModelAndView mv = new ModelAndView("c");
        mv.addObject("c", "c=" + httpServletRequest);
        mv.addObject("password", password);
        System.out.println("\tmv=" + mv);
        return mv;
    }

    @RequestMapping(value = { "/login.h" }, method = { RequestMethod.GET, RequestMethod.POST })


    @ResponseBody
    public ApiResult login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            String userName, String password) {

        System.out.println("\tuserName:" + userName + ";password:" + password);

        List<String> domainList = Lists.newArrayList(".qunar.com", ".qunarman.com", "localhost");
        List<String> idList = Lists.newArrayList("1", "2");
        List<String> userinfoList = Lists.newArrayList("HDWJDGH898DSD", "DSF8923JDKSD");
        CookieInfo cookieInfo = new CookieInfo(domainList, idList, userinfoList);

        return ApiResult.succ("登录成功，通知前端种cookie!!", cookieInfo);
    }

    /**
     * 成功登录后为客户端种植cookie
     *
     * @param httpServletResponse
     * @param loginUserModel
     * @return
     */
    private int addCookieUponLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            LoginUserModel loginUserModel) {
        Preconditions.checkNotNull(httpServletResponse);
        Preconditions.checkNotNull(loginUserModel);

        /* 记录种植的cookie个数 */
        /*
         * int nCookie = 0; Integer id = loginUserModel.getId(); String userName = loginUserModel.getUserName(); String
         * password = loginUserModel.getPassword(); Long loginTime = loginUserModel.getLoginTime(); String domain =
         * "localhost"; Cookie cookie = new Cookie(ID, id.toString()); cookie.setDomain(domain);
         * httpServletResponse.addCookie(cookie); String md5 = MD5String.getMD5String(userName, password, loginTime);
         * cookie = new Cookie(USER_INFO, md5); cookie.setDomain(domain); httpServletResponse.addCookie(cookie); nCookie
         * += 2;
         */
        List<String> domainList = Lists.newLinkedList();
        /*
         * domainList.add(".qunar.com"); domainList.add(".qunarman.com");
         */
        String serverName = httpServletRequest.getServerName();
        domainList.add(serverName);
        List<Cookie> cookieList = createCookiesByDomains(domainList, loginUserModel);
        for (Cookie cookie : cookieList) {
            httpServletResponse.addCookie(cookie);
        }

        return cookieList.size();
    }

    /**
     *
     * @param domainList
     * @param loginUserModel
     * @return
     */
    private static List<Cookie> createCookiesByDomains(List<String> domainList, LoginUserModel loginUserModel) {
        Preconditions.checkNotNull(domainList);
        Preconditions.checkNotNull(loginUserModel);
        List<Cookie> cookieList = Lists.newLinkedList();

        for (String domain : domainList) {
            Cookie cookie = new Cookie(ID, loginUserModel.getId().toString());
            cookie.setDomain(domain);
            cookie.setMaxAge(100);
            cookieList.add(cookie);

            String md5 = MD5String.getMD5String(loginUserModel.getUserName(), loginUserModel.getPassword(),
                    loginUserModel.getLoginTime());
            cookie = new Cookie(USER_INFO, md5);
            cookie.setDomain(domain);
            cookie.setMaxAge(100);
            cookieList.add(cookie);
        }
        return cookieList;
    }
}
