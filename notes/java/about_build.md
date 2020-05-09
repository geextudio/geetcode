# Java 项目构建

常见的构建工具包括 Ant、 Maven、 Gradle，其中 Ant 虽然仍有应用，但基本属于淘汰状态。

## Maven

**在国内使用可能需要设置镜像，比如[阿里云](https://developer.aliyun.com/mirror/maven?spm=a2c6h.13651102.0.0.3e221b11O6YC4J)**

[Maven 学习笔记](./about_maven.md)

[MVNRepository 网站](https://mvnrepository.com/)

[代码实践](../../src/languagelab/java/mavenlab/)

## Trouble Shooting

* NoClassDefFoundError
  错误的发生是因为 Java 虚拟机在编译时能找到合适的类，而在运行时不能找到合适的类导致的错误。

  这个发生可能的原因如下：

  1. 对应的 Class 在 Java 的 classpath 中不可用
  2. 用 jar 命令运行程序，但类并没有在 jar 文件的 manifest 文件中的 classpath 属性中定义
  3. 可能程序的启动脚本覆盖了原来的 classpath 环境变量
  4. 因为 NoClassDefFoundError 是 java.lang.LinkageError 的一个子类，所以可能由于程序依赖的原生的类库不可用而导致
  5. 检查日志文件中是否有 java.lang.ExceptionInInitializerError 这样的错误，NoClassDefFoundError 有可能是由于静态初始化失败导致的
  6. 如果工作在 Java EE 的环境，有多个不同的类加载器，也可能导致 NoClassDefFoundError
  7. NoClassDefFoundError 也可能由于类的静态初始化模块错误导致，当类执行一些静态初始化模块操作，如果初始化模块抛出异常，哪些依赖这个类的其他类会抛出 NoClassDefFoundError 的错误。如果查看程序日志，会发现一些 java.lang.ExceptionInInitializerError 的错误日志，ExceptionInInitializerError 的错误会导致 java.lang.NoClassDefFoundError: Could not initialize class

  试试 shaded, 结合插件 maven-shade-plugin
  
  ```bash
  mvn clean package shade:shade
  ```

  如果没有使用 shade 的话，可尝试命令如下, 结合插件 maven-dependency-plugin 与 maven-jar-plugin
  
  ```bash
  mvn clean dependency:copy-dependencies package
  ```

* ClassNotFoundException
  编译的时候在 classpath 中找不到对应的类而发生的错误。
* .jar 中没有主清单属性

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
