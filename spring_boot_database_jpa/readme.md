增加mysql数据库连接支持（JPA）
---

要点

1、在pom.xml中增加依赖项

```
		<!--引入以下两个节点，支持jpa操作数据库 -->
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```
		
2、编写数据库datasource连接及jpa支持

在"/spring_boot_database/src/main/resources/application.properties"文件中加入如下连接信息：

```
//Mysql数据库配置
spring.datasource.url=jdbc:mysql://44.19.28.108:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
//jpa支持
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql= true
```

    
3、编写实体类，注意import的类

```
import java.io.Serializable;
import javax.persistence.*;
```


4、编写接口，继承自“JpaRepository<实体类,主键数据类型>”

```
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;

public interface UserRepository extends JpaRepository<User, Long>  {
	User findByUserName(String userName);
}
```

