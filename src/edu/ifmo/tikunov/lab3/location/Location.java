package edu.ifmo.tikunov.lab3.location;

import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.creature.*;

public interface Location {
	void put(Creature... creature);
	void put(Item... item);
	void remove(Creature creature);
	void remove(Item item);
	Creature search(Item item);
}
