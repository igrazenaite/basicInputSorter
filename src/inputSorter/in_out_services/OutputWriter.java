package inputSorter.in_out_services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import inputSorter.sorter.DataSorter;

public class OutputWriter {

	public void writeToFile(String filePath, List<String> output) {
		try {
			Files.write(Paths.get(filePath), output);
		} catch (IOException ex) {
			ex.getMessage();
		}
		System.out.println("");
		System.out.println("====sorted output====");
		output.forEach(System.out::println);
	}

}
