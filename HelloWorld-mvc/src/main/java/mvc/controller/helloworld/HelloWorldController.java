package mvc.controller.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public String greeting(@RequestParam(name = "person") String person,
                           @RequestParam(name = "country", required = false, defaultValue = "VietNam") String country,
                           Model model) {
        model.addAttribute("personName", person);
        model.addAttribute("country", country);

        return "helloWorld/greeting";
    }

    @RequestMapping("/hello/{person}/{country}")
    public String greeting2(@PathVariable(name = "person") String person,
                            @PathVariable(name = "country") String country,
                            Model model) {
        model.addAttribute("personName", person);
        model.addAttribute("country", country);

        return "helloWorld/greeting";
    }

}
