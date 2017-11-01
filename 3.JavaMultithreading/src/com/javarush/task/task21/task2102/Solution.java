package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* 
Сравниваем модификаторы
*/
public final class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        byte[] allModifiersBytes = ByteBuffer.allocate(4).putInt(allModifiers).array();
        byte[] specificModifierBytes = ByteBuffer.allocate(4).putInt(specificModifier).array();
        byte[] result = new byte[4];
        for (int i = 0; i < result.length; i++)
            result[i] = (byte)(allModifiersBytes[i] & specificModifierBytes[i]);
        return Arrays.equals(result, specificModifierBytes);
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
