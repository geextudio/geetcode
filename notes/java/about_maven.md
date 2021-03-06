# [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) 学习笔记

## 基础常识

[Maven](https://www.liaoxuefeng.com/wiki/1252599548343744/1255945359327200) 本身就是基于Java写的，所以在安装配置Maven之前，有必要将Java的运行环境安装配置好。

Maven 工具用于管理 Java 代码库的整个构建周期：

1. 获取依赖
2. 编译代码
3. 运行测试
4. 创建构建工件
5. 部署文件等

Maven 提供两个主要功能：

* 依赖管理工具
    > Maven 可以统一管理所有的依赖 jar 包，甚至是不同的版本。程序员也可以动态地将自己写好的模块打包成 jar 包让 Maven 管理。需要的时候，可以直接通过简单的描述文件告诉 Maven，它会自动帮助程序员找出来，集成到项目中。
* 构建工具

Maven 是声明式的，允许用户定义构建目标，而不是方法。

Maven 通过脚本实现的最常规的任务。这些任务称作 phase，运行 mvn PHASE（其中 PHASE 指任务名称）命令即可执行它们。

* 编译（compile）：编译源代码
* 测试（test）：在项目中使用适当的单元测试框架（例如 JUnit）运行单元测试
* 打包（package）：创建代码发布包，比如 .jar / .war 文件
* 验证（verify）：在项目中运行集成测试
* 安装（install）：创建本地可用的发布包，这些包可用于其他 Maven 项目
* 部署（deploy）：创建供他人使用的发布包，这些包可用于其他 Maven 项目

以上任务不一定是串行，也可以是叠加的，比如“打包”会引发“编译”和“测试”. mvn clean install命令强制清理并从头构建项目.

Maven 构建文件称为“项目对象模型文件”（ [Project Object Model, POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) ），它以pom.xml的形式存储在项目的根目录下。

Maven 有丰富的插件，包括Web框架、文档生成器、Android、Docker等.

## 快速上手

* 初始化项目

    在国内使用可能需要设置镜像，比如[阿里云](https://developer.aliyun.com/mirror/maven?spm=a2c6h.13651102.0.0.3e221b11O6YC4J)

    参考 [settings.xml](https://www.cnblogs.com/jingmoxukong/p/6050172.html) 镜像设置

    ```xml
    <mirrors>

        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云公共仓库</name>
            <url>https://maven.aliyun.com/repository/public</url>
        </mirror>

    </mirrors>


    <profiles>

        <!-- 如果一个settings.xml中的profile被激活，它的值会覆盖任何其它定义在pom.xml中带有相同id的profile -->
        <profile>
            <id>aliyun-spring</id>

            <repositories>
                <repository>
                    <id>spring</id>
                    <url>https://maven.aliyun.com/repository/spring</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>

        </profile>

    </profiles>
    ```

    Maven 通过目标 **archetype:generate** 来初始化创建一个项目, 后面以形如 -**D**parameterName=parameterValue 的格式挂载各类参数.
    作为前缀的 archetype 是设定目标的插件. 比如，以下命令结合 maven-archetype-quickstart 这个 archetypeArtifactId 来创建了一个[最基本的工程](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).

    ```bash
    mvn archetype:generate -DgroupId=[com.mycompany.app] -DartifactId=[my-app] -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
    ```

    由于墙的原因，如果一直停留在 Generating project in Interactive mode 状态，可以尝试以下方法：

    * 需要重新开始并在命令后面跟一个参数 **-DarchetypeCatalog=internal**, 让 Maven 不要从远程服务器上取 catalog

    ```bash
    mvn archetype:generate  -DgroupId=[your-project-groupId] -DartifactId=[your-project-name] -DarchetypeCatalog=internal
    ```

    * 修改 setting.xml 文件，把 mirror 改成阿里的镜像。

        1. 打开 maven 目录下的 conf/setting.xml
        2. 搜索 <mirrors>；找到 <mirrors>。在 <mirrors> 节点下添加。

            ```xml
            <mirror>
                <id>aliyunmaven</id>
                <mirrorOf>*</mirrorOf>
                <name>阿里云公共仓库</name>
                <url>https://maven.aliyun.com/repository/public</url>
            </mirror>
            ```

        3. 运行 mvn archetype:generate 命令的时候加上 **-DarchetypeCatalog=local** 这个参数。

            ```bash
            mvn archetype:generate  -DgroupId=[your-project-groupId] -DartifactId=[your-project-name] -DarchetypeCatalog=local
            ```

    如下命令可以创建一个基于 [Cucumber](https://cucumber.io/docs/guides/overview/) 的 [BDD](https://school.cucumber.io/) 项目：

    ```bash
    mvn archetype:generate                      \
        "-DarchetypeGroupId=io.cucumber"           \
        "-DarchetypeArtifactId=cucumber-archetype" \
        "-DarchetypeVersion=5.6.0"               \
        "-DgroupId=[com.mycompany.app]"                  \
        "-DartifactId=[my-app]"               \
        "-DarchetypeCatalog=local"               \
        "-DinteractiveMode=false"
    ```

* 编译项目

    进入项目根目录

    ```bash
    mvn package
    ```

    与通过目标插件 archetype 初始化项目不同，编译项目使用的是一个名为 package 的 **phase** ( 一个 phase 是整个[构建周期](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)的一个步骤 ).

## 插件( plugin )说明

  > plugins 就是直接引入一个plugin，而且可以绑定到Maven相关的生命周期上。
  > pluginManagement 是表示插件声明，即你在项目中的pluginManagement下声明了插件，Maven不会加载该插件，pluginManagement声明可以被继承。
  >
  > pluginManagement 一般是用来在父 POM 中定义，提供给子 POM 使用，子 POM 也可以覆盖这个定义，而且在父 POM 中定义了版本之后，子模块中直接应用 groupId 和 artifactId，而不用指定版本，同时也方便统一管理；而在父 POM 中的 pluginManagement 并不会介入到 Maven 的生命周期。
