// ICountService.aidl
package com.example.administrator.helloservice;

// Declare any non-default types here with import statements

interface ICountService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     long getCountNumber();
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
