package com.mysql.headline.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.headline.pojo.NewsUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/20 14:20
 */
public class MapTest {
    @Test
    public void test(){
        ObjectMapper objectMapper = new ObjectMapper();
        NewsUser newsUser = new NewsUser(1, "aa", "haha", "ddd");
        NewsUser newsUser1= new NewsUser(1, "aa", "haha", "ddd");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(newsUser1);
        objects.add(newsUser);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("user",objects);
        objectObjectHashMap.put("pagenum",1);
        try {
            System.out.println(objectMapper.writeValueAsString(objectObjectHashMap));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
