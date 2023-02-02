package mvc.controller.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String greeting(@RequestParam(name = "person") String person,
                           @RequestParam(name = "country", required = false, defaultValue = "VietNam") String country,
                           Model model) {
//        model.addAttribute("personName", person);
//        model.addAttribute("country", country);
        return "Hello " + person + " from " + country;

//        return "helloWorld/greeting";
    }
    @RequestMapping("/hello2")
    public Object greeting2(@RequestParam(name="name") String name,
                            @RequestParam(name = "country") String country) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("country", country);
        return result;
    }
    @RequestMapping("/hello3/{name}/{country}")
    public Object greeting3(@PathVariable(value="name") String name,
                            @PathVariable(value="country") String country) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("country", country);
        return result;
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
