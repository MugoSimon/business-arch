package com.thimionii.department_service.config;

import com.thimionii.department_service.client.EmployeeClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public EmployeeClient employeeClient(WebClient.Builder webClientBuilder) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor
                        (WebClientAdapter.create(
                                webClientBuilder.baseUrl("http://employee-service")
                                        .build()))
                .build();
        return factory.createClient(EmployeeClient.class);
    }
}
