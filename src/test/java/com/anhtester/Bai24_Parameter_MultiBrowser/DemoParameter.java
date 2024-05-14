package com.anhtester.Bai24_Parameter_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter {
    @Test
    @Parameters({"val1", "val2"})
    public void sum(int v1, int v2) {
        int result = v1 + v2;
        System.out.println("Kết quả phép cộng là: " + result);
    }

    @Test
    @Parameters({"val3", "val4"})
    public void del(int a, int b) {
        int result = a * b;
        System.out.println("Kết quả phép nhân là: " + result);
    }

    @Test
    @Parameters({"val5", "val6"})
    public void sub(@Optional("10") int a, @Optional("2") int b) {
        int result = a - b;
        System.out.println("Kết quả phép trừ là: " + result);
    }
}
