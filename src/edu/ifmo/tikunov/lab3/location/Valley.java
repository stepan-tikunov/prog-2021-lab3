package edu.ifmo.tikunov.lab3.location;

import java.util.ArrayList;
import java.util.Random;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.creature.*;

public class Valley implements Location {
	protected ArrayList<Place> places;

	@Override
	public void put(Creature... residents) {
		for (Creature resident : residents) {
			Random rand = new Random();

			int randomPlaceIndex = rand.nextInt(places.size());
			Place randomPlace = places.get(randomPlaceIndex);

			randomPlace.put(resident);
		}
	}

	@Override
	public void put(Item... items) {
		for (Item item : items) {
			Random rand = new Random();

			int randomPlaceIndex = rand.nextInt(places.size());
			Place randomPlace = places.get(randomPlaceIndex);

			randomPlace.put(item);
		}
	}

	@Override
	public void remove(Creature resident) {
		for (Place place : places) {
			place.remove(resident);
		}
	}

	@Override
	public void remove(Item item) {
		for (Place place : places) {
			place.remove(item);
		}
	}

	@Override
	public Creature search(Item item) {
		for (Place place : places) {
			System.out.println("News about the lost " + item.toString() + " reached " + place.toString() + ".");
			try {
				Creature finder = place.search(item);
				return finder;
			} catch (ItemNotFoundException e) {
				System.out.println(e);
			}
		}
		throw new ItemNotFoundException("It seems that the " + item.toString() + " has never existed, why is someone searching it?..");
	}

	public void addPlaces(Place... places) {
		for (Place place : places) {
			this.places.add(place);
		}
	}

	@Override
	public String toString() {
		return "the valley";
	}

	@Override
	public int hashCode() {
		return places.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Valley) {
			Valley val = (Valley)o;
			return places.equals(val.places);
		}
		return false;
	}

	public Valley() {
		places = new ArrayList<Place>();
	}
}
