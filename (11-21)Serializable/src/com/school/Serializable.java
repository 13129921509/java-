package com.school;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serializablePersonTager();
		//deserializablePersonTager();
	}

	private static void deserializablePersonTager() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO �Զ����ɵķ������
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("d:/person.txt")));
		PersonTager personTager = (PersonTager) inputStream.readObject();
		System.out.println(personTager);
	}

	private static void serializablePersonTager() throws FileNotFoundException, IOException {
		// TODO �Զ����ɵķ������
		PersonTager personTager = new PersonTager();
		personTager.setCar("bwm");
		personTager.setName("cai");
		personTager.setSex("men");
		
		
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("d:/person.txt")));
		outputStream.writeObject(personTager);
		System.out.println("���л��ɹ�");
		outputStream.close();
	}
}
