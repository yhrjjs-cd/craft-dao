package com.yhrjjs.craft.dao.config;

import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

/**
 * 类扫描
 * (ITEK 2021)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 6.0
 * <pre>
 *   2021-07-24 * 黄奇创建
 * </pre>
 */
@Component
@RequiredArgsConstructor
public final class InterfaceScanSupport {
    private final ResourceLoader resourceLoader;


    /**
     * 扫描类下符合指定类的所有资料，只支持接口
     *
     * @param scanPath       路径
     * @param interfaceClass 接口类
     * @return 所有子类
     * @throws IOException 异常
     */
    public Set<String> doScan(String scanPath, Class<?> interfaceClass) throws IOException {
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
        String interfaceName = interfaceClass.getName();
        Set<String> classes = new HashSet<>();

        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                .concat(ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(scanPath))
                        .concat("/**/*.class"));

        Resource[] resources = resolver.getResources(packageSearchPath);
        MetadataReader metadataReader = null;
        for (Resource resource : resources) {
            if (resource.isReadable()) {
                metadataReader = metadataReaderFactory.getMetadataReader(resource);
                try {
                    if (metadataReader.getClassMetadata().isConcrete()) {
                        String[] interfaceNames = metadataReader.getClassMetadata().getInterfaceNames();
                        boolean find = Arrays.stream(interfaceNames).anyMatch(elem -> interfaceName.equals(elem));

                        if (find) {
                            classes.add(metadataReader.getClassMetadata().getClassName());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}
