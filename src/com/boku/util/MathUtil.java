package com.boku.util;

import java.text.DecimalFormat;

public class MathUtil
{

	/** Rounds off a double value to the nearest 0.05 */
	public static float roundoff(double value, double significance)
	{
		return (float) (Math.ceil(value / significance) * significance);
	}

	public static double truncate(double value)
	{
		String result = new DecimalFormat("0.00").format(value);
		return Double.parseDouble(result);
	}

}
