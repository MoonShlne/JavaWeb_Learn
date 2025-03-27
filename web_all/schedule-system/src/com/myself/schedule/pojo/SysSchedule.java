package com.myself.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 17:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule {
     private  Integer sid;
     private  Integer uid;
     private   String title;
     private Integer completed;

}
