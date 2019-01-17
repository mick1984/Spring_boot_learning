一个最简单的网站原型示例
---

要点

1、数据库访问使用JPA

	
2、前端展示使用thymeleaf

```
spring.thymeleaf.cache=false
```

application.properties中配置，测试时禁用thymeleaf的缓存，已便于测试，生产环境可以改为启用。


```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
pom.xml中引入thymeleaf包


