package com.fds.v1.lib;

import java.util.List;
import java.util.UUID;

public class Common {
    private static final String BASE36_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encodeBase36(long number) {
        StringBuilder result = new StringBuilder();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            int remainder = (int) (number % 36);
            result.insert(0, BASE36_CHARS.charAt(remainder));
            number /= 36;
        }

        return result.toString();
    }

    public static String optionalQuery(String prefix, List<String> keys, List<String> values) {
        String query = "";
        for (String value : values) {
            int i = values.indexOf(value);
            if (value == null) continue;
            query += prefix + "." + keys.get(i) + " = '" + value + "'";
            if (i != values.size() - 1) query += ",";
        }
        return query;
    }

    public static String uuid(String label) {
        return UUID.nameUUIDFromBytes((UUID.randomUUID() + label).getBytes()).toString();
    }
}
