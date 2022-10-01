package manager.mywebappspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class NotFoundController {

    @RequestMapping("/error")
    public String errPage() {
        return "error";
    }
}
