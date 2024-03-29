# 权限管理系统

1. #### 后端使用的是springboot+Mybatis，前端使用的是layui

2. #### 主要实现的是组织管理，岗位管理，角色管理和用户管理(主要实现增删改查)

3. #### 设计的思路是每一个角色与一个组织和岗位绑定，对于一个权限。详见[基于SpringBoot+Mybatis+layui的权限管理系统-CSDN博客](https://blog.csdn.net/m0_67890599/article/details/134009579?spm=1001.2014.3001.5502)

4. #### 权限管理通过使用redis+token令牌实现，同时借助了浏览器的localstorage，在此基础上顺便实现了登录拦截，定时等功能。

   简单说一下实现思路：当用户登录时，后端使用uuid生成一个唯一表示，也就是token。然后把用户信息和token一起写进redis中，并返回给前端。前端把该token写入localstorage中，然后在进行每次操作时（也就是向后端发起请求时，在请求头中加入token）。后端设置一个拦截器，拦截每次请求并对每次请求进行校验。也就是把请求头中的信息提取出来，去redis中查找看用户的权限够不够，够的话就放行，不够就拦下。

   同时在redis中可以设置一个存储时间，当用户进行操作时就重置这个时间。就能实现类似于30分钟不操作就重新登录的定时功能。

   