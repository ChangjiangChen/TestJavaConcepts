package com.algorithm.learn.TestJavaConcepts.concepts;

public class StringTest {
	public void testString() {
		String a = "a1";
		String b = "a" + 1;
		System.out.println(a == b);

		String a1 = "a1";
		String bb = "1";
		String b1 = "a" + bb;
		System.out.println(a1 == b1);

		String a2 = "a1";
		final String bb2 = "1";
		String b2 = "a" + bb2;
		System.out.println(a2 == b2);

		String a3 = "a1";
		final String bb3 = getBB();
		String b3 = "a" + bb3;
		System.out.println(a3 == b3);

		String a4 = "ab";
		String a41 = "a";
		String b41 = "b";
		String b4 = a41 + b41;
		System.out.println((a4 == b4) + "," + (a4 == b4.intern()));
	}

	public static String getBB() {
		return "1";
	}

	public static void main(String[] args) {
		new StringTest().testString();
	}
}
