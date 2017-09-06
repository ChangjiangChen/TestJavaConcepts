package com.algorithm.learn.TestJavaConcepts;

/**
 * 位运算，java数的进制相关内容<br>
 * 位运算相关的内容在平时运用不多，但在jdk源码中使用较多，所以整理一下
 * 
 * @author changjiang.chen
 *
 */
public class BitOperation {
	/**
	 * 一些规则:<br>
	 * a.正数的原码即二进制表示，高位补0；负数的原码为取绝对值的二进制，最高位补1<br>
	 * 例+7的原码为00000111；-7的原码为10000111<br>
	 * b.正数的反码与原码一致；负数的反码为除最高位符号位外，其它取反<br>
	 * 例+7的反码为00000111；-7的反码为11111000<br>
	 * c.正数的补码与原码一致；负数的补码为反码加1<br>
	 * 例+7的补码为00000111；-7的补码为11111001<br>
	 * d.java内存中使用补码形式存放负数
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
		System.out.println("与运算结果:" + (a & b));
		System.out.println("或运算结果:" + (a | b));
		System.out.println("非运算结果:" + (~(a)));
		System.out.println("异或运算结果:" + (a ^ b) + "\n\n");
	}

	/**
	 * 测试移位<br>
	 * 左移操作时将运算数的二进制码整体左移指定位数，左移之后的空位用0补充<br>
	 * 右移操作是将运算数的二进制码整体右移指定位数，右移之后的空位用符号位补充，如果是正数用0补充，负数用1补充，逻辑右移<br>
	 * 右移过程使用零扩展（zero extension),即最高位一律补0，也就是算术右移
	 */
	public void testBitTransfer() {
		System.out.println("6<<2 : " + (6 << 2));
		System.out.println("6>>2 : " + (6 >> 2));
		System.out.println("-6>>2 : " + (-6 >> 2));
		System.out.println("-6>>>2 : " + (-6 >>> 2) + "\n\n");
	}

}
