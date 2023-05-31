package ru.zharkov.deployment_generator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.zharkov.deployment_generator.model.ServiceConfigParameter;

import java.util.Map;

@Controller
public class ServiceConfigParametersController {

    @GetMapping("/service")
    public String createServiceConfiguration(Map<String, Object> model){
        model.put("serviceConfig", new ServiceConfigParameter());
        return "service";
    }
}
