package com.fds.v1.lib;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Common {
    private static final String BASE36_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encodeBase36(long num) {
        StringBuilder result = new StringBuilder();
        if (num == 0) return "0";

        while (num > 0) {
            int remainder = (int) (num % 36);
            result.insert(0, BASE36_CHARS.charAt(remainder));
            num /= 36;
        }
        return result.toString();
    }

    public static String optionalQuery(String prefix, List<String> keys, List<String> values) {
        String query = "";
        for (String value : values) {
            int i = value.indexOf(value);
            if (value == null) continue;
            query += prefix + "." + keys.get(i) + " = '" + value + "'";
            if (i != values.size() - 1) query += ",";
        }
        return query;
    }

    public static String uuid(String label) {
        return UUID.nameUUIDFromBytes((UUID.randomUUID() + label).getBytes()).toString();
    }

    public static String capitalizeFirst(String input) {
        if (input == null || input.isEmpty()) return input;

        char firstChar = Character.toUpperCase(input.charAt(0));
        return firstChar + input.substring(1);
    }

    public static <T> T updateObjectWithMap(T o, Map<String, Object> m) {
        for (Map.Entry<String, Object> entry : m.entrySet()) {
            String propertyName = entry.getKey();
            Object propertyValue = m.get(propertyName);

            try {
                if (propertyValue != null) o
                        .getClass()
                        .getMethod("set" + Common
                                        .capitalizeFirst(propertyName),
                                propertyValue
                                        .getClass())
                        .invoke(m, propertyValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return o;
    }
}
