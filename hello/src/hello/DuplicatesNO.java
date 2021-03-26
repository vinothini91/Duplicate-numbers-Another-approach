package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesNO {

	public static void main(String[] args) {

		File file = new File("F:/vino--programs-2021/duplicatenumbers.txt");
		Path path = Paths.get(file.toString());

		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {
				int values = Integer.parseInt(line);
				list.add(values);

			}
			System.out.println("list: " + list);

			Object[] objarr = list.toArray();
			int length = objarr.length;
			// System.out.println("length: " + length);

			int[] intarray = new int[length];

			System.out.print("Array Element :");
			for (int i = 0; i < length; i++) {

				intarray[i] = (int) objarr[i];
				System.out.print(intarray[i] + " ");

			}

			int[] secondarray = new int[intarray.length]; // 15

		
			for (int i = 0; i < intarray.length; i++) {

				int number = intarray[i];
				int count = 1;
				for (int j = i + 1; j < intarray.length; j++) {
					if (number == intarray[j]) {
						count++;
						secondarray[j] = -1;
					}

				}

				if (secondarray[i] != -1) {
					secondarray[i] = count;
				}

			}

			for (int i = 0; i < secondarray.length; i++) {
				if (secondarray[i] == -1) {
					System.out.println("Duplicate Element:" +intarray[i] );
					
				}
			}

			reader.close();

		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}