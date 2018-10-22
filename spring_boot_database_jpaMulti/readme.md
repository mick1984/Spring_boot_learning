增加mysql数据库连接支持（JPA多数据源）
---

要点

与JDBCTemplate的多数据源支持类似，懒得写了，具体参考这三篇BLOG

https://blog.csdn.net/tianyaleixiaowu/article/details/78905149

https://blog.csdn.net/itguangit/article/details/78747969

https://blog.csdn.net/long290046464/article/details/77512863

与单数据源相比，更新了如下文件

```
/spring_boot_database_jpaMulti/src/main/java/com/example/dao/UserRepository/UserRepository.java

/spring_boot_database_jpaMulti/src/main/java/com/example/dao/UserRepository2/UserRepository2.java

/spring_boot_database_jpaMulti/src/main/java/com/example/datasource/DataSourceConfig.java

/spring_boot_database_jpaMulti/src/main/java/com/example/datasource/PrimaryJpaConfig.java

/spring_boot_database_jpaMulti/src/main/java/com/example/datasource/SecondJpaConfig.java
```

