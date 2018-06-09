package inputSorter.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inputSorter.in_out_services.InputReader;
import inputSorter.in_out_services.OutputWriter;
import inputSorter.sorter.DataSorter;

public class InputSorterApp {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		List<String> input = new ArrayList<>();
		input = reader.readTheInputFile("Input.txt");

		List<String> data = new ArrayList<>();
		DataSorter sorter = new DataSorter();
		data.addAll(sorter.sortData(input));

		OutputWriter writer = new OutputWriter();
		writer.writeToFile("Output.txt", data);
	}

}
