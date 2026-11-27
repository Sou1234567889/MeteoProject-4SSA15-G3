package tn.esprit.gateway.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(
        name = "METEOSERVICE",
        configuration = RandomLoadBalancerConfig.class
)
public class LoadBalancerConfig {
}