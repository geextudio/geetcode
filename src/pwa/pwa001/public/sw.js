var cacheStorageKey = 'minimal-pwa-1';

var cacheList = [
  '/',
  'favicon.ico',
  "index.html",
  "main.css",
  "geextudio.png"
];

self.addEventListener('install', event => {
    console.log('install event');
    // install 事件中一般会将 cacheList 中要缓存的内容通过 addAll 方法，请求一遍放入 caches 中
    // event.waitUntil() 接收一个 Promise, 等到 Promise 完成时, 事件才最终完成。
    event.waitUntil(
      // 通过 open 获取一个可操作的 Cache 对象
      caches.open(cacheStorageKey)
      .then(cache => cache.addAll(cacheList))
      // 在页面更新的过程当中, 新的 Service Worker 脚本能立即激活和生效
      .then(() => self.skipWaiting())
    );
  });

self.addEventListener('fetch', event => {
    console.log('fetch event');
    event.respondWith(
        caches.match(event.request).then(response => {
          console.log(`fetch info event.request: ${event.request.url}`);  
          
          if (response != null) {
            console.log('response ready');  
            return response;
          }

          console.log('response NOT ready');
          return fetch(event.request.url);
        })
      )
});  