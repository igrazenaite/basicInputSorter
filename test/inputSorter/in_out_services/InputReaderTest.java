package inputSorter.in_out_services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import inputSorter.in_out_services.InputReader;

public class InputReaderTest {

	@Test
	public void inputReaderReadsFileAndPutsDataToList() {
		InputReader reader = new InputReader();
		List<String> expectedData= new ArrayList<>();
		List<String> data = new ArrayList<>();
		expectedData.add("-2.2	2	3	4	329	2");
		expectedData.add("2.2	12345q	69	-afg");
		expectedData.add("-2.2	12345q	69	-asdf");
		
		data=reader.readTheInputFile("test/inputTest.txt"); 
		
		assertEquals(expectedData, data);

	}

}
