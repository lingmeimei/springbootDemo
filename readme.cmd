
springbootDemo 聚合项目实践介绍:
--多数据源连接
----多数据源连接方法：
----在 modules中的 cms-admin 模块的 application.properties 文件中详解

--springbootDemo 总项目工程
--创建过程：
......
删除无关文件夹以及文件
---pom.xml:
----注意事项:
----1. 此处 <packaging>pom</packaging> (表示此根项目仅此为父级模块)
----2. 在此pom.xml 中需要手动添加如下模块代码:
        <modules>
            <!--此根项目工程中有多少个模块，此处就配置多少个-->
      		<module>eureka-server</module>
      		<module>modules</module>
      	</modules>
----3. 此处可以只需引用公共依赖(任何模块都需要的依赖)



--modules 总项目程序的主入口模块
--创建过程：
....
删除无关文件夹以及文件
----pom.xml:
----注意事项：
----同上注意事项1，2点

------问：如何在主入口模块中再次添加分模块？例如此工程中如何实现在modules中添加cms-admin以及client-demo
------右键选中父级(modules)-->new-->module-->next-->
        goupId: 填写 父级(modules)所表示的goupId；
        artifactId: 填写自己模块名;
       -->选择-->next-->
       Content root:填写 此父级(modules)所在的文件夹目录路径(包含此父级modules)：
            "D:\ideaWorkSpace\test\springbootDemo\modules" ;
       Module file location: 同Content root


--common 公共模块




