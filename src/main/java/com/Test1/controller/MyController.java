package com.Test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MaoIno
 * @COntroller是用来创建控制器对象的
 * 位置：在类的上面
 * 和spring中的@Service @Component 方法差不多
 * */
@Controller
public class MyController {
    /**
     * 处理用户提交的请求，springmvc中是使用方法来处理的
     * 方法自定义的，可以有多种返回值，多种参数，方法名称自定义
     *
     * 准备使用soSome方法处理some.do请求：
     * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起
     *                  一个请求地址指定一个方法处理
     *          属性：1、value： 是一个string，表示请求的url地址的（some.do)
     *                          value的值必须是唯一的，不能重复的，在使用时要以”/“
     *         位置：在方法的上面常用的
     *              在类的上面
     * 说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法
     * 使用@Request Mapping修饰的方法可以处理请求的，类似于Servlet的doget 和dopost
     *
     * 返回值：ModelAndView：表示本次请求的处理结果
     *  Model：数据，请求处理完成后要显示本次请求的处理结果
     *  View：视图，例如jsp等等
     * */
    @RequestMapping(value="/some.do")
    public ModelAndView doSome(){ //类似于doget
        //处理 some.do请求了，相当于servlet调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放到request作用域中
        mv.addObject("msg","欢迎！");
        mv.addObject("fun","执行函数");
        //指定视图，指定视图的完整路径
        //框架对视图执行的forword操作
        mv.setViewName("/show.jsp");
        return mv;
    }
}
