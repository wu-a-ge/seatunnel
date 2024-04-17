package org.apache.seatunnel;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceCharEntityUtils {
    private static final Pattern patternHtmlEntity = Pattern.compile("&#?(?<name>\\w+);");
    private static final Map<String, String> CHAR_ENTITIES = new HashMap<>();

    static {
        CHAR_ENTITIES.put("nbsp", " ");
        CHAR_ENTITIES.put("160", " ");
        CHAR_ENTITIES.put("lt", "<");
        CHAR_ENTITIES.put("60", "<");
        CHAR_ENTITIES.put("gt", ">");
        CHAR_ENTITIES.put("62", ">");
        CHAR_ENTITIES.put("amp", "&");
        CHAR_ENTITIES.put("38", "&");
        CHAR_ENTITIES.put("quot", "\"");
        CHAR_ENTITIES.put("34", "\"");
    }

    public static String replaceAll(String rawHtml) {
        if (Strings.isNullOrEmpty(rawHtml)) return "";
        Matcher sz = patternHtmlEntity.matcher(rawHtml);
        while (sz.find()) {
            String entity = sz.group(); // entity全称，如&gt;
            String key = sz.group("name"); // 去除&;后entity,如&gt;为gt
            try {
                rawHtml = rawHtml.replace(entity, CHAR_ENTITIES.get(key));
            } catch (NullPointerException e) {
                // 以空串代替
                rawHtml = rawHtml.replace(entity, "");
            }
        }
        return rawHtml;
    }
}
