package com.ict11.control;

import javax.imageio.ImageIO;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;
import java.awt.Image;
import com.ict11.tools.*;



public class MRIimagelist 
{
    public List<StretchIcon> imagelist = new ArrayList<StretchIcon>();
    public boolean[] Problem;
    public int NumberofImages;

    public void readfile(String file_name) throws CsvValidationException, IOException, NumberFormatException
    {

        File file = new File(file_name);
        if(file.exists())
        {  
            FileReader filereader = new FileReader(file);   
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            String[] r = csvReader.readNext();
            NumberofImages = Integer.parseInt(r[0]);
            Problem = new boolean[NumberofImages+1];
            imagelist.add(new StretchIcon("resource\\aihoir.png"));
            //imagelist = new ShrinkIcon("resource\\aihoir.png")[NumberofImages+1];
            for (int i=1;i<=NumberofImages;i++)
            {
                Problem[i]=false;
                imagelist.add(new StretchIcon(FindFile.FindImage(i)));
                
            }
            //imagelist.add(new ShrinkIcon("resource\\aihoir.png"));
            for (int i = 1;i<r.length;i++)
            {
                try {
                    Problem[Integer.parseInt(r[i])] = true;
                } catch (NumberFormatException e) {
                    //TODO: handle exception
                }
                
            }
            
            

        }
        else
        {
            //smth
        }
    }

    public void runa()
    {
        System.out.println(NumberofImages);
        for (int i=1;i<=NumberofImages;i++)
        {
            if (Problem[i])
            {
            System.out.println(i);
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
            //String[] header = {Integer.toString(NumberofImages)};
            List<String> where = new ArrayList<String>();
            where.add(Integer.toString(NumberofImages));

            for (int i=1;i<=NumberofImages;i++)
            {
                if (Problem[i])
                {
                    where.add(Integer.toString(i));
                }
            }
            String[] header = new String[where.size()];
            where.toArray(header);
            list.add(header);
            writer.writeAll(list);

            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }   
    public static void maintest(String[] args) {
        MRIimagelist a = new MRIimagelist();
        try {
            a.readfile("C:\\Users\\Asus\\Desktop\\ExampleDataSet\\48452984\\Problem.csv");
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        a.writefile("C:\\Users\\Asus\\Desktop\\ExampleDataSet\\48452984\\ProblemWrite.csv");
    }
}

