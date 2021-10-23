package com.ict11.control;

import com.ict11.tools.*;
public class v {
    public static void maintest(String[] args) {
        FindFile.patientdir = "E:\\data\\fullbody";
        System.out.println(FindFile.FindImage(3));
        //StretchIcon a = new StretchIcon(FindFile.FindImage(3));
    }
}
