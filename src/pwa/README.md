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
        监听三个事件:
        * install: 当浏览器解析完 SW 文件时触发 install 事件
        * activate: 激活时触发 activate 事件
        * fetch: 在 SW 注册好以后，处理整个 SW 控制站点的所有请求

        ```javascript
        var cacheStorageKey = 'cachesName';
        var cacheList = [
          // 注册成功后要立即缓存的资源列表
        ]
        
        /*
            所有站点 SW 的 install 和 active 都差不多，无非是做预缓存资源列表，更新后缓存清理的工作，逻辑不应该太复杂
        */

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
        
        // 在 SW 注册好以后，处理整个 SW 控制站点的所有请求
        // 通常包含复杂的缓存逻辑
        self.addEventListener('fetch', function(e) {
          // 在此编写缓存策略
          e.respondWith(
            // 可以通过匹配缓存中的资源返回
            caches.match(e.request)
            // 也可以从远端拉取
            fetch(e.request.url)
            // 也可以自己造
            new Response('Do your defined jobs!')
            // 也可以通过吧 fetch 拿到的响应通过 caches.put 方法放进 caches
          );
        });
        
        ```    

    * [Workbox](https://developers.google.cn/web/tools/workbox/guides/get-started)
        >  Workbox 是 PWA 相关的工具集合，也是 Google 官方的 PWA 框架。
        > 
        > Workbox 解决的就是用底层 API 写 PWA 太过复杂的问题。这里说的底层 API 包含去监听 install、activate、 fetch 事件做相应逻辑处理等。
        
        Workbox 一些参考缓存策略建议
        
        * **HTML**，如果需要页面离线可以访问，使用 NetworkFirst，如果不需要离线访问，使用 NetworkOnly，其他策略均不建议对 HTML 使用。
        
        * **CSS 和 JS**，
            * 如果 CSS，JS 都在 **CDN** 上，SW 并没有办法判断从 CDN 上请求下来的资源是否正确（HTTP 200），如果缓存了失败的结果，问题就大了。这种建议使用 **Stale-While-Revalidate** 策略，既保证了页面速度，即便失败，用户刷新一下就更新了。
        
            * 如果 CSS，JS 与站点在同一个域下，并且文件名中带了 Hash 版本号，那可以直接使用 **Cache First** 策略。
        
        * **图片**建议使用 Cache First，并设置一定的失效事件，请求一次就不会再变动了。
        * 对于**不在同一域下的任何资源**，**绝对不能**使用 **Cache only** 和 **Cache first**。

        常用相关扩展工具
        * workbox-cli
        * gulp-workbox
        * webpack-workbox-plagin

* ## [App Shell](https://developers.google.cn/web/fundamentals/architecture/app-shell)
    > 对于使用包含大量 JavaScript 的架构的单页应用来说，App Shell 是一种常用方法。
    > 
    > App Shell 提供了支持用户界面所需的最小的 HTML、CSS 和 JavaScript
