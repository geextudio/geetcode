### **Xamarin.Forms 从 'Hello, World' 到 App Store**

1. **[Xamarin][Xamarin.Link]** 是微软家进行跨平台应用开发的基础平台 (Platform), 支持 iPhone、iPad、Android 设备上应用的开发，主要开发语言是 C#;

2. **[Xamarin][Xamarin.Link]** 本身是免费的，不过建立在其之上的开发工具 Visual Studio 对于一定规模的商业组织则是收费的, 个人开发者放心用免费的社区版本；

3. **[Xamarin][Xamarin.Link]** 建立应用项目通常有3大选项：**[Xamarin.iOS](https://developer.xamarin.com/guides/ios/)** \ **[Xamarin.Android](https://developer.xamarin.com/guides/android/)** \ **[Xamarin.Forms][Xamarin.Forms.Link]**, 前两款是针对专门系统的对应开发选项，能跨平台的应用则选择 **[Xamarin.Forms][Xamarin.Forms.Link]**. 存在即为合理，前两个开发项目主要是针对需要特定平台才有的API或者特殊界面的场景，而 **[Xamarin.Forms][Xamarin.Forms.Link]** 略少了稍许个性换来了更好的跨平台通用性，请看图秒懂:
![XamarinOptions](https://raw.githubusercontent.com/biztudio/biztudio.github.io/master/mdnotes/img/xamarin.options.png)

4. **[Xamarin][Xamarin.Link]** 下 **[Xamarin.Forms][Xamarin.Forms.Link]** 声称的跨平台通用性**并不是**说一个应用项目开发完后编译可以直接发布到各种平台。这里的通用性更强调的是代码的可共享复用性，比如业务逻辑代码项目只需要编写一次就可以被 Android \ iOS \ Windows 平台的界面实现代码进行调用，同时部分界面实现代码也有部分可以共用的地方。按官方的说法，对于 Android \ Windows 平台，代码共用程度可以高达 85%, 而 iOS 平台共用程度大致是70%.



节目内容索引:


|No. | 节目                   | 说明                   |
|--------: | -------------          |-------------         |
|01| ['Hello Xamarin.Forms'](#) | 安装配置环境     |
|02| [代码结构](#)          |  细看一下到底是怎么回事 / PCL or Shared Projects      |
|03| [动动手](#)          |   从前端常用控件到后端代码走一遍     |
|04| [Unit Test](#)          | 磨刀不误砍柴工           |
|05| [异步操作](#)          | 有价值的操作往往都是异步的   |
|06| [本地数据存取](#)          | 总会有些数据需要放在客户端   |
|07| [多语言本地化](#)          | 本地化做得好，才有人愿意用   |
|07| [应用发布](#)          | 终于等到这一天了           |




[Xamarin.Link]:https://www.xamarin.com/
[Xamarin.Forms.Link]:https://developer.xamarin.com/guides/xamarin-forms/