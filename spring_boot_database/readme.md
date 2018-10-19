#增加mysql数据库连接支持

要点

1、在pom.xml中增加依赖项

```
<dependency>
    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```
		
2、编写数据库datasource连接

（1）在"/spring_boot_database/src/main/resources/application.properties"文件中加入如下连接信息：

```
spring.datasource.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

（2）或新建"/spring_boot_database/src/main/resources/application.yml"文件，并加入如下连接信息：

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123456
```
    
3、一些注意点：

（1）注意springboot的注入顺序，application类需要在顶层，或者指定注入的扫描根包：

@ComponentScan("com.example")

（2）在对象中加入@Autowired关键字，表示使用注入。

