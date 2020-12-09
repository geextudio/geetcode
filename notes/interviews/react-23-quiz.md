# [React 23 问](https://zhuanlan.zhihu.com/p/304213203)

## 1. setState 是异步还是同步？
* 异步
    * [合成事件](https://juejin.cn/post/6844904066397503502)中是异步
    * 钩子函数中的是异步
* 同步
    * 原生事件中是同步
    * setTimeout中是同步
    