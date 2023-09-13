package com.example.demo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class DemoApplicationTests {

	Calculator underTest = new Calculator();
	@Test
	void addNumbers() {
		int result = underTest.add(20,30);
		assertThat(result).isEqualTo(30 + 20);
	}

	static class Calculator{
		int add(int a, int b) {
			return a + b;
		}
	}
}
