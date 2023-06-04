package ru.zharkov.deployment_generator.service;

import org.springframework.stereotype.Service;
import ru.zharkov.deployment_generator.model.ServiceConfigParameters;

import java.util.Map;

@Service
public class ServiceConfigParametersService extends FileCreationService{

    public boolean checkValidData(ServiceConfigParameters parameters) throws Exception{
        if(parameters.getServiceName().isBlank()){
            throw new Exception("поле serviceName пустое");
        }
        if(parameters.getContainerName().isBlank()){
            throw new Exception("поле containerName пустое");
        }
        if(parameters.getProtocolType().isBlank()){
            throw new Exception("поле protocolType пустое");
        }
        if(parameters.getPortNumber().isBlank() || !isDigits(parameters.getPortNumber())){
            throw new Exception("поле portNumber записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getTargetPort().isBlank() || !isDigits(parameters.getTargetPort())){
            throw new Exception("поле targetPort записано неверно (должны присутствовать только цифры)");
        }
        if(parameters.getServiceType().isBlank()){
            throw new Exception("поле serviceType пустое");
        }
        return true;
    }

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
        if(!parameters.getPortNumber().isBlank())
            resultString.append("      port: ").append(parameters.getPortNumber()).append("\n");
        resultString.append("      targetPort: ").append(parameters.getTargetPort()).append("\n");
        resultString.append("  type: ").append(parameters.getServiceType()).append("\n");
        return resultString.toString();
    }

    public boolean isDigits(String input) {
        return input.matches("\\d+");
    }
}
