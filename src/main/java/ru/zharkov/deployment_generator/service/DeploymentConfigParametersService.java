package ru.zharkov.deployment_generator.service;

import lombok.extern.java.Log;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.DeploymentConfigParameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Log
public class DeploymentConfigParametersService extends FileCreationService{

    public String buildTextOfFile(DeploymentConfigParameters deploymentConfigParameters){
        return deploymentConfigParameters.getContainerName() + " penis";
    }
}
