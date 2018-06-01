package com.ice.tool;

import java.lang.reflect.Field;

public class BeanUtils {

    /**
     * 复制新对象中有不同于默认值的字段到原有对象中
     * @param object1 修改的对象
     * @param object2 参考的对象
     * @param <T> 泛型
     */
    public static <T> void copy(T object1,T object2) throws IllegalAccessException, InstantiationException {
        Class classObj=object1.getClass();
        Object obj=classObj.newInstance();
        Field[] fields=classObj.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);//暴力反射，解除私有限定
            Object defaultStr=field.get(obj);
            Object object2Str=field.get(object2);
            if(defaultStr==null){
                if(object2Str!=null){
                    field.set(object1,object2Str);
                }
            } else{
                if(!defaultStr.equals(object2Str)){
                    field.set(object1,object2Str);
                }
            }
        }
    }
}
