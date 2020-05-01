package br.com.codenation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) IntStream.
							of(elements)
							.average()
							.orElseThrow(IllegalArgumentException::new);
	}

	public static int mode(int[] elements) {
		int maxValue = 0, maxCount = 0, i, j;

		for (i = 0; i < elements.length; ++i) {
			int count = 0;
			for (j = 0; j < elements.length; ++j) {
				if (elements[j] == elements[i]) {
					++count;
				}
			}

			if (count > maxCount) {
				maxCount = count;
				maxValue = elements[i];
			}
		}
		return maxValue;
	}

	public static int median(int[] elements) {
		List<Integer> elementosOrdenados = IntStream.of(elements).sorted().boxed().collect(Collectors.toList());

		if (elementosOrdenados.size() % 2 == 0) {
			return (elementosOrdenados.get((elementosOrdenados.size() / 2)) + elementosOrdenados.get((elementosOrdenados.size() / 2) - 1)) / 2;
		}
		return elementosOrdenados.get(elementosOrdenados.size() / 2);
	}
}