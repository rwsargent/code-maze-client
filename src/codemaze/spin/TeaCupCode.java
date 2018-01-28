package codemaze.spin;

import java.util.Arrays;

public class TeaCupCode {

	int[] mCode;
	public TeaCupCode() {
		
	}
	public TeaCupCode(int... code) {
		mCode = code;
	}
	public boolean isValid() {
		return Arrays.equals(mCode, new int[]{-3,13,-1,-8,5});
	}
}
