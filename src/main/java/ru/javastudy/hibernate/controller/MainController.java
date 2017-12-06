package ru.javastudy.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.hibernate.main.AppMain;
import ru.javastudy.hibernate.model.ModelUser;
import ru.javastudy.hibernate.validater.PasswordValidator;

import java.util.List;

@Controller
public class MainController {

    public PasswordValidator passwordValidator;
    public static boolean t;
    public List<ModelUser> modelResults;

    // первичная страница
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new ModelUser());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(params = "submit", value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") ModelUser modelUser) {
        ModelAndView modelAndView = new ModelAndView();
        // selectEx ищет пользака в БД по входящему параметру !
        t = PasswordValidator.validate(modelUser.getPassword());
        System.out.println("tttttt = " + t);

        modelResults = AppMain.selectEx(modelUser.getId());
        // Если чо т нашлось - ГУД. ( роботаит и идем на гуд страницу.)
        if (modelResults.size() != 0) {
            modelAndView.setViewName("secondpage");
            modelAndView.addObject("userJSP", modelUser);
        }
        // если никто не нашелся то идем на эррор пейдж. и в ней выполняется тот же запрос НО выводятся все пользаки БД!
        else {
            modelResults = AppMain.selectEx(0);
            modelAndView.setViewName("errorpage");
            modelAndView.addObject("allContacts", modelResults);
        }
        return modelAndView;
    }
}
