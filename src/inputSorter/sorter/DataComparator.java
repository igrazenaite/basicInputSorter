package inputSorter.sorter;

import java.util.Comparator;

public class DataComparator implements Comparator<String[]> {

	@Override
	public int compare(String[] str1, String[] str2) {
		int result = 0;
		int i = 0;
		String regexExp = "-?\\d+(.\\d+)?";
		String nonNumExp = "-?[A-Za-z]+";

		boolean elementIsNumber1 = false;
		boolean elementIsNumber2 = false;
		boolean elementIsString1 = false;
		boolean elementIsString2 = false;
		boolean elementIsStringWithNumber1 = false;
		boolean elementIsStringWithNumber2 = false;
		float s1float = 0;
		float s2float = 0;
		String tempStr1 = "";
		String tempStr2 = "";
		float numberFromString1 = 0;
		float numberFromString2 = 0;

		while ((i < str1.length) && (i < str2.length) && (result == 0)) {

			String tempNumStr = "";
			if (str1[i].matches(regexExp)) {
				s1float = Float.parseFloat(str1[i]);
				elementIsNumber1 = true;
			} else if (str1[i].matches(nonNumExp)) {
				elementIsString1 = true;
			} else {
				elementIsStringWithNumber1 = true;
				tempNumStr = str1[i].replaceAll(nonNumExp, "");
				tempStr1 = str1[i].replaceAll(regexExp, "");

				if (!tempNumStr.isEmpty()) {
					numberFromString1 = Float.parseFloat(tempNumStr);
				}
			}

			if (str2[i].matches(regexExp)) {
				s2float = Float.parseFloat(str2[i]);
				elementIsNumber2 = true;
			} else if (str2[i].matches(nonNumExp)) {
				elementIsString2 = true;
			} else {
				elementIsStringWithNumber2 = true;
				tempNumStr = str2[i].replaceAll(nonNumExp, "");
				tempStr2 = str2[i].replaceAll(regexExp, "");

				if (!tempNumStr.isEmpty()) {
					numberFromString2 = Float.parseFloat(tempNumStr);
				}
			}

			result = sortTwoNumbers(result, s1float, s2float, elementIsNumber1, elementIsNumber2);

			result = sortNumberAndStringWithNumber(result, elementIsNumber1, elementIsNumber2,
					elementIsStringWithNumber1, elementIsStringWithNumber2, str1, str2, i);

			result = sortNumberAndString(result, str1, str2, i, elementIsString1, elementIsString2, elementIsNumber1,
					elementIsNumber2);

			result = sortTwoStringsWithNumbers(str1, str2, result, i, elementIsStringWithNumber1,
					elementIsStringWithNumber2, tempStr1, tempStr2, numberFromString1, numberFromString2);

			result = sortStringAndStringWithNumber(result, str1, str2, i, elementIsString1, elementIsString2,
					elementIsStringWithNumber1, elementIsStringWithNumber2);

			sortTwoStrings(str1, str2, i, elementIsString1, elementIsString2);

			i++;
		}
		return result;
	}

	private int sortStringAndStringWithNumber(int result, String[] str1, String[] str2, int i, boolean elementIsString1,
			boolean elementIsString2, boolean elementIsStringWithNumber1, boolean elementIsStringWithNumber2) {

		if ((elementIsString1 == true) && (elementIsStringWithNumber2 == true)) {
			result = 1;
		}
		if ((elementIsString2 == true) && (elementIsStringWithNumber1 == true)) {
			result = -1;
		}
		return result;
	}

	private int sortNumberAndStringWithNumber(int result, boolean elementIsNumber1, boolean elementIsNumber2,
			boolean elementIsStringWithNumber1, boolean elementIsStringWithNumber2, String[] str1, String[] str2,
			int i) {

		if ((elementIsNumber1) && (elementIsStringWithNumber2)) {
			result = -1;
		}
		if ((elementIsStringWithNumber1) && (elementIsNumber2)) {
			result = 1;
		}
		return result;
	}

	private int sortTwoStringsWithNumbers(String[] str1, String[] str2, int result, int i,
			boolean elementIsStringWithNumber1, boolean elementIsStringWithNumber2, String tempStr1, String tempStr2,
			float numberFromString1, float numberFromString2) {

		if ((elementIsStringWithNumber1) && (elementIsStringWithNumber2)) {
			if (tempStr1.equals(tempStr2)) {
				if (numberFromString1 > numberFromString2) {
					result = 1;
				} else if (numberFromString2 > numberFromString1) {
					result = -1;
				} else {
					result = 0;
				}
			} else {
				result = tempStr1.compareTo(tempStr2);
			}
		}
		return result;
	}

	private void sortTwoStrings(String[] str1, String[] str2, int i, boolean elementIsString1,
			boolean elementIsString2) {
		if (elementIsString1 && elementIsString2) {
			str1[i].compareTo(str2[i]);
		}
	}

	private int sortNumberAndString(int result, String[] str1, String[] str2, int i, boolean elementIsString1,
			boolean elementIsString2, boolean elementIsNumber1, boolean elementIsNumber2) {
		if (elementIsString1 && elementIsNumber2) {
			result = 1;
		}
		if (elementIsNumber1 && elementIsString2) {
			result = -1;
		}
		return result;
	}

	private int sortTwoNumbers(int result, float s1float, float s2float, boolean elementIsNumber1,
			boolean elementIsNumber2) {
		if ((elementIsNumber1) && (elementIsNumber2)) {
			if ((s1float > s2float)) {
				result = 1;
			} else if (s1float < s2float) {
				result = -1;
			}
		}
		return result;
	}
}
