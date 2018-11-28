package com.school.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 递归读取文件夹的文件
 */
public class Test_01 {
	public void readFile_ZiJie(String filePath) throws IOException{
		FileInputStream fStream = new FileInputStream(new File(filePath));
		BufferedInputStream buffer = new BufferedInputStream(fStream);
		//BufferedReader read = new BufferedReader(new , sz)
		int l;
		while((l=fStream.read())!=-1){
			System.out.println((char)l);
		}
		fStream.close();
	}
	
	public void readFile_ZiFu(String filePath) throws IOException{
		//FileInputStream fStream = new FileInputStream(new File(filePath));
		//BufferedInputStream buffer = new BufferedInputStream(fStream);
		BufferedReader read = new BufferedReader(new FileReader(new File(filePath)));
		String str;
		while((str=read.readLine())!=null){
			System.out.println(str);
		}
		read.close();
	}
	public void fileList(String path){
		File[] files = new File(path).listFiles();
		if(files == null){
			System.out.println("null");
			return ;
		}
		
		for(File file:files){
			if(file.isDirectory()){
				System.out.println(file.getName()+"is Directory");
				fileList(file.getAbsolutePath());
			}else{
				System.out.println("filename:"+file.getName());
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Test_01 t = new Test_01();
		//t.fileList("D:/架构蔡子文");
		t.readFile_ZiFu("D:/架构蔡子文/小组成员及项目名.txt");
	}
}
