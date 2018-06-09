package inputSorter.in_out_services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

	private List<String> input;

	public List<String> readTheInputFile(String filePath) {
		Stream<String> streamReader = null;
		try {
			streamReader = (Files.lines(Paths.get(filePath)));
			input = streamReader.map(list -> list).collect(Collectors.toList());
		} catch (IOException ex) {
			ex.getMessage();
		}
		streamReader.close();
		System.out.println("======input=====");
		input.forEach(System.out::println);
		return input;
	}

}
