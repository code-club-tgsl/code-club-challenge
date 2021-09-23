package com.code.club.challenge.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    public static String getFileContent(String filename) {
        try (var inputStream = FileUtil.class.getResourceAsStream("/" + filename)) {
            assert inputStream != null;
            try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource: " + filename, e);
        }
    }
}
