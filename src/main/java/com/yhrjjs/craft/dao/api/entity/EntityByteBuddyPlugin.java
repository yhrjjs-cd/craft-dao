package com.yhrjjs.craft.dao.api.entity;

import java.io.IOException;
import java.lang.reflect.Method;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public class EntityByteBuddyPlugin implements Plugin {
    @Override
    public boolean matches(TypeDescription target) {
        if (isNeedRegisterEntity(target)) {
            return true;
        }

        return false;
    }

    @Override
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder,
                                        TypeDescription target,
                                        ClassFileLocator classFileLocator) {
//        Method m1 = Method.pr  MethodProtoType.class.getDeclaredMethod("calculate", int.class, int.class);

        return builder;
    }

    @Override
    public void close() throws IOException {
        System.out.println("InterceptorPlugin close method");
    }

    /**
     * 判断是否需要注册的实体
     *
     * @param target 注册类
     * @return 是否需要注册
     */
    private boolean isNeedRegisterEntity(TypeDescription target) {
        return !target.isAbstract() && target.isAssignableTo(IEntity.class);
    }
}
