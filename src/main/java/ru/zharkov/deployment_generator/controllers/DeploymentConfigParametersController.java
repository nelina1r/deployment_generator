package ru.zharkov.deployment_generator.controllers;

import lombok.extern.java.Log;
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
@Log
public class DeploymentConfigParametersController {

    @Autowired
    private DeploymentConfigParametersService deploymentService;

    @GetMapping("/deployment")
    public String createDeploymentConfiguration(Map<String, Object> model) {
        model.put("deploymentConfig", new DeploymentConfigParameters());
        return "deployment";
    }

    @PostMapping(value = "/createDeployment")
    public ResponseEntity<?> createDeploymentFile(@ModelAttribute("deploymentConfig") DeploymentConfigParameters configParameters) {
        try {
            boolean check = deploymentService.checkValidData(configParameters);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        String textOfFile = deploymentService.buildTextOfFile(configParameters);
        return deploymentService.createDeploymentFile(textOfFile, "deployment");
    }
}
