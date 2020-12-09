# 字节跳动、虾皮、快手、拼多多前端面试总结

## 01. react16新增了哪些生命周期、有什么作用，为什么去掉某些15的生命周期

## 02. 小程序底层实现原理了解多少（说了下双线程模型/预加载webview）

## 03. babel实现转码的过程（词法/语法分析）

## 04. webpack一些优化 

## 05. **react mixing hoc 继承 hook之间的区别/优缺点**

## 06. redux的理念(说了下action dispatch state啥的，单向数据流)

## 07. react diff如何实现? diff的时间复杂度？为什么？(o(n)。提了下react优化o(n3)->o(n))

## 08. 前端路由怎样实现(hashchange事件 hack history.pushState), react-router实现原理(hash/html5 history)

## 09. 客户端路由hash/history实现的区别、原理

## 10. 有哪些常见的http头?

## 11. 雪碧图

## 12. css的盒子模型（content-box border-box）

## 13. 前端监控怎样实现 (数据采集、上报、展示之类)

## 14. http 302 301 307之间的区别?

## 15. 跨域是什么、如何解决?

## 16. jsonp有什么缺点?

## 17. 图片base64和外链的应用场景，各有什么优缺点(base64减少请求数，但是会增加额外的体积)

## 18. http缓存机制，浏览器的缓存策略

## 19. https的握手过程是怎样的?

## 20. setState和hook的区别, hook的局限性

## 21. nodejs事件循环机制

## 22. jsx转换后是怎样的

## 23. redux compose函数做什么的，中间件呢

## 24. redux-saga是什么，和redux-thunk有什么区别

## 25. **从前端到后端全链路如何设计实现一个登录的流程(session方案、jwt)，jwt的原理**

## 26. **实现一个并发请求控制函数，限制并发数**

## 27. pureComponent和Component的区别(前者shouldComponentUpdate默认比较props)

## 28. react hoc hook解决了什么问题？

## 29. **setState同步还是异步？setState传递对象和函数有什么区别？**

## 30. **事件冒泡和事件捕获的区别、react中的冒泡和捕获呢（react中都是合成事件，无论冒泡和捕获，对应于原生事件都是冒泡）**

## 31. 实现css垂直、水平居中

## 32. **实现bind函数**

## 33. 实现快速排序

## 34. 为啥选择了redux-saga作为解决方案(解决异步优雅/提供很多工具函数)。redux的异步中间件方案有哪些，对比。saga对比dva？

## 35. react fiber的机制是怎样的？

## 36. 实现一个useState

