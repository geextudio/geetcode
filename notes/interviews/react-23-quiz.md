# [React 23 问](https://zhuanlan.zhihu.com/p/304213203)

## 1. setState 是异步还是同步？
* 异步
    * [合成事件](https://www.jianshu.com/p/ee4d66cb44b2)中是异步
        > 由众多不同类型事件的合成事件对象组成的合成事件系统(React’s Event System)
    * 钩子函数中的是异步
* 同步
    * 原生事件中是同步
    * setTimeout中是同步
    