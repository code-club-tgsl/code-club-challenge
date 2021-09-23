package com.code.club.challenge.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    public static String toJson(String uglyJsonString) {
        var gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        var je = JsonParser.parseString(uglyJsonString);
        return gson.toJson(je);
    }
}
