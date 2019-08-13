package com.paul.base.bean;


public class Child {

    public Child(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Child() {

    }

    private Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
