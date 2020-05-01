package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> numbersFibonacci = new ArrayList<>();
		int current = 0;
		int previous = 0;

		for (int i = 0; i < 15; i++) {
			if (i == 1) {
				current = 1;
				previous = 0;
			} else {
				current += previous;
				previous = current - previous;
			}
			numbersFibonacci.add(current);
		}
		return numbersFibonacci;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}