## 37. **ES6 [proxy](https://www.yuque.com/ostwind/es6/docs-proxy) 与 promise**
* [proxy](https://www.yuque.com/ostwind/es6/docs-proxy)
    > Proxy 用于修改某些操作的默认行为，所以属于一种“元编程”. 可以理解成在目标对象之前架设一层“拦截”，外界对该对象的访问，都必须先通过这层拦截，因此提供了一种机制，可以对外界的访问进行过滤和改写. Proxy 对象可以拦截目标对象的任意属性，这使得它很合适用来写 Web 服务的客户端。

    > ES6 通过构造函数构建 proxy 实例。 作为构造函数，Proxy接受两个参数。第一个参数是所要代理的目标对象（可以为一个空对象），即如果没有Proxy的介入，操作原来要访问的就是这个对象；第二个参数是一个配置对象，对于每一个被代理的操作，需要提供一个对应的处理函数，该函数将拦截对应的操作。Proxy 支持 13 种拦截操作.
    ```javascript
    var proxy = new Proxy(target, handlerObject);
    ```
    
    1. 举例, 用来拦截对目标对象属性的访问请求 ( get 函数 )：
        ```javascript
        var person = {
          name: "张三"
        };
        
        var proxy = new Proxy(person, {
          get: function(target, property) {
            if (property in target) {
              return target[property];
            } else {
              throw new ReferenceError("Property \"" + property + "\" does not exist.");
            }
          }
        });
        // 上面代码表示，如果访问目标对象不存在的属性，会抛出一个错误。
        // 如果没有这个拦截函数，访问不存在的属性，只会返回undefined。
        
        proxy.name // "张三"
        proxy.age // 抛出一个错误
        ```
    
    2. 举例，可以将读取属性的操作（get），转变为执行某个函数，从而实现属性的链式操作：
        ```javascript
        var pipe = (function () {
          return function (value) {
            var funcStack = [];
            var oproxy = new Proxy({} , {
              get : function (pipeObject, fnName) {
                if (fnName === 'get') {
                  return funcStack.reduce(function (val, fn) {
                    return fn(val);
                  },value);
                }
                funcStack.push(window[fnName]);
                return oproxy;
              }
            });
        
            return oproxy;
          }
        }());
        
        var double = n => n * 2;
        var pow    = n => n * n;
        var reverseInt = n => n.toString().split("").reverse().join("") | 0;
        
        pipe(3).double.pow.reverseInt.get; // 63
        ```
    3. 举例，拦截 apply:
        ```javascript
        var twice = {
          apply (target, ctx, args) {
            return Reflect.apply(...arguments) * 2;
          }
        };
        function sum (left, right) {
          return left + right;
        };
        var proxy = new Proxy(sum, twice);
        proxy(1, 2) // 6
        proxy.call(null, 5, 6) // 22
        proxy.apply(null, [7, 8]) // 30
        ``` 
    4. 举例，一旦proxy代理target.m，后者内部的this就是指向proxy，而不是target。
        ```javascript
        const target = {
          m: function () {
            console.log(this === proxy);
          }
        };
        const handler = {};
        
        const proxy = new Proxy(target, handler);
        
        target.m() // false
        proxy.m()  // true
        ```    

    
    Vue3 的 Proxy 和 defineProperty 的比较:
    1. Object.defineProperty只能劫持对象的属性，而 Proxy 是直接代理对象。由于 Object.defineProperty 只能对属性进行劫持，需要遍历对象的每个属性，如果属性值也是对象，则需要深度遍历。而 Proxy 直接代理对象，不需要遍历操作。

    2. Object.defineProperty对新增属性需要手动进行 Observe。由于 Object.defineProperty劫持的是对象的属性，所以新增属性时，需要重新遍历对象，对其新增属性再使用 Object.defineProperty 进行劫持。
    
    也正是因为这个原因，使用 Vue 给 data 中的数组或对象新增属性时，
    需要使用 vm.$set 才能保证新增的属性也是响应式的。    
    
    13 种拦截操作:
    * get(target, propKey, receiver)：拦截对象属性的读取，比如proxy.foo和proxy['foo']。
    * set(target, propKey, value, receiver)：拦截对象属性的设置，比如proxy.foo = v或proxy['foo'] = v，返回一个布尔值。
    * has(target, propKey)：拦截propKey in proxy的操作，返回一个布尔值。
    * deleteProperty(target, propKey)：拦截delete proxy[propKey]的操作，返回一个布尔值。
    * ownKeys(target)：拦截Object.getOwnPropertyNames(proxy)、Object.getOwnPropertySymbols(proxy)、Object.keys(proxy)、for...in循环，返回一个数组。该方法返回目标对象所有自身的属性的属性名，而Object.keys()的返回结果仅包括目标对象自身的可遍历属性。
    * getOwnPropertyDescriptor(target, propKey)：拦截Object.getOwnPropertyDescriptor(proxy, propKey)，返回属性的描述对象。
    * defineProperty(target, propKey, propDesc)：拦截Object.defineProperty(proxy, propKey, propDesc）、Object.defineProperties(proxy, propDescs)，返回一个布尔值。
    * preventExtensions(target)：拦截Object.preventExtensions(proxy)，返回一个布尔值。
    * getPrototypeOf(target)：拦截Object.getPrototypeOf(proxy)，返回一个对象。
    * isExtensible(target)：拦截Object.isExtensible(proxy)，返回一个布尔值。
    * setPrototypeOf(target, proto)：拦截Object.setPrototypeOf(proxy, proto)，返回一个布尔值。如果目标对象是函数，那么还有两种额外操作可以拦截。
    * apply(target, object, args)：拦截 Proxy 实例作为函数调用的操作，比如proxy(...args)、proxy.call(object, ...args)、proxy.apply(...)。
    * construct(target, args)：拦截 Proxy 实例作为构造函数调用的操作，比如new proxy(...args)。

* promise
    解决的问题 （为什么使用 Promise ）
    1.消灭嵌套调用：通过 Promise 的链式调用可以解决；

2.合并多个任务的请求结果：使用 Promise.all 获取合并多个任务的错误处理。

    > 做为异步编程的一种解决方案，比传统的解决方案——回调函数和事件——更合理和更强大. 

    > Promise 简单说就是一个容器，里面保存着某个未来才会结束的事件（通常是一个异步操作）的结果。

    > 调用resolve或reject并不会终结 Promise 的参数函数的执行。因为立即 resolved 的 Promise 是在本轮事件循环的末尾执行，总是晚于本轮循环的同步任务。**不过，一般来说，调用resolve或reject以后，Promise 的使命就完成了，后继操作应该放到then方法里面，而不应该直接写在resolve或reject的后面。所以，最好在它们前面加上return语句，这样就不会有意外。**

    创造了一个Promise实例的基本格式, 构造函数接受一个函数作为参数，该函数的两个参数分别是resolve和reject。它们是两个函数，由 JavaScript 引擎提供，不用自己部署:
    ```javascript
    const promise = new Promise(function(resolve, reject) {
      // ... some code
    
      if (/* 异步操作成功 */){
        // resolve函数的作用是，将P romise 对象的状态从“未完成”变为“成功”（即从 pending 变为 resolved）
        resolve(value); 
      } else {
        // reject函数的作用是，将Promise对象的状态从“未完成”变为“失败”（即从 pending 变为 rejected）
        reject(error);
      }
    });
    ```
    Promise **实例生成以后**，可以用 **then** 方法分别指定resolved状态和rejected状态的回调函数。then方法返回的是一个新的Promise实例（注意，不是原来那个Promise实例）。
    ```javascript
    promise.then(
        // Promise对象的状态变为resolved时调用
        function(value) {
          // success
        }, 

        // Promise对象的状态变为rejected时调用 [可选参数]
        function(error) {
          // failure
        }
    );
    ```

    [手动实现一个 Promise](https://zhuanlan.zhihu.com/p/183801144)