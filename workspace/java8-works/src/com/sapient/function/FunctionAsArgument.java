package com.sapient.function;

import java.util.function.BiFunction;

// passing function as an arguments 
public class FunctionAsArgument {

	protected static class MyMath {

		// passing actual data
		public static Integer add(Integer x, Integer y) {
			return x + y;
		}

		public static Integer sub(Integer x, Integer y) {
			return x - y;
		}

		public static Integer combine2And3
		(BiFunction<Integer, Integer, Integer> combineFunction) {
			return combineFunction.apply(2, 3);
		}
	}

	public static void main(String[] args) {
		System.out.println(MyMath.combine2And3(MyMath::add));
		System.out.println(MyMath.combine2And3(MyMath::sub));
		System.out.println(MyMath.combine2And3((x, y) -> x * 2 + y* 2));
	}

}
