package com.zy.alibaba.gateway.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    protected  final String API_URI = "/v2/api-docs";

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private  String gateWayPort;



    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    public DocumentationConfig(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
    }


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> serviceIds = client.getServices();
        for (String serviceId : serviceIds) {
            List<ServiceInstance> list = client.getInstances(serviceId);
            if (null != list && list.size() > 0) {
                StringBuilder sb = new StringBuilder("http://localhost:");
                sb.append(gateWayPort).append("/").append(serviceId).append(API_URI);

                SwaggerResource resource = swaggerResource(serviceId,  sb.toString());
                resources.add(resource);
            }
        }

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
