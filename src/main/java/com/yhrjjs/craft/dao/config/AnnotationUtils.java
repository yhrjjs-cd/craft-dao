package com.yhrjjs.craft.dao.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-15 * 黄奇创建
 * </pre>
 */
public class AnnotationUtils {
    /**
     * Parse Annotation Info
     *
     * @param annotation Annotation Object
     * @return Annotation Info
     */
    public static AnnotationInfo parseAnnotation(Annotation annotation) {
        AnnotationInfo annotationInfo = new AnnotationInfo();

        try {
            Class<?> clazz = annotation.getClass().getSuperclass();
            Field hField = clazz.getDeclaredField("h");
            hField.setAccessible(true);
            Object h = hField.get(annotation);

            Class<?> dynamicProxyClass = h.getClass();
            Field typeField = dynamicProxyClass.getDeclaredField("type");
            typeField.setAccessible(true);
            Object typeObject = typeField.get(h);

            Field nameField = typeObject.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            String name = String.valueOf(nameField.get(typeObject));
            annotationInfo.setClassName(name);

            Field memberValuesField = dynamicProxyClass.getDeclaredField("memberValues");
            memberValuesField.setAccessible(true);
            Object memberValues = memberValuesField.get(h);
            annotationInfo.setMemberValues((Map<String, Object>) memberValues);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return annotationInfo;
    }

    /**
     * Annotation Info
     * Proxy class cannot reflected。
     */
    @Data
    public static class AnnotationInfo {
        /**
         * 字段名称
         */
        private String fieldName;
        /**
         * Annotation Name
         */
        private String className;

        /**
         * Member values;
         */
        private Map<String, Object> memberValues;
    }
}
