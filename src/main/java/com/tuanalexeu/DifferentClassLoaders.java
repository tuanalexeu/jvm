package com.tuanalexeu;

import org.apache.logging.log4j.core.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Sources:
 * <a href="https://www.baeldung.com/java-classloaders">Baeldung</a>
 * <a href="https://titanwolf.org/Network/Articles/Article?AID=49a46851-a241-4d3f-af44-15b33eab4fb5#gsc.tab=0">TitanWolf</a>
 */
public class DifferentClassLoaders {

    /**
     * An application or system class loader loads our own files in the classpath.
     */
    public static void applicationClassloader() {
        System.out.println("Classloader of this class: " + DifferentClassLoaders.class.getClassLoader());
    }

    /**
     * A bootstrap or primordial class loader is the parent of all the others.
     */
    public static void bootstrapClassloader() {
        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
    }

    /**
     * Extension class loaders load classes that are an extension of the standard core Java classes.
     */
    public static void extensionClassloader() {
        System.out.println("Classloader of Logger: " + Logger.class.getClassLoader());
    }

    /**
     * If the last child class loader isn't able to load the class either,
     * it throws java.lang.NoClassDefFoundError or java.lang.ClassNotFoundException.
     */
    public static void classNotFoundException() throws ClassNotFoundException {
        Class.forName("NotExistingClass");
    }

    public static void main(String[] args) {

        applicationClassloader();
        bootstrapClassloader();
        extensionClassloader();

        try {
            classNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class CustomClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            byte[] b = loadClassFromFile(name);
            return defineClass(name, b, 0, b.length);
        }

        private byte[] loadClassFromFile(String fileName) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                    fileName.replace('.', File.separatorChar) + ".class");
            byte[] buffer;
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;
            try {
                while ( (nextValue = inputStream.read()) != -1 ) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer = byteStream.toByteArray();
            return buffer;
        }
    }

}
