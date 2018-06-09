package inputSorter.sorter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DataSorterTest {

	@Test
	public void dataSorterDoesNaturalSorting() {
		List<String> input = new ArrayList<>();
		input.add("-1	g	87");
		input.add("-2.2	2	3	4	329	2");
		input.add("2.2	12345q	69	-afg");
		input.add("-2.2	12345q	69	-asdf");
		DataSorter sorter = new DataSorter();
		List<String> sortedData = new ArrayList<>();
		sortedData.add("-2.2	2	3	4	329	2");
		sortedData.add("-2.2	12345q	69	-asdf");
		sortedData.add("-1	g	87");
		sortedData.add("2.2	12345q	69	-afg");
		List<String> output = new ArrayList<>();

		output = sorter.sortData(input);

		assertEquals(sortedData, output);

	}
}
