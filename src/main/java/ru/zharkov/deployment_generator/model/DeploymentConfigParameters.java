package ru.zharkov.deployment_generator.model;

import lombok.Data;

@Data
public class DeploymentConfigParameters {

    String serviceName;

    String replicaCount; //только цифры

    String containerName;

    String imageName;

    String portNumber; //только цифры

    String envName;

    String envValue;

    String strategyType;

    String maxUnavailable; //только цифры

    String maxSurge; //только цифры

    String limitCPU; //только цифры

    String limitMemory; //только цифры

    String requestCPU; //только цифры

    String requestMemory; //только цифры

}
