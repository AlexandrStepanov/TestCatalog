package test.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloApplication {
    public static String NameFolder;
    public static void RecCat(String Path, int Folders, int t , String FolderName, int end)
    {
        List<String> CatalogList = new ArrayList<String>();
        List<String> FilesList = new ArrayList<String>();
        File dir = new File(Path);
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){
                if(item.isDirectory()) CatalogList.add(item.getName());
                else FilesList.add(item.getName());
            }
        }
        Collections.sort(CatalogList);
        Collections.sort(FilesList);
        for (int i = 0; i < t; i++)
            if (i==0) System.out.print(" \t\t");
            else System.out.print("|\t\t");
        if(FolderName.equals(NameFolder)== true) System.out.println(" \t\t"+FolderName);
            else
                if(end!=1) System.out.println("├--"+FolderName);
                else System.out.println("└--"+FolderName);
        for(String s: CatalogList)
            if (s.equals(CatalogList.get(CatalogList.size()-1))) RecCat(Path+"\\"+s,Folders,t+1,s,1);
            else RecCat(Path+"\\"+s,Folders,t+1,s,0);
        if(Folders==-1)
            for(String s: FilesList) {
                for (int i = 0; i < t; i++)
                    if(i==0) System.out.print(" \t\t");
                    else System.out.print("|\t\t");
                if(FolderName.equals(NameFolder)== true && s.equals(FilesList.get(FilesList.size()-1))) System.out.println(" \t\t└--" + s);
                else
                    if(s.equals(FilesList.get(FilesList.size()-1))) System.out.println("|\t\t└--" + s);
                    else
                        if(t==0)System.out.println(" \t\t├--" + s);
                        else System.out.println("|\t\t├--" + s);
            }
    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader Catalog = new BufferedReader(inputStreamReader);
        NameFolder = Catalog.readLine();
        int OnlyFolders = NameFolder.lastIndexOf("-d");
        if(OnlyFolders!=-1)
            NameFolder = NameFolder.substring(0,OnlyFolders-1);
        RecCat("D:\\Download\\"+NameFolder, OnlyFolders,0, NameFolder,0);
    }
}