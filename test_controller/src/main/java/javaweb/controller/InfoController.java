/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.controller;

import com.google.common.base.Preconditions;
import javaweb.model.AuthModel;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jintao.wang Date: 17-9-15 Time: 下午2:31
 */
@Controller
public class InfoController {

    @RequestMapping(value = { "/a.htm" })
    public ModelAndView getModelAndView(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Integer a) {
        ModelAndView mv = new ModelAndView("a");
        System.out.println("mv=" + mv + ";a=" + a);

        return mv;
    }

    @RequestMapping(value = { "/b.htm" })
    public ModelAndView getModelAndViewByAuthModel(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, @RequestBody(required = false) AuthModel authModel) {
        ModelAndView mv = new ModelAndView("b");
        mv.addObject("bv",authModel);
        System.out.println("mv=" + mv + ";authModel=" + authModel);

        LoginUserModel loginUserModel = new LoginUserModel(1,"hz.l","ubuntu",new DateTime().getMillis(),1,1);
        addCookieUponLogin(httpServletRequest,loginUserModel);

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
        if (domainList != null && domainList.size() >= 1) {
            Integer id = loginUserModel.getId();
            String userName = loginUserModel.getUserName();
            String password = loginUserModel.getPassword();
            Long loginTime = loginUserModel.getLoginTime();

            for (String domain : domainList) {
                Cookie cookie = new Cookie(ID, id.toString());
                cookie.setDomain(domain);
                httpServletResponse.addCookie(cookie);

                String md5 = MD5String.getMD5String(userName, password, loginTime);
                cookie = new Cookie(USER_INFO, md5);
                cookie.setDomain(domain);
                httpServletResponse.addCookie(cookie);

                nCookie += 2;
            }
        }
        return nCookie;
    }
}
