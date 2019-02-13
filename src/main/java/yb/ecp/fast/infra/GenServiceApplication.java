package yb.ecp.fast.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import yb.ecp.fast.infra.infra.eureka.EurekaDeregister;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GenServiceApplication {
    @Bean(initMethod = "showDeregisterInfo", destroyMethod = "deregister")
    public EurekaDeregister eurekaDeregister(EurekaRegistration registration, EurekaServiceRegistry registry, EurekaClientConfigBean eurekaClientConfigBean) {
        return new EurekaDeregister(registration, registry, eurekaClientConfigBean);
    }

    public static void main(String[] a) {
        SpringApplication.run(GenServiceApplication.class, a);
    }
}
