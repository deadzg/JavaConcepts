package com.smalwe.streams;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test class to understand basic serialization
 * 
 * @author soumalwe
 *
 */

public class TestSerializable {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		Car c1 = new Car("orange", "BMW", 2, true);
		Car c2 = new Car("black", "BMW", 2, true);
		
		
		/** Opening file output stream (sink stream data to file) in append mode false */
		FileOutputStream fs = new FileOutputStream("testfile.txt");
		
		/** Pass true if you want to open file output stream in append mode */
		//FileOutputStream fs = new FileOutputStream("testfile.txt", true);
		
		/** 
		 * Creating ObjectOutputStream to write object to filestream
		 *  
		 * Note: ObjectOutputStream writes only serializable objects
		 * */
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(c2);
		os.writeObject(c1);
		
		/** Always make sure the stream is flushed */
		os.flush();
		
		/** Always make sure the stream is closed to avoid memory leaks */
		os.close();
		
		/** Opening file input stream ie. source of data will be the file */
		FileInputStream fi = new FileInputStream("testfile.txt");
		
		/** ObjectInputStream for reading the objects from file */
		ObjectInputStream ois = new ObjectInputStream(fi);
		
		List<Car> carsList = new ArrayList<Car>();
		
		/** Reading multiple objects from the file */
		try {
			while(true) {
				carsList.add((Car)ois.readObject());
			}
		} catch (EOFException eof) {
			System.out.println("End of stream");
		} finally {
			/** Closing the stream to avoid memory leaks */
			ois.close();
		}
		
		/** Iterating the carList object */
		Iterator<Car> carIt = carsList.iterator();
		while(carIt.hasNext()) {
			System.out.println(carIt.next());
		}
	}
}
