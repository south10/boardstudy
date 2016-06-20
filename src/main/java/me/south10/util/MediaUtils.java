package me.south10.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by south10 on 2016-06-20.
 */
@Slf4j
public class MediaUtils {
    private static Map<String, MediaType> mediaMap;
    static {
        mediaMap = new HashMap<>();
        mediaMap.put("JPG", MediaType.IMAGE_JPEG);
        mediaMap.put("GIF", MediaType.IMAGE_GIF);
        mediaMap.put("PNG", MediaType.IMAGE_PNG);
    }

    public static MediaType getMediaType(String type){
        return mediaMap.get(type.toUpperCase());
    }
}
