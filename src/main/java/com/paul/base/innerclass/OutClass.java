package com.paul.base.innerclass;

/**
 * 内部类 多重继承实现
 */
public class OutClass {

    private String id;

    private static String static_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        // 可以调用内部类的方法
        // System.out.println(new InnerClass().getName());
    }

    // 内部类 读取 外部类属性 方法 但不能修改
    class InnerClass extends OutClass {

        private String name;

        public String getName() {
            // 调用外部类的成员变量
            System.out.println(" InnerClass " + id);
            return name + "" + id;
        }

        public void setName(String name) {
            // 修改不了非静态成员变量
            setId(" 内部类修改ID ");
            // 可以修改静态外部成员变量
            static_id = "static_id";
            this.name = name;
        }
    }

    class InnerClass2 extends OutClass {

        private String name;

        public String getName() {
            return name + id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.setId("OutClass[id]");
        InnerClass innerClass = outClass.new InnerClass();
        innerClass.setName("innerClass[name]");
        // 内部类可以获取外部类
        System.out.println(innerClass.getName());
        System.out.println(static_id);

    }
}
