# zhabei-parent
项目只包含pom文件，parent项目主要负责针对项目jar包的版本管理。

## 项目继承
项目继承了spring boot的parent项目，继承后我们可以不需要关心spring boot各模块的版本。  
本项目使用了 `1.4.2.RELEASE` 版本
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.4.2.RELEASE</version>
</parent>
```

## 项目依赖
项目依赖于spring cloud的jar包。在dependencyManagement中引入spring cloud的依赖。
```
<!-- 引入spring cloud的依赖 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Camden.SR4</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

