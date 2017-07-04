package com.iotek.until;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IoUntils {
	/**
	 *
	 * @param path
	 * @param fis
	 * @param ois
	 * @return
	 */
	public static ObjectInputStream load(String path,FileInputStream fis,ObjectInputStream ois){
		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
		} catch (Exception e) {
			/*e.printStackTrace();*/
		} 
		return ois;
	}

	/**
	 *
	 * @param path
	 * @param fos
	 * @param oos
	 * @return
	 */
	public static ObjectOutputStream save(String path,	FileOutputStream fos,
										  ObjectOutputStream oos){
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return oos;
	}

	/**
	 *
	 * @param fis
	 * @param ois
	 * @param fos
	 * @param oos
	 */
	public static  void closeAll(FileInputStream fis,ObjectInputStream ois
			,FileOutputStream fos,ObjectOutputStream oos){
		try {
			if(ois != null)
				ois.close();
			if(fis != null)
				fis.close();
			if(oos != null)
				oos.close();
			if(fos != null)
				fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
