package com.boot.security.server.utils;
import io.swagger.models.auth.In;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/6.
 */
public class EnumUtil {
    /**
     *  根据某个枚举类型下的某个顺序获取对应的枚举对象
     *   T
     *   *@param clazz
     *    @param ordinal，指的是需要的枚举值在设定的枚举类中的顺序，以0开始
     *    @return
     */
    public static <T extends Enum<T>> T getByOrdinal(Class<T> clazz, int ordinal){
        return clazz.getEnumConstants()[ordinal];
    }
    /**
     * * 根据某个枚举下的某个常量名获取对应的枚举对象
     * T	 *
     * @param clazz，对应哪个枚举类型，传入参数示例：PackingType.class
     * @param name	 ，对应枚举类型下的某个枚举常量名
     * @return Enum T
     */
    public static <T extends Enum<T>> T getByName(Class<T> clazz, String name){
        return Enum.valueOf(clazz, name);
    }
    /**	 *
     * 根据某个枚举类型下的某个枚举值获取枚举对象
     * T	 *
     * @param clazz    枚举类的class	 *
     * @param value  传入的枚举值 *
     */
    public static <T extends Enum<T>> T getByValue(Class<T> clazz, Integer value){
        String getValueMethodName="getValue";
        T result = null;
        try{
            T[] arr = clazz.getEnumConstants();
            Method targetMethod = clazz.getDeclaredMethod(getValueMethodName);
            Integer myVal = null;
            for(T entity:arr){
                myVal =Integer.parseInt(targetMethod.invoke(entity).toString());
                if(myVal.equals(value)){
                    result = entity;
                    break;
                }
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }
        /**
         * 根据某个枚举下的某个枚举别名获取对应的枚举对象
         * T
         * @param clazz   枚举类的class
         * @param alias 传入的枚举别名，这个方法为String类型
         * @return
         */
        public static <T extends Enum<T>> T getByAlias(Class<T> clazz, String alias){
            String getAliasMethodName="getAlias";
            T result = null;
            try{
                T[] arr = clazz.getEnumConstants();
                Method targetMethod = clazz.getDeclaredMethod(getAliasMethodName);
                String myAlias = null;
                for(T entity:arr){
                    myAlias = targetMethod.invoke(entity).toString();
                    if(myAlias.contentEquals(alias)){
                        result = entity;
                        break;
                    }
                }
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            catch (SecurityException e) {
                e.printStackTrace();
            }
            return result;
        }

    /**
     * 定义一个返回某个枚举类型中的枚举项的列表模型，
     */
    public static class EnumModel
    {
        private String name;
        private String alias;
        private Integer value;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAlias() {
            return alias;
        }
        public void setAlias(String alias) {
            this.alias = alias;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }

    /**
     * 获取某个枚举类型下的枚举项的列表形式
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T extends Enum<T>> List<EnumModel> list(Class<T> clazz){
        List<EnumModel> result=new ArrayList<EnumModel>();
        String getAliasMethodName="getAlias";
        String getValueMethodName="getValue";

        try{
            T[] arr = clazz.getEnumConstants();
            Method AliasMethodName =clazz.getDeclaredMethod(getAliasMethodName);
            Method ValueMethodName = clazz.getDeclaredMethod(getValueMethodName);
            for(T entity:arr) {
                EnumModel model = new EnumModel();
                model.setAlias(AliasMethodName.invoke(entity).toString());
                model.setValue(Integer.parseInt(ValueMethodName.invoke(entity).toString()));
                model.setName(entity.name());
                result.add(model);
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }
}
