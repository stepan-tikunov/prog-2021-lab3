package edu.ifmo.tikunov.lab3.creature;

import java.util.ArrayList;
import java.util.Random;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class MummyMama extends Useless {
	public static class Friend {
		private String name;

		public String getName() {
			return name;
		}

		public void search(Item item, String where) {
			System.out.print(getName() + " was looking for the " + item.toString() + " " + where + ", ");
		}

		public Friend(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Mummy Mama's friend " + getName();
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (o instanceof Friend) {
				Friend f = (Friend)o;
				return f.name.equals(name);
			}

			return false;
		}
	}

	protected ArrayList<Friend> friends;

	@Override
	protected String whyUseless() {
		return "she and her friends already tried to find it and didn't succeed";
	}

	public void addFriends(Friend... newFriends) {
		for (Friend friend : newFriends) friends.add(friend);
	}

	public void searchWithFriends(Item item) throws NoFriendsException {
		Random rand = new Random();

		class SearchedArea {
			private String name;
			private String[] entities;

			public void startSearching() {
				System.out.print("Mummy Mama's friends tried to find the " + item.toString() + " in " + name + ", ");

				for (String entity : entities) {
					int friendIndex = rand.nextInt(friends.size());
					friends.get(friendIndex).search(item, entity);
				}

				System.out.print("but they didn't find anything.\n");
			}

			public SearchedArea(String name, String... entities) {
				this.name = name;
				this.entities = entities;
			}
		}
		System.out.println("Mummy Mama asked her friends for help to find " + item.toString() + ".");

		if (friends.size() == 0) throw new NoFriendsException("But then she realized she didn't have any friends....");

		SearchedArea[] areas = new SearchedArea[] {
			new SearchedArea("the house", "under carpets", "under beds", "in the furnace", "in the vault", "in the attic", "on the roof"),
			new SearchedArea("the garden"),
			new SearchedArea("the woodshed"),
			new SearchedArea("the coast")
		};

		for (SearchedArea area : areas) {
			area.startSearching();
		}
	}

	public MummyMama(Location location) {
		super("Mummy Mama", location);
		friends = new ArrayList<Friend>();
	}
}
