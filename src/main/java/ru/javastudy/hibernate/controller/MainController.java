package ru.javastudy.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.hibernate.dao.ContactEntity;
import ru.javastudy.hibernate.main.AppMain;
import ru.javastudy.hibernate.model.User;

import java.util.List;

@Controller
public class MainController {

    // первичная страница
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        List<ContactEntity> employees = AppMain.selectEx();
//        return new ResponseEntity<List<ContactEntity>>(employees, HttpStatus.OK);
        //AppMain.queryFindAllUsersJPA();
        // List<ContactEntity> ContactEntity = AppMain.queryFindAllUsersJPA();
        return modelAndView;
    }

    @RequestMapping(params = "submit", value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getPassword().toString().equals("")) {
            modelAndView.addObject("userJSP", user);
            modelAndView.setViewName("errorpage");
        } else if (user.getName().toString().equals("")) {
            modelAndView.addObject("userJSP", user);
            modelAndView.setViewName("errorpage");
        } else {
            modelAndView.setViewName("secondpage");
            modelAndView.addObject("userJSP", user);
        }
        return modelAndView;
    }
}
