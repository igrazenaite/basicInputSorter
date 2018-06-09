package inputSorter.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import inputSorter.in_out_services.InputReader;

public class DataSorter {

	public List<String> sortData(List<String> input) {

		List<String[]> singleLineList = input.stream().map(s -> s.split("[\t]")).collect(Collectors.toList());

		String[] singleLineArray;
		List<String> output = new ArrayList<>();

		Collections.sort(singleLineList, new DataComparator());

		for (int i = 0; i < singleLineList.size(); i++) {
			singleLineArray = singleLineList.get(i);
			prepareStringForWritingToFile(singleLineArray, output);
		}
		return output;
	}

	private void prepareStringForWritingToFile(String[] singleLineArray, List<String> output) {
		String stream = "";
		String line = "";
		for (int l = 0; l < singleLineArray.length; l++) {
			line = line.concat(singleLineArray[l].toString().concat("\t"));
			stream = line;
		}
		output.add(stream.toString().trim());
		line = "";
	}
}
