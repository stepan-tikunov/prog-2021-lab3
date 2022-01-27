package edu.ifmo.tikunov.lab3.creature;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public interface Creature {
	void getItem(Item item);
	void giveItem(Item item, Creature newOwner);
	void throwItem(Item item);
	void move(Location newLocation);
	Location getLocation();
	boolean participatesInSearch(Item lostItem);
}
