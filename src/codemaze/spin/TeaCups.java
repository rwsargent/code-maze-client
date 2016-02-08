package codemaze.spin;

import java.util.function.Supplier;

public class TeaCups {
	private Supplier<TeaCupCode> mSpinner;
	public TeaCups(Supplier<TeaCupCode> spinner ) {
		mSpinner = spinner;
	}
	
	public TeaCupCode getCode() {
		return mSpinner.get();
	}
}
