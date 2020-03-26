# Introduction
本文件夹下代码用于学习和练习基于 [Leetcode](https://leetcode-cn.com) 的算法知识，以及相关的延展内容和理论整理.

主要涉及编程语言:

* Python ( 3.7+, [Anaconda 清华镜像](https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/) )
* Java ( 8+, [Amazon Corretto](https://aws.amazon.com/cn/corretto/) )
* Javascript ( Node, [阿里镜像](http://npm.taobao.org/mirrors/node/) )
* C# ( [.NET Core 3.x / .NET 5.x](https://dotnet.microsoft.com/download) )

开发环境:

* [VSCode] 及插件 ( Leetcode / Python / C# / [Java](https://aka.ms/vscode-java-installer-win) )

---
Python 代码在本地运行于名为 geetcode 的虚拟环境.

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

3. 安装依赖:
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

   > 涉及到的依赖工具包括:
   > 1. [behave](https://behave.readthedocs.io/en/latest/tutorial.html):  编写测试用例
   > 2. [PySnooper](https://github.com/cool-RR/PySnooper): 代码调试 ( 可以减少 print 的使用 )
