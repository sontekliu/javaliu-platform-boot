### ISSUE

#### 1. Failed to configure a DataSource: 'url' attribute is not specified and no embe.  
* 解决思路参考： https://www.jianshu.com/p/836d455663da  
根源就是 application.properties 配置文件中的 spring.profiles.active=@profileActive@ 未生效，
不仅仅要在 POM.xml 中配置 profile，还需要做如下配置：  
在 POM.xml 中配置 resources 将 filtering 设置为 true，如下：
```xml
<resource>
    <directory>src/main/resources</directory>
    <includes>
        <include>**/*</include>
    </includes>
    <filtering>true</filtering>
</resource>
```
关于 profile 和 filtering 隔离不同环境的内容可参考如下：  
https://segmentfault.com/a/1190000003908040  
https://my.oschina.net/jackieyeah/blog/716503  
http://maven.apache.org/guides/introduction/introduction-to-profiles.html  
https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html

#### 2. 插入 MySQL 数据库的 TIMESTAMP 类型的数据比当前日期晚 14 小时

根源在于 TIMESTAMP 这种数据类型会进行时区转换，所以修改 MySQL 的时区设置。具体修改如下：

```mysql
> show variables like "%time_zone%";
+------------------+--------+
| Variable_name    | Value  |
+------------------+--------+
| system_time_zone | CST    |
| time_zone        | SYSTEM |
+------------------+--------+
2 rows in set (0.00 sec)
#time_zone说明mysql使用system的时区，system_time_zone说明system使用CST时区
```

通过修改my.cnf配置文件来修改时区
```mysql
# vim /etc/my.cnf  ##在[mysqld]区域中加上
default-time_zone = '+8:00'

# /etc/init.d/mysqld restart  ##重启mysql使新时区生效
```

临时修改方案

```mysql
> set global time_zone = '+8:00';  ##修改mysql全局时区为北京时间，即我们所在的东8区
> set time_zone = '+8:00';  ##修改当前会话时区
> flush privileges;  #立即生效
```

参考资料：   
http://coolnull.com/4091.html  
https://segmentfault.com/a/1190000016426048