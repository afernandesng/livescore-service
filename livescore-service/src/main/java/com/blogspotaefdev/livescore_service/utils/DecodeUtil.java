package com.blogspotaefdev.livescore_service.utils;

public class DecodeUtil {

	public static int x(String str) {
		int j = Integer.parseInt(str.substring(17, 18));
		int k = Integer.parseInt(str.substring(18, 19));
		int m = Integer.parseInt(str.substring(11, 12));
		int n = m
				+ (Integer.parseInt(str.substring(0, 1))
						+ Integer.parseInt(str.substring(1, 2))
						+ Integer.parseInt(str.substring(2, 3))
						+ Integer.parseInt(str.substring(3, 4))
						+ Integer.parseInt(str.substring(5, 6))
						+ Integer.parseInt(str.substring(6, 7))
						+ Integer.parseInt(str.substring(8, 9)) + Integer
							.parseInt(str.substring(9, 10)))
				+ Integer.parseInt(str.substring(12, 13))
				+ Integer.parseInt(str.substring(14, 15));
		int i1 = Integer.parseInt(str.substring(15, 16));
		int i2 = k + (j + (n + i1));
		return k + i2 - j;
	}

	public static String decode(String str) {
		StringBuffer buffer = new StringBuffer(str.length());

		final int x = x(str.replaceFirst("Query-Expiry: ", ""));
		
		final int i = str.length();
		int j = i;
		int k, m;

		do {
			k = str.charAt(j - 1);
			m = (1 + (i - j)) % 10;
			if ((k >= 40) && (k <= 126)) {
				if (k - x - m < 40) {
					buffer.append(Character
							.toString((char) (87 + (k - x - m))));
				} else {
					buffer.append(Character.toString((char) (k - x - m)));
				}
			} else if (k == 33) {
				buffer.append(Character.toString('\n'));
			} else if (k == 36) {
				buffer.append(Character.toString('\r'));
			} else if (k == 37) {
				buffer.append(Character.toString(' '));
			} else {
				buffer.append(str.substring(j - 1, j));
			}

			j--;
		} while (j > 0);
		return buffer.toString();
	}
}
