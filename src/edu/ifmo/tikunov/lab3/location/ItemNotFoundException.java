package edu.ifmo.tikunov.lab3.location;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.creature.*;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(String message) {
		super(message);
	}

	public ItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ItemNotFoundException(Throwable cause) {
		super(cause);
	}
}
