package com.ict11.control;

import java.io.File;
import java.io.FilenameFilter;
class MyFilenameFilter implements FilenameFilter {
    
    String initials;
    
    // constructor to initialize object
    public MyFilenameFilter(String initials)
    {
        this.initials = initials;
    }
    
    // overriding the accept method of FilenameFilter
    // interface
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}

public class FindFile {
    static File DIRPATH;
    static String IDfolder;
    static String patientdir;
    static String filepat = "\\Patient.csv";
    static String filepro = "\\Problem.csv";
    public static void SaveDir(File c)
    {
        DIRPATH = c;
    }    
    public static void SaveIDfolder(String c)
    {
        IDfolder = c;
    }   
    public static boolean FindID()
    {
        String[] flist = DIRPATH.list();

        for (int i = 0; i < flist.length; i++) {
            String filename = flist[i];
            if (filename.equalsIgnoreCase(IDfolder)) 
            {
                //System.out.println(filename + " found");
                patientdir = DIRPATH.getAbsolutePath() + "\\" + IDfolder;
                return true;
            }
        }


        return false;
    }
    public static String dIRString()
    {
        return DIRPATH.getAbsolutePath();
    }
    public static String Patdir()
    {
        return patientdir;
    }
    public static String Patcsv()
    {
        return patientdir+filepat;
    }
    public static String Procsv()
    {
        return patientdir+filepro;
    }
    public static String FindImage(int x)
    {
        File an = new File(patientdir);
        String[] flist = an.list();   
        String jpghander = new String();
        jpghander = Integer.toString(x) + ".jpg";
        String pnghander = new String();
        pnghander = Integer.toString(x) + ".png";
        for (int i = 0; i < flist.length; i++) 
        {
            String filename = flist[i];
            if (filename.equalsIgnoreCase(jpghander)) 
            {
                //System.out.println(filename + " found");
                return patientdir + "\\" + jpghander;
            }
            if (filename.equalsIgnoreCase(pnghander)) 
            {
                //System.out.println(filename + " found");
                return patientdir + "\\" + pnghander;
            }
        }
        return "resource\\aihoir.png";
    }


}
