package com.change.test;

import com.sun.tools.doclets.internal.toolkit.FieldWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiaodong
 * @Date: 2020/7/15 19:26
 */
public class T {

    public static void main(String[] args) {

        //int a=12,b=3;
        //System.out.println(a);
        //File dir = new File("/Users/qiaodong/Typora");
        //List<File> list = listFile(dir);
        //for (File f:
        //     list) {
        //    System.out.println(f.getPath());
        //}

        T t = new T();
        int i=0;
        t.add(i);
        int n = i++ + i;
        System.out.println(n);


    }

    public void add(int i) {
        i++;
    }

    public static List<File> listFile(File dir) {

        List<File> list = new ArrayList<>();
        if(dir.exists()) {
            if(dir.isFile()) {
                list.add(dir);
            } else {
                for (File f: dir.listFiles()) {
                    if(f.isFile()) {
                        list.add(f);
                    } else {
                        list.addAll(listFile(f));
                    }
                }
            }
        }
        return list;
    }

}
