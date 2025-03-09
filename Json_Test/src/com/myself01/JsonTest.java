package com.myself01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/9 13:46
 */
public class JsonTest {
    @Test
    public void test() throws JsonProcessingException {
        Dog aag = new Dog("aag");
        Friends friend1 = new Friends("dragon");
        Friends friend2 = new Friends("null");
        Person piggy = new Person("piggy", 21, aag, new Friends[]{friend1, friend2});
        System.out.println(piggy);
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(objectMapper.writeValueAsString(piggy));



    }
    @Test
    public void test2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json="{\"name\":\"piggy\",\"age\":12,\"dog\":{\"dName\":\"aag\"},\"friend\":[{\"fName\":\"dragon\"},{\"fName\":\"null\"}]}";
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }

    @Test
    public void test3() throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("pig","Silly");
        map.put("dragon","Smart");

        System.out.println(map);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        System.out.println(s);

    }

    @Test
    public void test4() throws JsonProcessingException {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("i don't know");
        objects.add(2);

        System.out.println(objects);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(objects);
        System.out.println(s);
    }

    @Test
    public void test5() throws JsonProcessingException {
        HashSet<Object> objects = new HashSet<>();
        objects.add("i don't know");
        objects.add(2);
        objects.add(2);
        objects.add(2);

        System.out.println(objects);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(objects);
        System.out.println(s);
    }


}
