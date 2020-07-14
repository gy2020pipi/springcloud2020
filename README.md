**Spring Cloud 学习记录随笔**

        具体学习目录：
            服务注册中心 ---- Eureka ,zookeeper ,Consul ,Nacos
            服务调用     ---- Ribbon
            服务调用2    ---- OpenFeign
            服务降级     ---- Hystrix ,sentienl
            服务网关     ---- gateway
            服务配置     ---- config ,Nacos
            服务总线     ---- Nacos 
            具体将按照从上至下的顺序学习。
            记录在Git也算对自己学习的一个敦促和记录作用。
                                    2020年7月14日 18点36分            
                                    
                                    
**服务注册中心**

    **1.Eureka服务注册与发现**
        理论知识：
            Q：什么是服务治理？
            A：传统RPC远程调用框架中，每个服务之间的依赖关系比较复杂，管理难度高，所以需要使用服务治理，管理服务与服务之间的依赖关系
            .
            Q:Eureka两个组件
            A:Euraka Server：各个微服务节点通过配置启动后会在Euraka Server中进行注册，这样Euraka Server就可以统一管理所有服务节点
              Euraka Client：是一个java客户端，用于简化Euraka server交互，内置了使用轮询算法的负载均衡器，在应用启动后会向Euraka server
              发送心跳（默认30s）,如果Euraka server在多个心跳周期内没有接收到某个节点的心跳，Euraka server会从注册中心删除该节点（默认90s）
        单机构建：
            建module：（cloud-eureka-server7002）
            改pom(使用新版spring-cloud-starter-netflix-eureka-server)
            写YML（注意：client:
                       register-with-eureka: false    #表识不向注册中心注册自己
                       fetch-registry: false  #表示自己就是注册中心，职责是维护服务实例，并不需要去检索服务)
            主启动（注意：添加@EnableEurekaServer注解 表明这是一个eureka server）
            测试（启动服务，访问http://localhost:7002/）
        服务提供者添加进服务注册中心：
            EurekaClient端cloud-provider-payment8001将注册进EurekaServer成为服务提供者provider
            修改POM.xml(添加spring-cloud-starter-netflix-eureka-client)
            修改yml 
            改主启动（添加@EnableEurekaClient）
        服务消费者添加进服务注册中心：
            EurekaClient端cloud-consumer-order80将注册进EurekaServer成为服务消费者consumer
            改POM（添加spring-cloud-starter-netflix-eureka-client）
            改yml
            改主启动（添加@EnableEurekaClient）
                            2020年7月14日 20点49分
    
    
    
    