package tests;

import java.util.List;
import java.util.Scanner;

import controller.ClassroomHelper;
import controller.CourseHelper;
import controller.InstructorHelper;
import model.Classroom;
import model.Instructor;

public class AddClassroomTester {

	/*
	public static void main(String[] args) {
		ClassroomHelper classhelp = new ClassroomHelper();
		Classroom CompSciLab = new Classroom("8", "17");
		classhelp.deleteClassroom(CompSciLab);;
	}
*/
/*
	public	static	void	main(String[]	args)	{
		//	TODO	Auto-generated	method	stub
		ClassroomHelper	classhelp	=	new	ClassroomHelper();
		Classroom	CompSciLab	=	classhelp.searchForClassroomById(1);
		classhelp.deleteClassroom(CompSciLab);
}
	
	*/
	
	
	static Scanner in = new Scanner(System.in);
	static ClassroomHelper crh = new ClassroomHelper();

	private static void addAClassroom() {
		// TODO Auto-generated method stub
		System.out.print("Enter a building: ");
		String building = in.nextLine();
		System.out.print("Enter a roomNumber: ");
		String roomNumber = in.nextLine();
		System.out.print("Enter a campus: ");
		String campus = in.nextLine();
		System.out.print("Enter a type: ");
		String type = in.nextLine();
		System.out.print("Enter a capacity: ");
		int capacity = in.nextInt();

		Classroom toAdd = new Classroom(building, roomNumber, campus, type, capacity);
		crh.insertClassroom(toAdd);

	}

	private static void deleteAClassroom() {
		// TODO Auto-generated method stub
		System.out.print("Enter a building: ");
		String building = in.nextLine();
		System.out.print("Enter a roomNumber: ");
		String roomNumber = in.nextLine();
		System.out.print("Enter a campus: ");
		String campus = in.nextLine();
		System.out.print("Enter a type: ");
		String type = in.nextLine();
		System.out.print("Enter a capacity: ");
		int capacity = in.nextInt();

		Classroom toDelete = new Classroom(building, roomNumber, campus, type, capacity);
		crh.deleteClassroom(toDelete);

	}

	/*
	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Store");
		System.out.println("2 : Search by Item");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Classroom> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the store name: ");
			String storeName = in.nextLine();
			foundItems = crh.searchForItemByStore(storeName);
			

		} else {
			System.out.print("Enter the item: ");
			String itemName = in.nextLine();
			foundItems = crh.searchForItemByName(itemName);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Classroom l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Classroom toEdit = crh.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
			System.out.println("1 : Update Store");
			System.out.println("2 : Update Item");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Store: ");
				String newStore = in.nextLine();
				toEdit.setStore(newStore);
			} else if (update == 2) {
				System.out.print("New Item: ");
				String newItem = in.nextLine();
				toEdit.setItem(newItem);
			}

			crh.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a classroom");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete a classroom");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAClassroom();
//			} else if (selection == 2) {
//				editAnItem();
			} else if (selection == 3) {
				deleteAClassroom();
			} else if (selection == 4) {
				viewTheList();
			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {

		List<Classroom> allItems = crh.showAllClassrooms();

		for (Classroom li : allItems) {
			System.out.println(li.returnItemDetails());
		}

	}
	
	
}
