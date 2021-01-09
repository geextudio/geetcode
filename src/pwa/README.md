[渐进式 Web 应用 ( PWA, Progressive Web APP )](https://web.dev/progressive-web-apps/)

* PWA 具有下面一些特性

    * 渐进式 - 适用于所有浏览器，因为它是以渐进式增强作为宗旨开发的
    * 连接无关性 - 能够借助 Service Worker 在离线或者网络较差的情况下正常访问
    * 类似应用 - 由于是在 App Shell 模型基础上开发，因为应具有 Native App 的交互和导航，给用户 Native App 的体验
    * 持续更新 - 始终是最新的，无版本和更新问题
    * 安全 - 通过 HTTPS 协议提供服务，防止窥探和确保内容不被篡改
    * 可索引 - 应用清单文件和 Service Worker 可以让搜索引擎索引到，从而将其识别为『应用』
    * 粘性 - 通过推送离线通知等，可以让用户回流
    * 可安装 - 用户可以添加常用的 webapp 到桌面，免去去应用商店下载的麻烦
    * 可链接 - 通过链接即可分享内容，无需下载安装
    * PWA vs 原生应用
        ![cpn](./compare_pwa_native.png)

* [Service Worker](https://developers.google.cn/web/fundamentals/primers/service-workers)
    功能和特性：
    
    * 一个独立的 worker 线程，独立于当前网页进程，有自己独立的 worker context。
    * 一旦被 install，就永远存在，除非被手动 unregister
    * 用到的时候可以直接唤醒，不用的时候自动睡眠
    * 可编程拦截代理请求和返回，缓存文件，缓存的文件可以被网页进程取到（包括网络离线状态）
    * 离线内容开发者可控
    * 能向客户端推送消息
    * 不能直接操作 DOM
    * 必须在 HTTPS 环境下才能工作
    * 异步实现，内部大都是通过 Promise 实现

* [App Shell](https://developers.google.cn/web/fundamentals/architecture/app-shell)
    > 对于使用包含大量 JavaScript 的架构的单页应用来说，App Shell 是一种常用方法。
    > 
    > App Shell 提供了支持用户界面所需的最小的 HTML、CSS 和 JavaScript
