package com.sapient.optional;

import java.util.Optional;

public class OptionalEx01 {
	public static void main(String[] args) {
		String[] message = new String[10];
		message[5] = "Optional Value";

		Optional<Object> empty = Optional.empty();
		System.out.println(empty);

		Optional<String> oValue = Optional.of(message[5]);

		System.out.println(oValue.filter((s) -> s.equals("Optional Value")));
		System.out.println("Value Got is : " + oValue.get());
		System.out.println("oValue -> Stored @ " + oValue.hashCode());
		System.out.println("empty -> Stored @ " + empty.hashCode());

		System.out.println("Is Value Present - oValue : " + oValue.isPresent());
		System.out.println("Is Value Present - empty : " + empty.isPresent());

		System.out.println("Nullable Optional : "+Optional.ofNullable(message[5]));

		System.out.println("oValue -> orElse :" + oValue.orElse("Value Not Present"));
		System.out.println("empty -> orElse :" + empty.orElse("Value Not Present"));
		
	}
}
