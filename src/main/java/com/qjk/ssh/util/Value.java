package com.qjk.ssh.util;

import com.qjk.ssh.exception.NullException;

public final class Value {

	private Value() {

	}

	public static boolean nullValueValidate(String... args)
			throws NullException {

		if (args.length == 0) {
			return false;
		}
		if (args.length % 2 != 0) {
			return false;
		}

		for (int i = 0; i < args.length; i += 2) {

			nullValueValidate(args[i], args[i + 1]);
		}

		return true;

	}

	public static void nullValueValidate(String title, String data)
			throws NullException {

		if (data == null) {
			throw new NullException(title + " ֵΪ��");
		}

	}

	public static long longValueOf(String data, long defaultValue) {
		if (data == null) {

			return defaultValue;
		}

		try {
			long value = Long.parseLong(data);

			return value;
		} catch (NumberFormatException e) {

			return defaultValue;
		}
	}
	
	public static double doubleValueOf(String data, double defaultValue){
		if (data == null) {

			return defaultValue;
		}

		try {
			double value = Double.parseDouble(data);

			return value;
		} catch (NumberFormatException e) {

			return defaultValue;
		}
		
	}

	public static int intValueOf(String data, int defaultValue) {
		if (data == null) {

			return defaultValue;
		}

		try {
			int value = Integer.parseInt(data);

			return value;
		} catch (NumberFormatException e) {

			return defaultValue;
		}
	}

	public static boolean isEmpty(String data) {
		if (data == null) {

			return true;
		}

		if ("".equals(data)) {

			return true;
		}

		return false;
	}

}
