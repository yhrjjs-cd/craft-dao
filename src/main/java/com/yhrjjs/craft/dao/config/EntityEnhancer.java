package com.yhrjjs.craft.dao.config;

import com.yhrjjs.craft.dao.Config;
import com.yhrjjs.craft.dao.annotation.Column;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Loader;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.core.io.ResourceLoader;
import org.springframework.objenesis.instantiator.util.ClassDefinitionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * 注册所有实体
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * <pre>
 *     历史:
 *     2021-07-24 黄奇 创建
 * </pre>
 */
@Component
@RequiredArgsConstructor
public class EntityEnhancer implements ApplicationRunner {
    private final CodeGenerator codeGenerator;
    private final InterfaceScanSupport classScanSupport;

    @SuppressWarnings("unchecked")
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<String> classes = classScanSupport.doScan(Config.class.getPackage().getName(), IEntity.class);

        for (String className : classes) {
            this.enhanceEntityClass(className);
        }
    }

    private void enhanceEntityClass(String entityClassName) throws NotFoundException, CannotCompileException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("java.util.Map");
        classPool.importPackage("java.util.HashMap");
        CtClass ctClass = classPool.get(entityClassName);
        CtMethod valueMap = CtNewMethod.make(codeGenerator.generateValueMapMethodCode(entityClassName), ctClass);
        ctClass.addMethod(valueMap);
        ctClass.writeFile("e:/t");
        ctClass.toClass();
    }

    public static void main(String[] args) {

    }

}
