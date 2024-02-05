# microservices

************************************************************************************************************************
# springcloud

# springcloud-eureka
注册中心<br>

# springcloud-provider
服务提供者<br>

# springcloud-consumer
服务消费者<br>
两种调用服务的方法（RestTemplate/OpenFeign）<br>
127.0.0.1:82/openfeign<br>
Feign原理<br>

******************************************************************************************
# nacos

# nacos-provider
注册中心+配置管理（需要手动创建Nacos命名空间）<br>

# nacos-consumer
服务消费者<br>
启动provider/consumer<br>
127.0.0.1:82/test<br>

# nacos-gateway
网关<br>
启动gateway/provider/consumer<br>
127.0.0.1/nacos-consumer/test<br>

# nacos-sentinel
熔断器<br>
启动provider/sentinel<br>
访问127.0.0.1/test后查看sentinel dashboard设置熔断<br>
