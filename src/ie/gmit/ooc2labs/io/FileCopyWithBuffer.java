package ie.gmit.ooc2labs.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopyWithBuffer {

	public static void main(String[] args) {
		File inFile = null;
		File outFile = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader br = null;
		String data = null;

		try {
			inFile = new File(".\\resources\\in.txt");
			outFile = new File(".\\resources\\out.txt");
			// Create File reader to get data from file.
			fileReader = new FileReader(inFile);
			br = new BufferedReader(fileReader);
			// Create File writer to send data to file.
			fileWriter = new FileWriter(outFile);
			// Read in byte from file and store it
			while ((data = br.readLine()) != null) {
				// Write out byte from program and store it out.txt
				fileWriter.write(data);
				fileWriter.write("\n");
			}
			System.out.println("Copy Complete!");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException ioe) {

					ioe.printStackTrace();
				}
			}

			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException ioe) {

					ioe.printStackTrace();
				}
			}
		}
	}
}
