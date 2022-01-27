package edu.ifmo.tikunov.lab3.location;

import java.util.ArrayList;
import java.util.Random;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.creature.*;

public class Place implements Location {
	private Type type;

	protected ArrayList<Item> items;
	protected ArrayList<Creature> residents;

	static public enum Type {
		WOODS("the woods"), MOUNTAINS("the mountains"), COAST("the coast");

		private String name;

		private Type(String name) {
			this.name = name;
		}

		@Override
		public String toString() { return name; }
	}

	@Override
	public void put(Creature... residents) {
		for (Creature resident : residents) {
			this.residents.add(resident);
		}
	}

	@Override
	public void put(Item... items) {
		for (Item item : items) {
			item.setLocation(this);
			this.items.add(item);
		}
	}

	@Override
	public void remove(Creature resident) {
		residents.remove(resident);
	}

	@Override
	public void remove(Item item) {
		items.remove(item);
	}

	@Override
	public Creature search(Item item) {
		ArrayList<Creature> participants = new ArrayList<Creature>();
		for (Creature resident : residents) {
			if (resident.participatesInSearch(item)) {
				participants.add(resident);
			}
		}
		
		if (!item.getLocation().equals(this))
			throw new ItemNotFoundException("Unfortunately, the " + item.toString() + " wasn't in " + toString() + ".");

		Random rand = new Random();
		int finderIndex = rand.nextInt(participants.size());

		Creature finder = participants.get(finderIndex);

		System.out.println(finder.toString() + " found the " + item.toString() + "!");

		finder.getItem(item);

		return finder;
	}

	public final Type getType() { return type; }

	@Override
	public String toString() {
		return this.getType().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result += result * prime + type.name.hashCode();
		result += result * prime + items.hashCode();
		result += result * prime + residents.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Place) {
			Place pl = (Place)o;
			return type.equals(pl.type) &&
				items.equals(pl.items) &&
				residents.equals(pl.residents);
		}
		return false;
	}

	public Place(Type type) {
		this.type = type;

		items = new ArrayList<Item>();
		residents = new ArrayList<Creature>();
	}
}
