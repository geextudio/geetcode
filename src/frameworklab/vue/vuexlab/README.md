# [Vuex](https://vuex.vuejs.org/zh/)

## 是什么

* Vuex 是前端为了方便数据 ( state ) 的操作而建立的一个"前端数据库"
 
典型场景 ( 模块间是不共享作用域的 ): 
  * B 模块想要拿到 A 模块的数据
  * A 模块中的数据发生了变更如何让 B 也及时得到更新
  * A, B 模块都想得到一些公共的数据...
    
    > 类比后端数据库操作，
    > 获取数据 ( state ) 用 getter
    > 
    > 修改数据 ( state ) 用 mutation
    > 
    > actions 负责对拿到/传入的数据先做个处理（异步），处理完了再存到 ( mutation ) 数据库中。
    > 
    > 数据流：action 处理数据，然后通过 mutation 把处理后的数据放入数据库（ state ）中，谁要用就通过 getter从数据库（ state ）中取。
    > 
    > 由于 getter 对应一个方法，所以 getters 就相当于vue中的computed属性

注：state 有两个，一个是组件内部 state，它负责组件私有状态。还有一个 state 是 vuex 维护的 state。这是 state 是所有组件所共用的。这两个 state 的变化，vue 都能监视到，从而更新视图。所以组件私有的 state 应该写到 state 上；而公共 state，需要持久化的 state 需要挂到 state 上