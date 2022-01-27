package edu.ifmo.tikunov.lab3;

import edu.ifmo.tikunov.lab3.creature.*;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public abstract class SearchAnnouncement {
	private Creature loser;
	private Item lostItem;

	protected abstract void reward(Creature finder);

	public Creature whoLost() {
		return loser;
	}

	public Item getLostItem() {
		return lostItem;
	}

	public void startSearch(Valley valley) {
		System.out.println("News about the lost " + loser.toString() + "'s " + lostItem.toString() + " spread across " + valley.toString() + ".");
		Creature finder = valley.search(lostItem);
		finder.giveItem(lostItem, loser);
		System.out.println(finder.toString() + " gives the " + lostItem.toString() + " back to " + loser.toString() + "!");
		reward(finder);
	}

	@Override
	public String toString() {
		return loser.toString() + "'s " + lostItem.toString() + " search announcement";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result += result * prime + loser.hashCode();
		result += result * prime + lostItem.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof SearchAnnouncement) {
			SearchAnnouncement ann = (SearchAnnouncement)o;
			return loser.equals(ann.loser) &&
				lostItem.equals(ann.lostItem);
		}
		return false;
	}

	public SearchAnnouncement(Creature loser, Item lostItem) {
		this.loser = loser;
		this.lostItem = lostItem;
	}
}
