package codemaze.sphinx;

import java.util.function.Function;

public class Sphinx {
	private Function<String, Boolean> mPassword;
	public Sphinx(Function<String, Boolean> passwordRoutine) {
		mPassword = passwordRoutine;
	}

	public boolean tryPassword(String password) {
		return mPassword.apply(password);
	}
}
