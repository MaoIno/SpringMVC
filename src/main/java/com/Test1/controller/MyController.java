package com.Test1.controller;

import com.Test1.vi.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaoIno
 * @COntroller是用来创建控制器对象的
 * 位置：在类的上面
 * 和spring中的@Service @Component 方法差不多
 *
 *
 * @ReuqestMapping:
 *  value：所有请求地址的公共部分
 *  位置：放在类的上面
 *  当然，不强求加，只是加了之后方便去管理，可以在看到注解就了解到这个类是管理哪一类请求的
 * */
@Controller
//@RequestMapping("/test")
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
     *               2、method：表示请求的方式，它的值requestmethod类枚举值
     *                  例如：表示set请求方式：requestMethod.GET
     *                  post方式：requestMethod.POST
     *
     *         位置：在方法的上面常用的
     *              在类的上面
     * 说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法
     * 使用@Request Mapping修饰的方法可以处理请求的，类似于Servlet的doget 和dopost
     *
     * 返回值：ModelAndView：表示本次请求的处理结果
     *  Model：数据，请求处理完成后要显示本次请求的处理结果
     *  View：视图，例如jsp等等
     *
     * @HttpServletRequest , @HttpServletResponse , @HttpSession
     * 这些都是定义在方法的参数列表中的
     * */
    /*@RequestMapping(value="/some.do",method=RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse,
                               HttpSession httpSession){ //类似于doget
        //处理 some.do请求了，相当于servlet调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放到request作用域中
        mv.addObject("msg","欢迎！some");
        mv.addObject("fun","执行函数");
        //指定视图，指定视图的完整路径
        //框架对视图执行的forword操作
        //mv.setViewName("/show.jsp");
        //如果要访问web-inf目录下的加密文件，需要指定多重目录，如果很多的文件都在不同的目录下，就需要多次填写
        //例如：mv.setViewName("/WEB-INF/show.jsp");
        //例如：mv.setViewName("/WEB-INF/MAIN/show.jsp");
        //例如：mv.setViewName("/WEB-INF/MAIN/other.jsp");
        //使用视图解析器，可以使用逻辑名称（文件名）指定视图,框架会使用视图解析器的前缀+逻辑名称+后缀 ，组成完整的路径 ， 就是字符串的链接操作l
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value="/other.do",method=RequestMethod.POST)
    public ModelAndView doOther(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                HttpSession httpSession){ //类似于doget
        //处理 some.do请求了，相当于servlet调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放到request作用域中
        mv.addObject("msg","欢迎！Other \t" + httpServletRequest.getParameter("name"));
        mv.addObject("fun","执行函数");
        //指定视图，指定视图的完整路径
        //框架对视图执行的forword操作
        //mv.setViewName("/show.jsp");
        //如果要访问web-inf目录下的加密文件，需要指定多重目录，如果很多的文件都在不同的目录下，就需要多次填写
        //例如：mv.setViewName("/WEB-INF/show.jsp");
        //例如：mv.setViewName("/WEB-INF/MAIN/show.jsp");
        //例如：mv.setViewName("/WEB-INF/MAIN/other.jsp");
        //使用视图解析器，可以使用逻辑名称（文件名）指定视图,框架会使用视图解析器的前缀+逻辑名称+后缀 ，组成完整的路径 ， 就是字符串的链接操作l
        mv.setViewName("show");
        return mv;
    }*/
    /**
     * 逐个接收请求参数：
     *  要求：处理器（控制器）方法的形参名和请求中的参数名必须一致
     *          同名的请求参数赋值给同名的形参
     *  框架接收请求参数：
     *      1、使用request对象接收请求参数
     *          String s = request.getParameter("name");
     *          String a = request.getParameter("age");
     *      2、springmvc框架通过中央调度器(DispatcherServlet 调用 MyController中的dosome（）方法
     *          调用方法时，按名称对应，把接收的参数赋值给形参
     *          并且框架会提供类型转换，将String转换为int double float long等
     *
     * 请求参数中，逐个接收请求参数中参数名和处理器名称形参不一样处理方法：
     * @RequestParam:
     *      1、属性：
     *          1、value：请求中的参数名称
     *          2、required:表示请求中必须包含此参数
     *      2、位置：
     *          在处理器方法的形参定义的前面
     * */
    /*@RequestMapping(value="/some.do")
    public ModelAndView doSome(@RequestParam("rname") String name ,@RequestParam("rage") int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }*/
    /**
     *  使用对象的方法来接收参数，在方法的形参列表中的是自定义的一个方法
     *  其中的值是利用对象中的set方法赋值，以及get来获得值
     *  处理器形参列表中的对象的属性名和请求的参数名一致
     *  框架会创建形参的Java对象，给属性赋值，请求中的参数是name，框架会调用setName方法将请求中的值赋值给对象中的属性
     * *//*
    @RequestMapping(value="/some.do")
    public ModelAndView doSome(Student mystudent){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",mystudent.getRname());
        mv.addObject("age",mystudent.getRage());
        mv.setViewName("show");
        return mv;
    }*/
    /**
     * 处理方法返回一个Student对象，通过框架转换为json，来响应ajax
     * @ResponseBody:
     *          作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出到浏览器中
     *          位置：定义在方法的上面，和其他的注解没有先后顺序关系
     * 返回对象框架的处理流程：
     *      1、框架会吧返回的student类型，调用框架的arraylist<HttpMessageConverter>中的每个类的canwrite（）方法
     *      检查接口的实现类能处理student类型的对象
     *      2、框架调用实现类write（），将返回值转换为json，调用jackson时间json
     *      3、框架嗲用ResponseBody将结果数据输出到浏览器，ajax请求处理完成
     *
     * */
   /* @ResponseBody
    @RequestMapping(value="/some.do")
    public Student doSome(Student mystudent){
        //调用servlet ， 获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setRname("李四");
        student.setRage(20);
        return student; //会被框架转换为json
    }*/
    /*使用输出做返回值*/
    /*@ResponseBody
    @RequestMapping(value="/some.do")
    public List<Student> doSome(Student mystudent){
        //调用servlet ， 获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setRname("李四");
        student.setRage(20);
        List<Student> list = new ArrayList<>();
        list.add(student);
        return list; //会被框架转换为json
    }*/
    //确认返回值是String的类型的是数据还是视图就是看是否有ResponseBody，如果有是数据，没有就是视图
    @ResponseBody
    @RequestMapping(value="/some.do")
    public String doSome(){

        return "lsi";
    }
}
