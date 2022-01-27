package edu.ifmo.tikunov.lab3;

import edu.ifmo.tikunov.lab3.creature.*;
import edu.ifmo.tikunov.lab3.item.*;
import edu.ifmo.tikunov.lab3.location.*;

public class Main {
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    * Розыски  продолжились  с  удвоенной   силой.  Обшарили *
	* весь дом. Заглядывали под  ковры  и кровати, в печь и  *
	* в погреб, забирались на  чердак  и на крышу. Обыскали  *
	* весь сад, дровяной сарай и берег реки. Сумки не  было. *
    * – Дадим объявление, – сказал Снорк.				     *
	* Сказано – сделано. Тотчас вышла газета с сенсационными *
	* новостями на первой полосе.                            *
	* "ПРОПАЛА СУМКА МУМИ-МАМЫ!  Никаких путеводных   нитей! *
    * Розыски   продолжаются.   Неслыханное   пиршество    в *
    * вознаграждение   за  находку!"  Как  только    новость *
    * облетела долину,  по   всему  лесу,  на  горах   и  на *
    * морском   побережье   поднялась    страшная   беготня. *
    * Даже последняя лесная крыса  и  та сочла небезвыгодным *
    * принять  участие   в   поисках.  Дома  остались   лишь *
    * старые   да    недужные,   и   вся  долина  огласилась *
    * криками и топотом ног.                                 *
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	public static void main(String... args) {
		Valley valley = new Valley();

		Place woods = new Place(Place.Type.WOODS);
		Place mountains = new Place(Place.Type.MOUNTAINS);
		Place coast = new Place(Place.Type.COAST);

		valley.addPlaces(woods, mountains, coast);

		Resident vanya = new Resident("Vanya from the woods", woods);
		Old granny = new Old("Granny from the woods", woods);
		Rat woodsRat = new Rat("from the woods", woods);
		Resident vova = new Resident("Vova from the mountains", mountains);
		Resident dima = new Resident("Dima from the mountains", mountains);
		Sick grisha = new Sick("Grisha from the mountains", mountains);
		Resident sasha = new Resident("Sasha from the coast", coast);

		MummyMama mummyMama = new MummyMama(coast);
		MummyMama.Friend sniff = new MummyMama.Friend("Sniff");
		MummyMama.Friend snork = new MummyMama.Friend("Snork");
		mummyMama.addFriends(sniff, snork);

		Bag bag = new Bag("bag", valley, mummyMama);
		valley.put(bag);

		System.out.println("When Mummy Mama was in " + bag.getLocation().toString() + ", she lost her bag and now she doesn't know where to find it.");

		try {
			mummyMama.searchWithFriends(bag);
		} catch (NoFriendsException e) {
			System.out.println(e.getMessage());
		}

		SearchAnnouncement announcement = new SearchAnnouncement(mummyMama, bag) {
				@Override
				protected void reward(Creature finder) {
					System.out.println(finder.toString() + " is rewarded with incredible feast!");
				}
			};

		announcement.startSearch(valley);
	}
}
