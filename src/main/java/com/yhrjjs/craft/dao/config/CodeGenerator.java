package com.yhrjjs.craft.dao.config;

import com.yhrjjs.craft.dao.annotation.Column;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import javassist.Loader;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * 代码生成器
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-15 * 黄奇创建
 * </pre>
 */
@Component
public class CodeGenerator {
    private ClassLoader entityClassLoader = new Loader();

    /**
     * 生成valueMap方法
     *
     * @param entityClassName 实体类名
     * @return valueMap方法
     */
    public String generateValueMapMethodCode(String entityClassName) {
        try {
            Class<?> classOfT = this.entityClassLoader.loadClass(entityClassName);

            StringBuilder stringBuilder = new StringBuilder("public Map valueMap(){Map valueMap = new HashMap();");

            ReflectionUtils.doWithFields(classOfT, field -> {
                AnnotationUtils.AnnotationInfo annotationInfo = this.getColumnAnnotation(field);

                if (Objects.nonNull(annotationInfo)) {
                    stringBuilder.append("valueMap.put(\"" + annotationInfo.getFieldName() + "\"," + "this." + annotationInfo.getFieldName() + ");");
                }
            });

            stringBuilder.append("return valueMap;}");

            return stringBuilder.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private AnnotationUtils.AnnotationInfo getColumnAnnotation(Field field) {
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            AnnotationUtils.AnnotationInfo annotationInfo = AnnotationUtils.parseAnnotation(annotation);

            if (Column.class.getName().equals(annotationInfo.getClassName())) {
                annotationInfo.setFieldName(field.getName());
                return annotationInfo;
            }
        }

        return null;
    }
}
