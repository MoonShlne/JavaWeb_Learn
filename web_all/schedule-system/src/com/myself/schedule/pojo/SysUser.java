package com.myself.schedule.pojo;


import lombok.*;

import java.util.Objects;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 15:52

 * 类名跟表格名对象
 * 每个属性都是私有&&getter setter
 * 无参构造器
 * 实现序列化接口
 * 重写hashcode 和equals 方法

 * 使用lombok 自动生成 内容
 *  添加注解
 *  设置里添加enable  annotation  processing
 *  导入依赖
 */
@NoArgsConstructor
@AllArgsConstructor    //添加全参构造
@Data
public class SysUser {
    private  Integer uid;
    private  String username;
    private  String password;

}
