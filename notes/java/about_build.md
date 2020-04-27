# Java 项目构建

常见的构建工具包括 Ant、 Maven、 Gradle，其中 Ant 虽然仍有应用，但基本属于淘汰状态。

## Maven

Maven 本身就是基于Java写的，所以在安装配置Maven之前，有必要将Java的运行环境安装配置好。

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

Maven 通过脚本实现的最常规的任务。这些任务称作phase，运行mvn PHASE（其中PHASE指任务名称）命令即可执行它们。

* 编译（compile）：编译源代码
* 测试（test）：在项目中运行单元测试
* 打包（package）：创建代码发布包，比如 .jar 文件
* 验证（verify）：在项目中运行集成测试
* 安装（install）：创建本地可用的发布包，这些包可用于其他 Maven 项目
* 部署（deploy）：创建供他人使用的发布包，这些包可用于其他 Maven 项目

以上任务不一定是串行，也可以是叠加的，比如“打包”会引发“编译”和“测试”. mvn clean install命令强制清理并从头构建项目.

Maven 构建文件称为“项目对象模型文件”（[Project Object Model, POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)），它以pom.xml的形式存储在项目的根目录下。

Maven 有丰富的插件，包括Web框架、文档生成器、Android、Docker等.

[MVNRepository 网站](https://mvnrepository.com/)

[代码实践](../../src/languagelab/java/mavenlab/)
