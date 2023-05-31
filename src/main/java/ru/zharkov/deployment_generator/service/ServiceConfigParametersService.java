package ru.zharkov.deployment_generator.service;

import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.DeploymentConfigParameters;

@Service
public class ServiceConfigParametersService extends FileCreationService{

    public String buildTextOfFile(DeploymentConfigParameters deploymentConfigParameters){
        return deploymentConfigParameters.getContainerName() + " penis";
    }
}
