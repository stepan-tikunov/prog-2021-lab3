package edu.ifmo.tikunov.lab3.creature;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class NoFriendsException extends Exception {
	public NoFriendsException() {
		super();
	}

	public NoFriendsException(String message) {
		super(message);
	}

	public NoFriendsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoFriendsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoFriendsException(Throwable cause) {
		super(cause);
	}
}
