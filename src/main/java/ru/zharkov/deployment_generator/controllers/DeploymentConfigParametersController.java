package ru.zharkov.deployment_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.zharkov.deployment_generator.model.DeploymentConfigParameters;
import ru.zharkov.deployment_generator.service.DeploymentConfigParametersService;

import java.util.Map;

@Controller
public class DeploymentConfigParametersController {

    @Autowired
    private DeploymentConfigParametersService deploymentService;

    @GetMapping("/deployment")
    public String createDeploymentConfiguration(Map<String, Object> model){
        model.put("deploymentConfig", new DeploymentConfigParameters());
        return "deployment";
    }

    @PostMapping(value = "/createDeployment")
    public ResponseEntity<FileSystemResource> saveMaintenance(@ModelAttribute("deploymentConfig") DeploymentConfigParameters configParameters) {
        return deploymentService.createDeploymentFile(deploymentService.buildTextOfFile(configParameters));
    }
}
