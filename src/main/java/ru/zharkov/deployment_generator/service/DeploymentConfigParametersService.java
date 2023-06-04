package ru.zharkov.deployment_generator.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.DeploymentConfigParameters;
import ru.zharkov.deployment_generator.model.enums.StrategyType;

import java.util.Map;

@Service
@Log
public class DeploymentConfigParametersService extends FileCreationService {

    public boolean checkValidData(DeploymentConfigParameters parameters) throws Exception{
        if(parameters.getServiceName().isBlank()){
            throw new Exception("поле serviceName пустое");
        }
        if(parameters.getContainerName().isBlank()){
            throw new Exception("поле containerName пустое");
        }
        if(parameters.getImageName().isBlank()){
            throw new Exception("поле imageName пустое");
        }
        if(parameters.getEnvName().isBlank()){
            throw new Exception("поле envName пустое");
        }
        if(parameters.getEnvValue().isBlank()){
            throw new Exception("поле envValue пустое");
        }
        if(parameters.getStrategyType().isBlank()){
            throw new Exception("поле strategyType записано неверно");
        }
        if(parameters.getEnvValue().isBlank()){
            log.warning(parameters.getEnvValue());
            throw new Exception("поле envValue пустое");
        }
        if(parameters.getReplicaCount().isBlank() || !isDigits(parameters.getReplicaCount())){
            throw new Exception("поле replicaCount записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getPortNumber().isBlank() || !isDigits(parameters.getPortNumber())){
            throw new Exception("поле portNumber записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getMaxUnavailable().isBlank() || !isDigits(parameters.getMaxUnavailable())){
            throw new Exception("поле maxUnavailable записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getMaxSurge().isBlank() || !isDigits(parameters.getMaxSurge())){
            throw new Exception("поле maxSurge записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getLimitCPU().isBlank() || !isDigits(parameters.getLimitCPU())){
            throw new Exception("поле limitCPU записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getLimitMemory().isBlank() || !isDigits(parameters.getLimitMemory())){
            throw new Exception("поле limitMemory записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getRequestCPU().isBlank() || !isDigits(parameters.getRequestCPU())){
            throw new Exception("поле requestCPU записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getRequestMemory().isBlank() || !isDigits(parameters.getRequestMemory())){
            throw new Exception("поле requestMemory записано неверно (должны присутствовать только цифры)");
        }
        return true;
    }

    public String buildTextOfFile(DeploymentConfigParameters parameters) {
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
        if (!parameters.getEnvName().isBlank() && !parameters.getEnvValue().isBlank()) {
            resultString.append("        env:").append("\n");
            resultString.append("          - name: ").append(parameters.getEnvName()).append("\n");
            resultString.append("            value: ").append(parameters.getEnvValue()).append("\n");
        }
        resultString.append("    strategy:").append("\n");
        resultString.append("    type: ").append(parameters.getStrategyType()).append("\n");
        if (parameters.getStrategyType().equals(StrategyType.rollingUpdate.toString())) {
            resultString.append("    rollingUpdate: ").append("\n");
            if (!parameters.getMaxUnavailable().isBlank())
                resultString.append("      maxUnavailable: ").append(parameters.getMaxUnavailable()).append("\n");
            if (!parameters.getMaxSurge().isBlank())
                resultString.append("      maxSurge: ").append(parameters.getMaxSurge()).append("\n");
        }
        resultString.append("\n");
        if (!parameters.getLimitCPU().isBlank() || !parameters.getLimitMemory().isBlank() || !parameters.getRequestCPU().isBlank() || !parameters.getRequestMemory().isBlank()) {
            resultString.append("    resources:").append("\n");
            if (!parameters.getLimitCPU().isBlank() || !parameters.getLimitMemory().isBlank()) {
                resultString.append("      limits:").append("\n");
                if (!parameters.getLimitCPU().isBlank())
                    resultString.append("        cpu: ").append('"').append(parameters.getLimitCPU()).append('"').append("\n");
                if (!parameters.getLimitMemory().isBlank())
                    resultString.append("        memory: ").append('"').append(parameters.getLimitMemory()).append('"').append("\n");
            }
            if (!parameters.getRequestCPU().isBlank() || !parameters.getRequestMemory().isBlank()) {
                resultString.append("      requests:").append("\n");
                if (!parameters.getRequestCPU().isBlank())
                    resultString.append("        cpu: ").append('"').append(parameters.getRequestCPU()).append('"').append("\n");
                if (!parameters.getRequestMemory().isBlank())
                    resultString.append("        memory: ").append('"').append(parameters.getRequestMemory()).append('"').append("\n");
            }
        }
        return resultString.toString();
    }


    public boolean isDigits(String input) {
        return input.matches("\\d+");
    }
}
