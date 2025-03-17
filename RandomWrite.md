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

1.先为项目添加tomcat依赖，所需的java库都在tomcat里

2.创建方法，实现servlet方法

3.重写`service(HttpServletRequest req, HttpServletResponse resp)` 方法，实现业逻辑

4.在web.xml绑定servlet和html