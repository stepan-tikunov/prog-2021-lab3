package edu.ifmo.tikunov.lab3.creature;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public abstract class Useless extends Resident {
	abstract protected String whyUseless();

	@Override
	public boolean participatesInSearch(Item item) {
		System.out.println(toString() + " was one of the only residents who stayed home, because " + whyUseless() + ".");
		return false;
	}

	public Useless(String name, Location location) {
		super(name, location);
	}
}
