package com.ict11.control;

public class v {
    public static void maintest(String[] args) {
        // This is a test method, not applicable on Linux / MacOS
        // Cross-platform stub
        String sys = System.getProperty("os.name");
        if (sys.startsWith("Windows"))
        {
            FindFile.patientdir = "E:/data/fullbody";
        }
        else 
        {
            FindFile.patientdir = "~/data/fullbody";
        }
        
        System.out.println(FindFile.FindImage(3));
        //StretchIcon a = new StretchIcon(FindFile.FindImage(3));
    }
}
