package com.mo_171_ogurnoy.simple_text_editor;

import java.io.*;
import java.util.Vector;

public class TextEditor {

    Vector<String> fileContentLine = new Vector<String>();

    boolean readFile(String filePath){


        InputStream in = null;

        try {
            in = new FileInputStream(filePath);

        } catch(FileNotFoundException e){
            System.out.println("Файл не найден!");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(in));


        String line;
        try {
            while ((line = br.readLine()) != null){
                fileContentLine.add(line);
            }
            in.close();
        } catch (IOException e){
            System.out.println("Ошибка ввода!");
        }

        return true;
    }

    boolean writeFile(String filePath){
        OutputStream out;
        try{
            out = new FileOutputStream(filePath,false);
        } catch(FileNotFoundException e){
            return false;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        int fileLineNumber = fileContentLine.size();
        try {
            for (String s:fileContentLine) {
                bw.write(s+"\r\n");
            }
            bw.flush();
        }catch (IOException e){
            return false;
        }

        fileContentLine.clear();

        return true;
    }

    boolean changeLine(String filePath,int stringNum, String newSring){
        readFile(filePath);
        fileContentLine.set(stringNum,newSring);
        writeFile(filePath);

        return true;
    }

    boolean changeWord(String filePath,int stringNum, int wordNum, String newWord){
        readFile(filePath);

        String[] words = fileContentLine.elementAt(stringNum).split(" ");
        words[wordNum] = " "+newWord+" ";
        StringBuilder builder = new StringBuilder();
        for(String w:words){
            builder.append(w);
        }
        fileContentLine.set(stringNum,builder.toString());

        writeFile(filePath);

        return true;
    }
}
