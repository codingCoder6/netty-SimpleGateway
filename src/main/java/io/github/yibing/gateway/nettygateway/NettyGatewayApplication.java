package io.github.yibing.gateway.nettygateway;

import io.github.yibing.gateway.nettygateway.inbound.HttpInboundServer;
import io.github.yibing.gateway.nettygateway.router.RouteTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class NettyGatewayApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NettyGatewayApplication.class, args);
    }



    @Autowired
    private HttpInboundServer gatewayServer;

    @Override
    public void run(String... args) throws Exception {
        RouteTable.getInstance().initRoute();
        gatewayServer.run();
    }
}
