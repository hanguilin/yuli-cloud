# yuli-cloud

基于SpringCloudAlibaba构建的敏捷开发项目

#### 核心依赖


| dependencies         | version       |
| -------------------- | ------------- |
| Spring Boot          | 2.3.6.RELEASE |
| Spring Cloud         | Hoxton.SR9    |
| Spring Cloud Alibaba | 2.2.3.RELEASE |
| Spring Cloud OAuth2  | 2.2.4.RELEASE |
| Spring Cloud Gateway | 2.2.6.RELEASE |
| Mybatis Plus         | 3.3.2         |
| hutool All           | 5.3.10        |



#### 模块说明

```lua
yuli-cloud

├── yuli-auth -- oauth2 认证中心
└── yuli-common 公共项目形成的maven聚合项目
     ├── yuli-common-core -- 核心工具库
     ├── yuli-common-mybatis -- mybatis配置
     ├── yuli-common-security -- security工具
     ├── yuli-common-seata -- seata分布式事务配置
     └── yuli-common-sentinel -- sentinel熔断限流配置
├── yuli-gateway -- spring cloud gateway 网关服务
└── yuli-system
     └── yuli-system-api -- 系统基础配置接口
     └── yuli-system-ref -- 系统基础配置实体及feign调用，ref即为refrence，表示可被引用的项目
```
