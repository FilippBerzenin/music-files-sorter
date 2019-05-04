package music_sortere;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.extern.java.Log;

@Log
public class App {

	public static void main(String[] args) {
		File[] filesList;
		File filesPath = new java.io.File("C:\\Users\\Fylyp\\Music\\chldren\\"); // создаем объект на папку с файлами
		filesList = filesPath.listFiles(); // записываем файлы из папки в массив объектов типа File
		log.info("Total files: "+Integer.toString(filesList.length));
		addIndexForFilesName(filesList);
//		RandomIntFromIntArray(filesList.length);
	}

	public static void addIndexForFilesName(File[] filesList) {
		Integer[] indexes = RandomIntFromIntArray(filesList.length);		
		for (int i = 0; i < filesList.length; i++) {
			String buf = filesList[i].getName();
				log.info("Find file with name - " + buf);
				buf = indexes[i]+"_"+ buf;
				filesList[i].renameTo(new File("C:\\Users\\Fylyp\\Music\\chldren\\new_music\\" + buf));
				log.info(buf);
		}
	}
	
	public static Integer[] RandomIntFromIntArray(int arraysLingth) {
		Integer[] indexes = new Integer[arraysLingth];		
		for (int i = 0; i<arraysLingth; i++) {
			indexes[i] = i+1;
			log.info(Integer.toString(indexes[i]));
		}
		List<Integer> list = Arrays.asList(indexes);
		Collections.shuffle(list);
		indexes = list.toArray(indexes);
		return indexes;
	}

	public void findFilesWithEqualsLength(File[] filesList) {
		for (int i = 0; i < filesList.length; i++) {
			for (int k = i + 1; k < filesList.length; k++) {
				if (filesList[i].length() == filesList[k].length()) {
					log.info(filesList[i].getName());
					log.info(filesList[k].getName());
				}
			}
		}
	}
}
