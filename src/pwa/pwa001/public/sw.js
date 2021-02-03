var cacheStorageKey = 'minimal-pwa-1';

var cacheList = [
  '/',
  'favicon.ico',
  "index.html",
  "404.html",
  "main.css",
  "geextudio.png"
];

self.addEventListener('install', event => {
    console.log('EVENT: install');
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

self.addEventListener('activate', event => {
  console.log('EVENT: activate');

  // event.waitUntil() 接收一个 Promise, 等到 Promise 完成时, 事件才最终完成。
  event.waitUntil(
    clients.claim()//立即受控
  );
  
});

self.addEventListener('fetch', event => {
 
    console.log('EVENT: fetch');
   
   /*  console.log(`event.request.url: ${event.request.url}`);
    console.log(`event.request.mode: ${event.request.mode}`); */

    if(event.request.mode === 'navigate'){

      console.log(`event.request.mode (navigate expected): ${event.request.mode}`);

      return event.respondWith(

        fetch(event.request).then(response => {

          console.log(`response.status: ${response.status}`);

          if(response.status == 404){
            return fetch('404.html');
          }

          return response;
        }).catch(() => {

          // 离线模式处理代码块
          console.log('Offline is on...');

          // 离线用缓存，找到指定缓存
          return caches.open(cacheStorageKey).then(cache => {

            // 在打开的缓存中找到请求 match 得上的内容进行响应
            return cache.match(event.request).then(response => {

              if(response){
                return response;
              }
              
              // 没有找到可以用的缓存进行响应
              console.log('No Response matches the cache')
              return cache.match('404.html');
            });

          })

        })
        
      );

    }
    else{
      console.log('non-navigate mode')
    }

    if(/geextudio.png$/.test(event.request.url)){
      console.log(`replace image request.`)
      return event.respondWith(fetch('./amazon.futureengineer.dm.png'));
    }
 
  });  