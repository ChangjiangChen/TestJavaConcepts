package com.algorithm.learn.TestJavaConcepts;

/**
 * 位运算，java数的进制相关内容
 * 
 * @author changjiang.chen
 *
 */
public class BitOperation {
	/**
	 * 测试一些类型的位信息
	 */
	public void testBitValue() {
		/**
		 * value of int
		 */
		System.out.println("=========max value of int============");
		System.out.println((1 << 31) - 1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println("=========min value of int============");
		System.out.println(Integer.MIN_VALUE);
		System.out.println("=========size of bit for int============");
		System.out.println(Integer.SIZE + "\n\n");

		/**
		 * value of long
		 */
		System.out.println("=========max value of long============");
		System.out.println((1L << 63) - 1);
		System.out.println(Long.MAX_VALUE);
		System.out.println("=========min value of long============");
		System.out.println(Long.MIN_VALUE);
		System.out.println("=========size of bit for long============");
		System.out.println(Long.SIZE + "\n\n");
		/**
		 * value of byte
		 */
		System.out.println("=========max value if byte=========");
		System.out.println((1 << 7) - 1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println("=========min value of byte=========");
		System.out.println(Byte.MIN_VALUE);
		System.out.println("=========size of bit for byte=========");
		System.out.println(Byte.SIZE + "\n\n");
		/**
		 * value of short
		 */
		System.out.println("=========max value of short=========");
		System.out.println((1 << 15) - 1);
		System.out.println(Short.MAX_VALUE);
		System.out.println("=========min value of short=========");
		System.out.println(Short.MIN_VALUE);
		System.out.println("=========size of bit for short=========");
		System.out.println(Short.SIZE + "\n\n");
	}

	/**
	 * 测试位运算
	 */
	public void testBitOperation() {
		int a = 128;
		int b = 129;
		System.out.println("a:" + a + " b:" + b);
		System.out.println("与运算:" + (a & b));
		System.out.println("或运算:" + (a | b));
		System.out.println("非运算:" + (~(a)));
		System.out.println("异或运算:" + (a ^ b));
	}
}
