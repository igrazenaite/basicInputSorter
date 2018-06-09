package inputSorter.in_out_services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

import inputSorter.in_out_services.InputReader;
import inputSorter.in_out_services.OutputWriter;

public class outputWriterTest {

	@Test
	public void outputIsWrittenToFile() throws IOException {
		OutputWriter writer = new OutputWriter();
		List<String> outputData = new ArrayList<>();
		outputData.add("2.2	12345q	69	-afg");
		outputData.add("-2.2	2	3	4	329	2");
		outputData.add("sdd	23");
		InputReader reader = new InputReader();
		List<String> dataReturned = new ArrayList<>();

		writer.writeToFile("test/outputTest.txt", outputData);
		dataReturned = reader.readTheInputFile("test/outputTest.txt");

		assertEquals(outputData, dataReturned);

	}

}
