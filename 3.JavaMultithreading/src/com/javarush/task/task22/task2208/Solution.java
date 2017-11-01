package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getQuery(map));
        System.out.println("\"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'\"");
    }

    public static String getQuery(Map<String, String> params) {
        if (params == null || params.size()==0 ) return null;
        StringBuilder sb = new StringBuilder("\"");
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() == null || pair.getKey() == null) continue;
            sb = sb.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }
        if (sb.length() > 5) sb.delete(sb.length()-5, sb.length());

        return sb.append("\"").toString();
    }
}
