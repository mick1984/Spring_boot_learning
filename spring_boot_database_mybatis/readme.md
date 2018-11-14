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

需要注意的是spring.jpa.properties.hibernate.hbm2ddl.auto=update设置了jpa对数据库的处理方式


* **create**： 每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
* **create-drop** ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
* **update**：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
* **validate** ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。


    
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

