package com.mysql.headline.pojo;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 13:59
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsType implements Serializable {
    private Integer tid;
    private String tname;
}