package edu.ifmo.tikunov.lab3.item;

import edu.ifmo.tikunov.lab3.creature.*;
import edu.ifmo.tikunov.lab3.location.*;

public interface Item {
	void setLocation(Location newLocation);
	Location getLocation();
	void setOwner(Creature newOwner);
	Creature getOwner();
}
