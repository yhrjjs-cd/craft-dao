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

            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println(classOfT.getTypeParameters() + "===");
//        for(Object o: classOfT.getTypeParameters()){
//            System.out.println(o.getClass());
//        }
//
//        // classOfT是包装类，解析不出注解信息，所以新建一个对象来判断
//        Object m = classOfT.newInstance();
//        Class<?> classOfRealT = m.getClass();
//        Class<?> aa = ClassUtils.resolveClassName(entityClass, entityClassLoader);
//        Class<?> af = ClassUtils.resolvePrimitiveIfNecessary (classOfT);
//
//        System.out.println(classOfT.getAnnotationsByType(Column.class));
//        System.out.println(aa.getClass() + "dd");
//        Column[] columns = classOfT.getAnnotationsByType(Column.class);
//        Arrays.stream(columns).forEach(elem->{
//            System.out.println(elem.hump());
//        });
//        System.out.println(classOfRealT+ "===55555");
////        System.out.println(classOfRealT);
////        ReflectionUtils.doWithFields(classOfRealT, field -> {
////            for (Annotation a : field.getAnnotations()) {
////                System.out.println(a.getClass());
////            }
////            System.out.println(field.getAnnotation(Column.class));
////            System.out.println(field.getName());
////        }, field -> {
////            Arrays.stream(field.getAnnotations()).forEach(annotation -> {
////                System.out.println(annotation.getClass());
////            });
////            return field.isAnnotationPresent(Column.class);
////        });

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
