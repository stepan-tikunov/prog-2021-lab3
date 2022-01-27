package edu.ifmo.tikunov.lab3.creature;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class Old extends Useless {
	@Override
	protected String whyUseless() {
		return "they're too old";
	}

	public Old(String name, Location location) {
		super(name, location);
	}
}
