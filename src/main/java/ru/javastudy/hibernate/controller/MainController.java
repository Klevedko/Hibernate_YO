package ru.javastudy.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.hibernate.main.AppMain;
import ru.javastudy.hibernate.model.ModelUser;

import java.util.List;

@Controller
public class MainController {

    // первичная страница
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new ModelUser());

        modelAndView.setViewName("home");
        List<ModelUser> modelResults = AppMain.selectEx(0);
        modelAndView.addObject("contactList", modelResults);

//        return new ResponseEntity<List<UserEntity>>(employees, HttpStatus.OK);
        //AppMain.queryFindAllUsersJPA();
        // List<UserEntity> UserEntity = AppMain.queryFindAllUsersJPA();
        return modelAndView;
    }

    @RequestMapping(params = "submit", value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") ModelUser modelUser) {
        ModelAndView modelAndView = new ModelAndView();
        List<ModelUser> modelResults = AppMain.selectEx(modelUser.getId());
        if (modelResults.size()!=0){
            modelAndView.setViewName("secondpage");
            modelAndView.addObject("userJSP", modelUser);
        }
        else{
            modelResults = AppMain.selectEx(0);
            modelAndView.setViewName("errorpage");
        }
        return modelAndView;
    }
}
