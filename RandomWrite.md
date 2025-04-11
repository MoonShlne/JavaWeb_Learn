我会随便写一些知识在里面





#### tomcat文件目录

```
tomcat_project/              -- Web 项目的根目录（上下文根）

├─ static/                   -- 存放可直接访问的静态资源（CSS/JS/图片等）
│  ├─ css/
│  ├─ js/
│  └─ img/

├─ WEB-INF/                  -- 受保护目录（外部无法直接访问），存放核心配置和编译后的类
│  ├─ lib/                   -- 存放项目依赖的 .jar 包
│  ├─ classes/               -- 存放编译后的 .class 字节码文件（若使用 IDE 构建，可在此查看）
│  └─ web.xml                -- Web 应用的配置文件（Servlet 映射、欢迎页等）

└─ pages/                    -- 存放页面文件（如 .html / .jsp）
   └─ index.html
```





#### servlet使用

1. 先为项目添加tomcat依赖，所需的java库都在tomcat里
2. 创建方法，实现servlet方法

3. 重写`service(HttpServletRequest req, HttpServletResponse resp)` 方法，实现业逻辑

4. 在web.xml绑定servlet和html







#### 请求转发特点

- 请求转发通过HttpServletRequest对象获取请求转发器实现
- 请求转发是服务器内部的行为,对客户端是屏蔽的
- 客户端只发送了一次请求，客户端地址栏不变
- 服务端只产生了一对请求和响应对象,这一对请求和响应对象会继续传递给下一个资源
- 因为全程只有一个HttpServletRequset对象,所以请求参数可以传递,请求域中的数据也可以传递
- 请求转发可以转发给其他Servlet动态资源，也可以转发给一些静态资源以实现页面跳转
- 请求转发可以转发给WEB-INF下受保护的资源
- 请求转发不能转发到本项目以外的外部资源





#### 响应重定向特点

- 响应重定向通过HttpServletResponse对象的sendRedirect方法实现
- 响应重定向是服务端通过302响应码和路径,告诉客户端自己去找其他资源,是在服务端提示下的,客户端的行为
- 客户端至少发送了两次请求，客户端地址栏是要变化的
- 服务端产生了多对请求和响应对象,且请求和响应对象不会传递给下一个资源
- 因为全程产生了多个HttpServletRequset对象,所以请求参数不可以传递,请求域中的数据也不可以传递
- 重定向可以是其他Servlet动态资源，也可以是一些静态资源以实现页面跳转
- 重定向不可以到给WEB-INF下受保护的资源
- 重定向可以到本项目以外的外部资源



优先使用重定向





#### 关于tomcat的sout乱码问题



把setting里的consol的编码改成gkb

然后把property里的console的encoding也改成gbk





#### 路径问题

**请求转发**：内部跳转，路径是“相对于应用根目录”；不需要加 Context Path。

**重定向**：告诉浏览器访问新 URL，必须是浏览器能解析的完整路径，需加 Context Path（或完整域名）。

这并非 Tomcat 的独特设计，而是 **Servlet 规范 + HTTP 协议** 共同决定的逻辑





VUE

文本渲染

首先是插值表达式 以及文本渲染

插值表达式用 `{{}}`来表示 文本渲染用v-text ，两个都差不多

插值表达式里面可以写自己写的变量值，或者是运算符，也可以是有返回值的函数



属性渲染

v-bind



事件绑定

v-on 或者@事件名
