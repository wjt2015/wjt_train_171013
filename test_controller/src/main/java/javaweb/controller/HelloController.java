/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jintao.wang  Date: 17-9-15 Time: 下午2:03
 */
@Controller
/*@RequestMapping(value = {"/myServlet"})*/
public class HelloController {
    @RequestMapping(value = {"/getMsg.htm"})
    public ModelAndView helloPage(){
        ModelAndView mv = new ModelAndView("index");
        System.out.println("mv=" + mv);
        return mv;
    }
}
 /*
 * /myServlet/getMsg.htm
 * */

