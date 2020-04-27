# Mac 上的 Java 环境配置

## JAVA_HOME 环境变量

安装完成 JDK 之后，需要执行如下代码确认一下环境变量 JAVA_HOME 是否正确配置
```bash
echo $JAVA_HOME
```

如果没有显示任何内容则执行如下命令找到 java home 的目录
```bash
/usr/libexec/java_home -V
```

打开 .bash_profile
```bash
vim ~/.bash_profile
```

按 i 键进入插入模式，将JAVA_HOME的路径添加到 .bash_profile 中
```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
export CLASS_PATH=$JAVA_HOME/lib
```
按 ESC, 再输入 :wq 保存退出

刷新一下
```bash
source ~/.bash_profile
echo $JAVA_HOME
```

NOTE: 

如果终端使用的是zsh，则加载的是 ~/.zshrc文件，而 ‘.zshrc’ 文件中并没有定义任务环境变量。

解决办法：

在~/.zshrc文件最后，增加一行：
```
source ~/.bash_profile
```
