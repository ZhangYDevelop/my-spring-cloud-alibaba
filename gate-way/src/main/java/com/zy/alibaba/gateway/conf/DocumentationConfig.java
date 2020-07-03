//package com.zy.alibaba.gateway.conf;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.Route;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Flux;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class DocumentationConfig implements SwaggerResourcesProvider {
////    @Autowired
////    private  RouteLocator routeLocator;
//    // 自动获取系统配置的路由资源集合
//    @Override
//    public List<SwaggerResource> get() {
//        List<SwaggerResource> resources = new ArrayList<>();
////        Flux<Route> routes = routeLocator.getRoutes();
////        for (List<Route> routeList : routes.buffer().toIterable()) {
////            routeList.forEach(route -> {
////                resources.add(swaggerResource(route.getId(),
////                        route.getUri().getPath().replace("**", "v2/api-docs"), ""));
////            });
////        }
//
//
//        return resources;
//    }
//
//    // 获取对应的路由资源
//    private SwaggerResource swaggerResource(String name, String location, String version) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion(version);
//        return swaggerResource;
//    }
//}
