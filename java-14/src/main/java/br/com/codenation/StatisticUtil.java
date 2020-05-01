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
		return 0;
	}

	public static int median(int[] elements) {
		List<Integer> elementosOrdenados = IntStream.of(elements).sorted().boxed().collect(Collectors.toList());

		if (elementosOrdenados.size() % 2 == 0) {
			return (elementosOrdenados.get((elementosOrdenados.size() / 2)) + elementosOrdenados.get((elementosOrdenados.size() / 2) - 1)) / 2;
		}
		return elementosOrdenados.get(elementosOrdenados.size() / 2);
	}

	public static void main(String[] args) {

		System.out.println(" MEDIA "+ average(new int[]{1, 2, 3, 4, 5, 6}));
		System.out.println(" MEDIANA "+ median(new int[]{1, 2, 6, 8, 10, 20, 9}));
	}
}