# Java 项目构建

常见的构建工具包括 Ant、 Maven、 Gradle，其中 Ant 虽然仍有应用，但基本属于淘汰状态。

## Maven

Maven 工具用于管理 Java 代码库的整个构建周期：

1. 获取依赖
2. 编译代码
3. 运行测试
4. 创建构建工件
5. 部署文件等

Maven 提供两个主要功能：

* 依赖管理工具
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

[代码实践](../../src/languagelab/java/mavenlab/)
