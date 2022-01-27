package edu.ifmo.tikunov.lab3.creature;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class Sick extends Useless {
	@Override
	protected String whyUseless() {
		return "they're sick";
	}

	public Sick(String name, Location location) {
		super(name, location);
	}
}
