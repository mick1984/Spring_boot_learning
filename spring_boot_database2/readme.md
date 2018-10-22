增加mysql数据库连接支持（JdbcTemplate多数据源支持）
---

要点

1、增加datasource配置类

注意使用“@Configuration”，用于表示集成到spring boot的配置文件

```
@Configuration
public class DataSourceConfig {

	@Bean(name="primaryDataSource")	
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.primary")
	@Primary
	public DataSource primaryDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondDataSource")	
	@Qualifier("secondDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryJdbcTemplate")
    public NamedParameterJdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "secondJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
```
		
2、修改配置文件

（1）修改配置文件/spring_boot_database2/src/main/resources/application.yml，增加多数据源的支持

```
spring:
  datasource:
    primary:
        url: jdbc:mysql://44.19.28.108:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
        jdbc-url: jdbc:mysql://44.19.28.108:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
        driver-class-name: com.mysql.jdbc.Driver
        username: root
        password: 123456
    secondary:
        url: jdbc:mysql://44.19.28.108:3306/yjtorgfep?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
        jdbc-url: jdbc:mysql://44.19.28.108:3306/yjtorgfep?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
        driver-class-name: com.mysql.jdbc.Driver
        username: root
        password: 123456
```

（2）也可以在“/spring_boot_database2/src/main/resources/application.properties”中配置，这里不详细说明了。

    
3、JdbcTemplate注入时指定注入使用的数据源
代码片段如下：

```
    @Autowired  /*关键字@Autowired表示自动注入*/    
    @Qualifier("primaryJdbcTemplate")
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("secondJdbcTemplate")
    private NamedParameterJdbcTemplate jdbcTemplate2;
```

