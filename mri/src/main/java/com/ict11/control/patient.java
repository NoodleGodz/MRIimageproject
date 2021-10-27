package com.ict11.control;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class patient {
    public int age;
    public String name;
    public String ID;
    public String gender;
    public String bodypart;
    public String date_of_birth;
    public String address;
    public String description;

    public void readfile(String file_name) throws CsvValidationException, IOException
    {

        File file = new File(file_name);
        if(file.exists())
        {  
            FileReader filereader = new FileReader(file);   
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            String[] r = csvReader.readNext();
            if (r.length == 8)
            {
                ID=r[0].toString();
                name=r[1];
                date_of_birth=r[2];
                age=Integer.parseInt(r[3]);
                gender=r[4];
                address=r[5];
                bodypart=r[6];
                description=r[7];
                }
            else
            {
                //smth
            }
        }  
    }

    public void writefile(String file_name)
    {
        File file = new File(file_name);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> list = new ArrayList<>();
            String[] header = {ID,name,date_of_birth,Integer.toString(age),gender,address,bodypart,description};
            list.add(header);
            writer.writeAll(list);

            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void teststring()
    {
        String a;
        a = address +  " \n" + description;
        System.out.println(a);
    }
    public static void maintest(String[] args) {
        patient cum = new patient();
        try {
            cum.readfile("C:\\Users\\Asus\\Desktop\\ExampleDataSet\\48452984\\Patient.csv");
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cum.teststring();

        cum.writefile("C:\\Users\\Asus\\Desktop\\ExampleDataSet\\48452984\\Patientwrite.csv");
    }
}
