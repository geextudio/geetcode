---
navbar: false
lang: en-US
# ppt options
ppt:
    # whether to display pagination
    showPage: false
    # custom page-style with page number as 'key'
    listStyle:
        1: 'background-image: url(/imgs/bg.jpg)'
---
<div style="margin-top: 0;height: calc(100vh - 8rem);">

::: ppt

# **Composition API** 
 
*Apply Vue3 core features in Vue2*


July 1, 2021. Yang SHEN

----

# Topix

* What
* Why
* How

----

# [What does Vue 3 bring to us](https://vueschool.io/articles/vuejs-tutorials/exciting-new-features-in-vue-3/)?

* **[Composition API](https://v3.vuejs.org/guide/composition-api-introduction.html)**
* Full TypeScript support
* Portals
* Fragments
* Suspense
* Global Mounting/Configuration API change
* Multiple v-models
* Custom Directive API
* High Performance can meet Svelte

----

# 1. What does Composition-API bring us?

----

# 1.1. The Code Structure 

![option-vs-composition](https://res.cloudinary.com/dcwhvbsq5/image/upload/q_100/v1568022356/option-vs-composition_clvge7.png)

----

# 1.1. The Code Structure 

![comparevue.optionapi.vs.compositionapi](https://img.kancloud.cn/27/76/27764adda45a5aa388cb8f55affa3178_785x540.gif)

----

# 1.1. The Code Structure

![code compare](https://pic4.zhimg.com/v2-2394b6d3e27fda1932c87776ec2062ef_1440w.jpg?source=172ae18b)

----

# 1.1. What does a simple example look like 

```javascript
// src/components/UserRepositories.vue `setup` function
import { fetchUserRepositories } from '@/api/repositories'

// inside our component
setup (props) {
  let repositories = []

  const getUserRepositories = async () => {
    repositories = await fetchUserRepositories(props.user)
  }

  return {
    repositories,
    // functions returned behave the same as methods
    getUserRepositories 
  }
}
```

----

# 1.1. The Code Structure 

|Version|Structure|Group|
|----|----|----| 
|Vue 2.x|Options-API|Option Group|
|Vue 3.x|Compositon-API+Options-API|Business Group + Option Group|

----
# 1.2. The Way of Code Reusing

|How|Pro|Con|
|----|----|----|
|Mixin|Easy to use| Conflict, Hard to identify |
|Composition-APi|Easy to use|Not supported before Vue 2.6|

----
# 3. To use Composition-API in Vue 2.6.x+

* [Official Plugin for Vue 2.6+: @vue/composition-api](https://github.com/vuejs/composition-api/blob/master/README.md)
* From Vue 2.7.x, it is built-in feature

----

# 4. How

* Potential Trans
    * No 'this' inside **setup**
    > since **setup** is consumed after **beforeCreate** and before **created**
    * Existing Components compatibility
 
----
 
# 4. Lifecycle Hooks Comparison

|Option API|Composition API|
|----|----|
|beforeCreate |	Not needed*|
|created |	Not needed*|
|beforeMount |	onBeforeMount|
|mounted |	onMounted|
|beforeUpdate |	onBeforeUpdate|
|updated |	onUpdated|
|beforeUnmount |	onBeforeUnmount|
|unmounted |	onUnmounted|
|errorCaptured |	onErrorCaptured|
|renderTracked |	onRenderTracked|
|renderTriggered |	onRenderTriggered|
|activated |	onActivated|
|deactivated |	onDeactivated|
    
----
# What's next? 

* IE & Vue 3 divorce...  :broken_heart: :( 
* UI Components supports
* **Vue 2.7.x is an important upgrade for Vue 2.x ecosystem**

Thank you

:::

</div>