package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "hello, welcome Amil";
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer s = new StringBuffer();
        s.append("<html>");
        s.append("<head>");
        s.append("<title>Title of the Amil Page</title>");
        s.append("</head>");
        s.append("<body>");
        s.append("<h1>This is a Amil</h1>");
        s.append("</body>");
        s.append("</html>");
        return s.toString();
    }
}
