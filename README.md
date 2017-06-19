# BDF2框架搭建项目



## 技术选型

1、前端

* Dorado7/html/jsp

2、后端

* 核心框架：Spring Framework 4.2.0.RELEASE
* 持久层框架：Hibernate 4.3.6.Final
* 工具类：Apache Commons、Jackson 2.5.3

3、数据库

* MySQL


## 如何启动

1、修改 src/main/resources/configure.properties

```
jdbc.username = username
jdbc.password = password
jdbc.url = jdbc:mysql://localhost:3306/dbname?useUnicode=true&characterEncoding=UTF-8
jdbc.driver = com.mysql.jdbc.Driver
```

2、启动服务
