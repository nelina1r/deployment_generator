package ru.zharkov.deployment_generator.model;

import lombok.Data;

@Data
public class ServiceConfigParameters {

    String serviceName;

    String containerName;

    String protocolType;

    String portNumber;

    String targetPort;

    String serviceType;
}
