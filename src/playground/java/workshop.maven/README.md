# Maven 实践

Maven 通过对象模型（Project Object Model）文件 pom.xml 的配置描述进行项目管理。

它是一组标准集合，一个项目的生命周期、一个依赖管理系统，还包括定义在项目生命周期阶段的插件 ( plugin ) 以及目标 ( goal ) 。

Maven 两大核心：

* **依赖管理**：对 jar 的统一管理 ( Maven 提供了一个 Maven 的[中央仓库](https://mvnrepository.com/)，当在项目中添加完依赖之后，Maven 会自动去中央仓库下载相关的依赖，并且解决依赖的依赖问题)
* **项目构建**：对项目进行编译、测试、打包、部署、上传到私服等
 
Maven 常用命令
| 常用命令 |	中文含义 |	说明 |
|--- |--- |--- | 
| mvn clean | 清理 | 这个命令可以用来清理已经编译好的文件 | 
| mvn compile | 编译 | 将 Java 代码编译成 Class 文件 |
| mvn test | 测试 | 项目测试 |
| mvn package | 打包 | 根据用户的配置，将项目打成 jar 包或者 war 包 |
| mvn install | 安装 | 手动向本地仓库安装一个 jar |
| mvn deploy | 上传 | 将 jar 上传到私服 |
| mvn [archetype](https://maven.apache.org/archetype/index.html):generate | 创建 | |

实践列表
| 名称 | 内容 | 说明 | 
| --- | --- | --- |
| [workshop 001](/workshop001/README.md) | 徒手创建一个 maven 项目 | |
| [workshop 002](/workshop002/README.md) | 用 VScode 插件创建一个 maven 项目 | |
| [workshop 003](/workshop003/README.md) | 用 mvn archetype:generate 创建一个 maven 项目 | |


参考笔记
1. [Maven学习总结](https://www.cnblogs.com/xdp-gacl/tag/Maven%E5%AD%A6%E4%B9%A0%E6%80%BB%E7%BB%93/)