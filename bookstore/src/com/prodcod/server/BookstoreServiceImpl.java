package com.prodcod.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.prodcod.client.service.BookstoreService;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.BookStore;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;
import com.prodcod.shared.domain.Software;

public class BookstoreServiceImpl extends RemoteServiceServlet implements BookstoreService {

	private static final long serialVersionUID = -886922978463348041L;

	private static final String[] bookTitle = new String[]{"Mastering kungFu",
														   "Basic Cookery",
														   "Dad's Army",
														   "DIY - electrical work",
														   "DIY - plumbing",
														   "Political Solutions",
														   "Micro economics",
														   "Golfers manual",
														   "Alcholics Anonymous",
														   "Animal Life"

	};

	private static final String[] bookAuthor = new String[]{"Hi tme",
															"Sal ami",
															"Capt Mainwaring",
															"Sparky Jones",
															"Steve Jones",
															"Kasper Foobar",
															"Baldas Akoot",
															"Tee Pole",
															"Tee Total",
															"Piggy Smith"

	};



	private static final String[] musicTitle = new String[]{"Regaining Unconsciousness",
		"Conditions of my parole",
		"Under a stone with no inscription",
		"Don't crush that Dwarf, Hand me the pliers",
		"I don't mean to insult you, but you look like Bobcat Goldthwait",
		"To reduce the choir to one soloist",
		"Vulgar Power of Display",
		"One day it'll all make sense",
		"Born under a bad sign",
		"Effigy of the forgotten"
	};

	private static final String[] musicArtist = new String[]{"NOFX",
		"puscifer",
		"Anata",
		"The Firesign Theatre",
		"Bobcat Goldthwait",
		"Acme",
		"Pantera",
		"Common",
		"Albert King",
		"Suffocation"

	};

	private static final String[] softwareTitle = new String[]{"Terminal",
															   "Velocity",
															   "Virtual Machine",
															   "Parachute",
															   "Bloggit!",
															   "Bridge",
															   "UML Modeller",
															   "TestFirst",
															   "Spectator",
															   "OfficeApps"															  															   
	};

	private static final String[] softwareVersion = new String[]{"0.1",
																 "4.2",
																 "2.3",
																 "1.0",
																 "6.0",
																 "5.5",
																 "2.3.4",
																 "6.4.3",
																 "9.6",
																 "13.4"																 
	};

	private static final int MIN_YEAR = 1960;
	private static final int MAX_YEAR = 2014;

	private static final String publishers[] = new String[] {"Atco", "Omni", "Fresco"};

	private static final int NUMBER = 10;

	private static final Random random = new Random();

	public static List<Item> list = new ArrayList<Item>();
	static{
		list.addAll(generateBook());
		list.addAll(generateMusicCD());
		list.addAll(generateSoftware());
	}
	public static List<Item> itemList = Collections.<Item>synchronizedList(list);

	@Override
	public BookStore getBookstore() {
		BookStore bookStore = new BookStore("Nile Store");
//		bookStore.setItems(itemList);
		bookStore.setItems(list);
		return bookStore;
	}


	private static final float getPrice() {
		return random.nextFloat() * 100.0f;
	}

	private static final String getPublisher() {
		return publishers[random.nextInt(publishers.length)];
	}

	private static final int getYearPublished() {
		return (int)(MIN_YEAR + random.nextFloat() * (MAX_YEAR - MIN_YEAR));
	}

	/*
	 * Generates Sample List of MusicCD
	 */
	private static List<MusicCD> generateMusicCD(){

		final List<MusicCD> list = new ArrayList<MusicCD>();

		for (int k = 0; k < NUMBER; k++) {
			final MusicCD cd = new MusicCD(musicTitle[k], getPublisher(), getPrice(), getYearPublished(), musicArtist[k]);
			list.add(cd);
		}
		return list;
	}

	/*
	 * Generates Sample List of Books
	 */
	private static List<Book> generateBook(){

		final List<Book> list = new ArrayList<Book>();

		for (int k = 0; k < NUMBER; k++) {
			final Book book = new Book(bookTitle[k], getPublisher(), getPrice(), getYearPublished(), bookAuthor[k]);
			list.add(book);
		}
		return list;
	}

	/*
	 * Generates Sample List of Software
	 */
	private static List<Software> generateSoftware(){

		final List<Software> list = new ArrayList<Software>();

		for (int k = 0; k < NUMBER; k++) {
			final Software software = new Software(softwareTitle[k], getPublisher(), getPrice(), getYearPublished(), softwareVersion[k]);
			list.add(software);
		}
		return list;
	}

}
