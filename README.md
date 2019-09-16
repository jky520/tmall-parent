# 多模块集成微信框架  
## 1、spring boot 多模块集成weixin-java-mp  
### 1.1项目结构  
    -- tmall-parent（聚合工程）  
    -- tmall-dao(数据持久层)  
    -- tmall-entity(实体层)  
    -- tmall-service(业务逻辑层)  
    -- tmall-util(工具类)  
    -- tmall-web(控制层)  
    -- tmall-weixin-web(微信API)  
    

## 2、多模块集成dubbo  
### 2.1、创建提供方项目tmall-user-service  
    -- pom.xm导入依赖  
    -- 在application.yml中配置dubbo（如下配置在消费端一样）  
    dubbo:  
      指定当前应该或名称，同样服务名称相同，不要与其他服务重名  
      application:  
        name: user-service    
      指定注册中心的位置（地址与协议）  
      registry:  
        address: 118.25.197.111:2181    
        protocol: zookeeper   
      指定通信规则(通信协议与端口)  
      protocol:  
        name: dubbo  
        port: 20880  
      指定监听器通信协议
      monitor:  
        protocol: registry  
    -- 在service实现类中暴露接口  
    在实现类加上两个注解  
    @Service // dubbo暴露接口
    @Service // spring中bean的创建  
### 2.2、在消费端修改  
    以前依赖注入的地方将@Resource改成  
    @Reference // 通过dubbo依赖服务调用   
    private UserService userService;  
### 2.3、实体类必须要被序列化  