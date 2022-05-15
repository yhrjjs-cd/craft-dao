package com.yhrjjs.craft.dao.config;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.SystemPropertyUtils;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public class EntityClassLoader extends ClassLoader {
    public EntityClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassBytes(name);

        Class theClass = defineClass(name, bytes, 0, bytes.length);
        if (theClass == null) {
            throw new ClassFormatError();
        }

        return theClass;
    }

    @SneakyThrows
    private byte[] loadClassBytes(String className) throws ClassNotFoundException {
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(null);
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                .concat(ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(className))
                        .concat(".class"));

        Resource[] resources = resolver.getResources(packageSearchPath);
        if (resources.length > 0) {
            Resource resource = resources[0];
            byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
            resource.getInputStream().close();

            return bytes;
        }

        return null;
    }
}
