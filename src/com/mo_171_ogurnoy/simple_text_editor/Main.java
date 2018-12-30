package com.mo_171_ogurnoy.simple_text_editor;

public class Main {

    public static void main(String[] args) {

	    String filePath = "C:\\Users\\User\\Desktop\\testFolder\\testFile.txt";
	    TextEditor te = new TextEditor();
		te.changeLine(filePath,0,"Изменённая Строка 1");
	    te.changeWord(filePath,2,1,"Изменённая слово 2");
    }
}
