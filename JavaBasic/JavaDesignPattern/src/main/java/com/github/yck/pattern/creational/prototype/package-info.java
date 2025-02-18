package com.github.yck.pattern.creational.prototype;
/**
 * 原始模式在 Java 中比较好理解，其实就是；
 *  - 隐藏构建过程
 *  - 继承 Cloneable 接口，实现浅拷贝或深拷贝
 *
 * 浅拷贝
 *  - 浅拷贝指的是直接调用 Object.clone() 的方法。
 *  - 浅拷贝只会赋值基本类型（直接复制） ，对于数组、集合类，其他类则只拷贝引用（即该对象
 *  指向堆中另外一个对象不会被赋值），
 *  - 这就导致只要修改一个对象，其他克隆的对象的变量也会改变
 *
 * 深拷贝
 *  - 把对象中的其他数据类型全部拷贝一份，也就是该对象指向堆中另一个对象，也要拷贝。
 *  - 三种方法：
 *      - 递归的调用浅拷贝
 *      - 使用序列化与反序列化（非常讨巧）
 *          - 因为序列化是为了通过流，在网络或本地写入，通过序列化时候递归的将堆中所有对象
 *          转为二进制字节流，然后再反序列化回来。
 *      - 当然，还可以使用第三方包 Apache common 或者 Gson 都是通过序列化方式进行递归深拷贝
 */