package com.bo;

public class Demo {

    public native void hello();

    static{
        System.loadLibrary("hello");
    }

    public static void main(String[] args){

        new Demo().hello();
    }
}
