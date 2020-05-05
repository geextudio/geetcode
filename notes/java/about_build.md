# Java 项目构建

常见的构建工具包括 Ant、 Maven、 Gradle，其中 Ant 虽然仍有应用，但基本属于淘汰状态。

## Maven

**在国内使用可能需要设置镜像，比如[阿里云](https://developer.aliyun.com/mirror/maven?spm=a2c6h.13651102.0.0.3e221b11O6YC4J)**

[Maven 学习笔记](./about_maven.md)

[MVNRepository 网站](https://mvnrepository.com/)

[代码实践](../../src/languagelab/java/mavenlab/)

## Trouble Shooting

* .jar中没有主清单属性
    * 方法1: 需要创建一个 MANIFEST.MF 文件来声明定程序运行时所需的所有代码.
    * 方法2: 在 Maven 构建环境的 pom.xml 中设置插件
    ```xml
     <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>

          <configuration>
            <archive>
                <manifest>
                    <addClasspath>true</addClasspath>
                    <mainClass>now.geextudio.App</mainClass> <!-- 此处为主入口-->
                </manifest>
            </archive>
          </configuration>

        </plugin>
    ```