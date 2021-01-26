# [渐进式 Web 应用 ( PWA, Progressive Web APP )](https://web.dev/progressive-web-apps/)

* ## PWA 具有下面一些特性

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

* ## App Manifest


* ## [Service Worker](https://developers.google.cn/web/fundamentals/primers/service-workers)
    
    > 控制所有所注册浏览器向 `http://www.example.com` 站点发起的请求。只需要监听 **fetch** 事件，就可以任意的操纵请求，可以返回从 **CacheStorage** 中读的数据，也可以通过 **Fetch API** 发起新的请求，甚至可以 new 一个 Response，返回给页面。所以如果误用 Service Worker, 有些页面资源可能就不会及时正确地更新。

    * 功能和特性：
    
        * 在网页已经关闭的情况下还可以运行, 用来实现页面的缓存和离线, 后台通知等等功能。
        * 一个独立的 worker 线程，独立于当前网页进程，有自己独立的 worker context。
        * 一旦被 install，就永远存在，除非被手动 unregister
        * 用到的时候可以直接唤醒，不用的时候自动睡眠
        * 可编程拦截代理请求和返回，缓存文件，缓存的文件可以被网页进程取到（包括网络离线状态）
        * 离线内容开发者可控
        * 能向客户端推送消息
        * 不能直接操作 DOM
        * 必须在 HTTPS 环境下才能工作
        * 异步实现，内部大都是通过 Promise 实现
    
    * 全局变量:

        * self: 表示 Service Worker 作用域, 也是全局变量
        * caches: 表示缓存
        * skipWaiting: 表示强制当前处在 waiting 状态的脚本进入 activate 状态
        * clients: 表示 Service Worker 接管的页面

    * 一个 Service Worker 简单完整的例子
        ```javascript
        var cacheStorageKey = 'cachesName';
        var cacheList = [
          // 注册成功后要立即缓存的资源列表
        ]
        
        // 当浏览器解析完 SW 文件时触发 install 事件
        self.addEventListener('install', function(e) {
          // install 事件中一般会将 cacheList 中要缓存的内容通过 addAll 方法，请求一遍放入 caches 中
          e.waitUntil(
            caches.open(cacheStorageKey).then(function(cache) {
              return cache.addAll(cacheList)
            })
          );
        });
        
        // 激活时触发 activate 事件
        self.addEventListener('activate', function(e) {
          // active 事件中通常做一些过期资源释放的工作，匹配到就从 caches 中删除
          var cacheDeletePromises = caches.keys().then(cacheNames => {
            return Promise.all(cacheNames.map(name => {
              if (name !== cacheStorageKey) {
                return caches.delete(name);
              } else {
                return Promise.resolve();
              }
            }));
          });
        
          e.waitUntil(
            Promise.all([cacheDeletePromises])
          );
        });
        
        self.addEventListener('fetch', function(e) {
          // 在此编写缓存策略
          e.respondWith(
            // 可以通过匹配缓存中的资源返回
            caches.match(e.request)
            // 也可以从远端拉取
            fetch(e.request.url)
            // 也可以自己造
            new Response('自己造')
            // 也可以通过吧 fetch 拿到的响应通过 caches.put 方法放进 caches
          );
        });
        
        ```    

    * [Workbox](https://developers.google.cn/web/tools/workbox/guides/get-started)

* ## [App Shell](https://developers.google.cn/web/fundamentals/architecture/app-shell)
    > 对于使用包含大量 JavaScript 的架构的单页应用来说，App Shell 是一种常用方法。
    > 
    > App Shell 提供了支持用户界面所需的最小的 HTML、CSS 和 JavaScript
