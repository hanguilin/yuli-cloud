# yuli-cloud

>基于SpringCloudAlibaba构建的敏捷开发项目

## 核心依赖


| dependencies         | version       |
| -------------------- | ------------- |
| Spring Boot          | 2.3.6.RELEASE |
| Spring Cloud         | Hoxton.SR9    |
| Spring Cloud Alibaba | 2.2.3.RELEASE |
| Spring Cloud OAuth2  | 2.2.4.RELEASE |
| Spring Cloud Gateway | 2.2.6.RELEASE |
| Mybatis Plus         | 3.3.2         |
| hutool All           | 5.3.10        |



## 模块说明

~~~
yuli-cloud 快速开发平台

└── yuli-admin -- 系统基础运行模块
    ├── yuli-auth -- oauth2 认证中心
    ├── yuli-gateway -- spring cloud gateway 网关服务
    ├── yuli-nacos -- spring cloud alibaba nacos 服务注册与配置中心
    └── yuli-system
        ├──yuli-system-api -- 系统基础配置接口
        └── yuli-system-ref -- 系统基础配置实体及feign调用，ref即为refrence，表示可被引用的项目
└── yuli-tools
    ├── yuli-sentinel-dashboard -- spring cloud alibaba sentinel 熔断限流控制面板
    ├── yuli-code-generator -- 代码生成器
    └── yuli-quartz -- quartz定时任务
└── yuli-common
    ├── yuli-common-core -- 核心工具库
    ├── yuli-common-datasource -- mybatis-plus多数据源
    ├── yuli-common-mybatis -- mybatis配置
    ├── yuli-common-security -- security工具
    ├── yuli-common-seata -- seata分布式事务配置
    ├── yuli-common-swagger -- swagger文档
    └── yuli-common-sentinel -- sentinel熔断限流配置
└── yuli-business -- 业务开发聚合项目
~~~

## 界面展示

### 登录

![登录页](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219090735702.png)

### 主界面

![主界面](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219090938770.png)

### 基础功能

#### 菜单管理

![菜单列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091106232.png)

#### 用户管理

![用户列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091139032.png)

#### 角色管理

![角色列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091222237.png)

#### 机构管理

![机构列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091255079.png)

#### 定时任务

![任务列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091925987.png)

#### 字典管理

![字典列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219091849136.png)

#### 动态数据源

![数据源列表](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092011316.png)

#### 代码生成配置

![根据表配置相关信息后生成代码](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092048941.png)

#### Swagger开发文档

![swagger](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092155170.png)

#### Knife4j文档

![knife4j](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092242996.png)

#### 服务监控

![监控界面](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092425414.png)

#### Zipkin链路追踪

![zipkin](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092513459.png)

#### Nacos配置注册中心

![nacos](https://cdn.jsdelivr.net/gh/hanguilin/images@main/img/image-20210219092601438.png)