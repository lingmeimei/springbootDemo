
--cms-admin
----项目程序主入口
----DataSourceConfig.java： 针对 mysql 多数据源连接的配置类,其中
        关于 JdbcTemplate 的方法是项目基于 jdbc 访问数据库
----PrimaryConfig.java 、 SecondaryConfig.java 是
        多数据源情况下利用 JPA 框架 访问数据库。前提 还是 需要 DataSourceConfig.java 类，
        此时关于 jdbcTemplate 相关方法可要可不要

----primary 包 和 secondary 包 中的 repository 是针对JPA而言。
        若是项目工程利用 mybatis, 则 此 repository 包则不需要,而应是 mapper 包

----mapper 包，是利用 mybatis orm框架所特有