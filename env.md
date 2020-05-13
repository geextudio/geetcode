# 环境配置

主要涉及编程语言:

* Python ( 3.7+, 清华镜像: [Anaconda](https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/) | [Miniconda](https://mirrors.tuna.tsinghua.edu.cn/anaconda/miniconda/), [二者对比](https://docs.conda.io/projects/conda/en/latest/user-guide/install/download.html#anaconda-or-miniconda) )
* Java ( 11+, [JDK](https://www.oracle.com/cn/java/technologies/javase-downloads.html) | [OpenJDK](https://adoptopenjdk.net/) ) | [Apache Maven](https://maven.apache.org/) (3.6.3+, [macOS (Homebrew)](https://formulae.brew.sh/formula/maven#default) | [Chocolatey (Windows)](https://chocolatey.org/packages/maven))
* Javascript ( Node, [阿里镜像](http://npm.taobao.org/mirrors/node/) )
* C# ( [.NET Core 3.x / .NET 5.x](https://dotnet.microsoft.com/download) )

---

开发环境:

* [VSCode](https://code.visualstudio.com/) 及插件 ( [Leetcode](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-leetcode) / [Python](https://marketplace.visualstudio.com/items?itemName=ms-python.python) / [JavaScript](https://code.visualstudio.com/docs/nodejs/working-with-javascript) / [C#](https://code.visualstudio.com/docs/languages/csharp) / [Java](https://aka.ms/vscode-java-installer-win) )

---

涉及到的依赖工具包括:

* [cucumber-jvm](https://cucumber.io/docs/guides/10-minute-tutorial/): 编写 [BDD](https://school.cucumber.io/) 的 Java 算法代码及测试用例
* [behave](https://behave.readthedocs.io/en/latest/tutorial.html):  编写 Python 测试用例
* [PySnooper](https://github.com/cool-RR/PySnooper): Python 代码调试 ( 可以减少 print 的使用 )
* [Pytest](https://docs.pytest.org/en/stable/): Python 单元测试
* [Jest](https://jestjs.io/zh-Hans/): JavaScript 单元测试

---

创建本地运行环境:

* Java 的 Maven 设置国内镜像

   修改 conf/setting.xml 文件，把 mirror 改成阿里的镜像。

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
   3. 运行 mvn archetype:generate 命令的时候加上 **-DarchetypeCatalog=local** 这个参数，形如:

      ```bash
      mvn archetype:generate  -DgroupId=[your-project-groupId] -DartifactId=[your-project-name] -DarchetypeCatalog=local
      ```   

* JavaScript 代码在本地测试运行需要事先安装 Node.js & yarn

   在根目录下执行如下命令安装依赖工具

   ```bash
   yarn
   ```

* Python 代码在本地运行于名为 geetcode 的虚拟环境.

   建立环境 (on Python 3.7+ )

  1. Create a virtual env:
     * Windows:

     ```bash
     python -m venv geetcode
     ```

     * Linux / Mac:

     ```bash
     python3 -m venv geetcode
     ```

  2. Activate the virtual env:
     * Windows:

      ```bash
      geetcode\Scripts\activate
      ```

      * Linux / Mac:

      ```bash
      source geetcode/bin/activate
      ```

  3. 安装依赖 ( 在虚拟环境中 ):
     升级 pip

     ```bash
     python -m pip install --upgrade pip
     ```

     使用[国内镜像](https://mirrors.tuna.tsinghua.edu.cn/help/pypi/)升级 pip

     ```bash
     python -m pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pip -U
     ```

     * 安装依赖

      ```bash
      pip install -r requirements.txt
      ```

     * 使用[国内镜像](https://mirrors.tuna.tsinghua.edu.cn/help/pypi/)安装依赖

     ```bash
     pip install -i https://pypi.tuna.tsinghua.edu.cn/simple -r requirements.txt
     ```
