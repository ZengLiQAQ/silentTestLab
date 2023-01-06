package com.lab.silent.funnytool.jprofiler;/**
 * Created by zengli on 2020/11/25.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProFilerTest
 * @Description IDEA 内存分析工具,jprofiler 测试
 * @Author ZengLi
 * @Date 2020/11/25 9:41
 * @VerSion 1.0
 **/
public class ProFilerTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        for(int i = 0; i < 100000000; i++){
            list.add(i);
        }
    }
}
