# luna-spring-cloud
isczy.tk luna-spring-cloud


# Contributor
- Luna 

# port
- luna-provider-eureka-node-I:8001 eureka client 
- luna-provider-eureka-node-II:8002 eureka client 
- luna-provider-zookeeper-node:8003 zookeeper client
- luna-provider-consul-node:8004 consul client 
- luna-provider-eureka-hystrix-node:8005 eureka client hystrix


- luna-consumer-eureka-node-I:8006 eureka client restTemplate
- luna-consumer-eureka-node-II:8007 eureka client restTemplate
- luna-consumer-eureka-openfeign-node:8009 eureka client openfeign
- luna-consumer-eureka-openfeign-hystrix-node:8011 eureka client openfeign hystrix
- luna-consumer-eureka-hystrix-dashboard-node:8012 eureka client hystrix-dashboard
- luna-consumer-zookeeper-node:8008 zookeeper client restTemplate
- luna-consumer-consul-node:8010 consul client restTemplate


- luna-eureka-server-node-I:7001 
- luna-eureka-server-node-II:7002

# 域名映射
127.0.0.1 eurekanodeI.com
127.0.0.1 eurekanodeII.com

# 代码规范
- 后端使用同一份代码格式化膜模板ali-code-style.xml，ecplise直接导入使用，idea使用Eclipse Code Formatter插件配置xml后使用。
- 前端代码使用vs插件的Beautify格式化，缩进使用TAB
- 后端代码非特殊情况准守P3C插件规范
- 注释要尽可能完整明晰，提交的代码必须要先格式化
- xml文件和前端一样，使用TAB缩进
