package ru.zharkov.deployment_generator.model;

import lombok.Data;

@Data
public class DeploymentConfigParameters {

    String serviceName;

    String replicaCount;

    String containerName;

    String imageName;

    String portNumber;

    String envName;

    String envValue;

    String strategyType;

    String maxUnavailable;

    String maxSurge;

    String limitCPU;

    String limitMemory;

    String requestCPU;

    String requestMemory;

}
