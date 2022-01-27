package edu.ifmo.tikunov.lab3.creature;

import java.util.ArrayList;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class Resident implements Creature {
	private String name;
	private Location location;
	protected ArrayList<Item> items;

	@Override
	public void getItem(Item item) {
		items.add(item);
		item.setOwner(this);
	}
	
	@Override
	public void giveItem(Item item, Creature newOwner) {
		items.remove(item);
		newOwner.getItem(item);
	}

	@Override
	public void throwItem(Item item) {
		items.remove(item);
		item.setLocation(getLocation());
	}

	@Override
	public void move(Location newLocation) {
		if (location != null) {
			location.remove(this);
		}
		location = newLocation;
		location.put(this);
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public boolean participatesInSearch(Item item) {
		System.out.println("As everybody else, " + toString() + " wants to participate in search.");
		return true;
	}

	public final String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;

		result += result * prime + name.hashCode();
		result += result * prime + items.hashCode();
		
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Resident) {
			Resident res = (Resident)o;
			return name.equals(res.name) &&
				location.equals(res.location) &&
				items.equals(res.items);
		}
		return false;
	}

	public Resident(String name, Location location) {
		items = new ArrayList<Item>();
		this.name = name;
		move(location);
	}
}
