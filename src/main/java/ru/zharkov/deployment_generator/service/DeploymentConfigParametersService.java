package ru.zharkov.deployment_generator.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.DeploymentConfigParameters;

@Service
@Log
public class DeploymentConfigParametersService extends FileCreationService{

    public String buildTextOfFile(DeploymentConfigParameters parameters){
        StringBuilder resultString = new StringBuilder();
        resultString.append("apiVersion: apps/v1").append("\n");
        resultString.append("kind: Deployment").append("\n");
        resultString.append("metadata:").append("\n");
        resultString.append("  name: ").append(parameters.getServiceName()).append("\n");
        resultString.append("spec:").append("\n");
        resultString.append("  selector:").append("\n");
        resultString.append("    matchLabels:").append("\n");
        resultString.append("      app: ").append(parameters.getServiceName()).append("\n");
        resultString.append("  replicas: ").append(parameters.getReplicaCount()).append("\n");
        resultString.append("  template:").append("\n");
        resultString.append("    metadata:").append("\n");
        resultString.append("      labels:").append("\n");
        resultString.append("        app: ").append(parameters.getServiceName()).append("\n");
        resultString.append("    spec:").append("\n");
        resultString.append("      containers:").append("\n");
        resultString.append("      - name: ").append(parameters.getContainerName()).append("\n");
        resultString.append("        image: ").append(parameters.getImageName()).append("\n");
        resultString.append("      containers:").append("\n");
        resultString.append("        ports:").append("\n");
        resultString.append("          - containerPort: ").append(parameters.getPortNumber()).append("\n");
        // or
        resultString.append("        env:").append("\n");
        resultString.append("          - name: ").append(parameters.getEnvName()).append("\n");
        resultString.append("            value: ").append(parameters.getEnvValue()).append("\n");
        resultString.append("    strategy:").append("\n");
        // if == "recreate" to ubrat'
        resultString.append("    type: ").append(parameters.getStrategyType()).append("\n");
        resultString.append("    rollingUpdate: ").append("\n");
        // or
        resultString.append("      maxUnavailable: ").append(parameters.getMaxUnavailable()).append("\n");
        // or
        resultString.append("      maxSurge: ").append(parameters.getMaxSurge()).append("\n");
        resultString.append("\n");
        // or
        resultString.append("    resources:").append("\n");
        resultString.append("      limits:").append("\n");
        resultString.append("        cpu: ").append('"').append(parameters.getLimitCPU()).append('"').append("\n");
        resultString.append("        memory: ").append('"').append(parameters.getLimitMemory()).append('"').append("\n");
        resultString.append("      requests:").append("\n");
        resultString.append("        cpu: ").append('"').append(parameters.getRequestCPU()).append('"').append("\n");
        resultString.append("        memory: ").append('"').append(parameters.getRequestMemory()).append('"').append("\n");
        return resultString.toString();
    }
}
