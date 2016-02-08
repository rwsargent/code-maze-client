package codemaze.spin;

public class TeaCupCode {

	int[] mCode;
	public TeaCupCode() {
		
	}
	public TeaCupCode(int... code) {
		mCode = code;
	}
	public boolean isValid() {
		return true;
//		return Arrays.equals(mCode, new int[]{1,2,3,4,5});
	}
}
