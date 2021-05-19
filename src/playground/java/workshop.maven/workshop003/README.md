# 使用 mvn archetype:generate 创建一个 maven 项目

Maven 命令行创建一个项目 workshop003 举例 
```bash
mvn archetype:generate -DgroupId=io.geextudio -DartifactId=workshop003 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```
命令行执行之后，需要更改默认的 junit 到新版本，并添加类似如下设置到根节点下
```xml
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
```
