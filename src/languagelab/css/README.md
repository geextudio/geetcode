# CSS (SCSS) 实践与学习

## 知识点

* CSS 技巧
    * 布局
        > [Flex](http://www.ruanyifeng.com/blog/2015/07/flex-examples.html) 布局是轴线布局，只能指定"项目"针对轴线的位置，可以看作是一维布局。[Grid](http://www.ruanyifeng.com/blog/2019/03/grid-layout-tutorial.html) 布局则是将容器划分成"行"和"列"，产生单元格，然后指定"项目所在"的单元格，可以看作是二维布局。[Grid](http://www.ruanyifeng.com/blog/2019/03/grid-layout-tutorial.html) 布局远比 [Flex](http://www.ruanyifeng.com/blog/2015/07/flex-examples.html) 布局强大。
        * [Flex](http://www.ruanyifeng.com/blog/2015/07/flex-examples.html)
        * [Grid](http://www.ruanyifeng.com/blog/2019/03/grid-layout-tutorial.html)
    * 选择器
    * 单位换算
    * 多屏适应
* SCSS 技巧
* [Bulma](https://bulma.io)
* 基于 Webpack 的样式内容处理
    * [style-loader](https://webpack.js.org/loaders/style-loader/)
    * [css-loader](https://webpack.js.org/loaders/css-loader/)
    * [sass-loader](https://webpack.js.org/loaders/sass-loader/)
    * [mini-css-extract-plugin](https://webpack.js.org/plugins/mini-css-extract-plugin/)

## 环境

```bash
npm i --save-dev webpack webpack-cli node-sass style-loader css-loader sass-loader
```