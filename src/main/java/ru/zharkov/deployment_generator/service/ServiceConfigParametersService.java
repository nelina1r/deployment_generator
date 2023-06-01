package ru.zharkov.deployment_generator.service;

import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.ServiceConfigParameters;

@Service
public class ServiceConfigParametersService extends FileCreationService{

    public String buildTextOfFile(ServiceConfigParameters parameters){
        StringBuilder resultString = new StringBuilder();
        resultString.append("apiVersion: v1").append("\n");
        resultString.append("kind: Service").append("\n");
        resultString.append("metadata:").append("\n");
        resultString.append("  name: ").append(parameters.getServiceName()).append("\n");
        resultString.append("spec:").append("\n");
        resultString.append("  selector:").append("\n");
        resultString.append("    app: ").append(parameters.getContainerName()).append("\n");
        resultString.append("  ports:").append("\n");
        resultString.append("    - protocol: ").append(parameters.getProtocolType()).append("\n");
        resultString.append("      port: ").append(parameters.getPortNumber()).append("\n");
        resultString.append("      targetPort: ").append(parameters.getTargetPort()).append("\n");
        resultString.append("  type: ").append(parameters.getServiceType()).append("\n");
        return resultString.toString();
    }
}
