package ru.zharkov.deployment_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.zharkov.deployment_generator.model.ServiceConfigParameters;
import ru.zharkov.deployment_generator.service.ServiceConfigParametersService;

import java.util.Map;

@Controller
public class ServiceConfigParametersController {

    @Autowired
    private ServiceConfigParametersService serviceParametersService;

    @GetMapping("/service")
    public String createServiceConfiguration(Map<String, Object> model){
        model.put("serviceConfig", new ServiceConfigParameters());
        return "service";
    }

    @PostMapping("/createService")
    public ResponseEntity<FileSystemResource> createServiceFile(@ModelAttribute("serviceConfig") ServiceConfigParameters configParameters){
        return serviceParametersService.createDeploymentFile(serviceParametersService.buildTextOfFile(configParameters), "service");
    }
}
