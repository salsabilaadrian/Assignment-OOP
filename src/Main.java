import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<JuGlib> juglib = new ArrayList<>();

	public String genid() {
		String x = "1234567890";
		StringBuilder sb = new StringBuilder();
		
		int len = 4;
		
		for (int i = 0; i < len; i++) {
			int index = rand.nextInt(x.length());
			char randomChar = x.charAt(index);
			sb.append(randomChar);
		}
		String id = "BOOK"+sb.toString();
		return id;
	}
	
	public void add() {
		String name;
		System.out.println("Input book name >> ");
		name = scan.nextLine();
		
		int price;
		do {
			System.out.println("Input book price[more than 20000] >> ");
			price = scan.nextInt();
			scan.nextLine();
			if(price <= 2000) {
				System.out.println("Book price must be more than 20000!");
			}
		}while(price <= 20000);
		
		String desc;
		do {
			System.out.println("Input book description [5..20] >> ");
			desc = scan.nextLine();
			if(desc.length() < 5 || desc.length() > 20) {
				System.out.println("Description should be between 5 and 20 characters");
			}
		}while(desc.length() < 5 || desc.length() > 20);
		
		String lib;
		do {
			System.out.println("Input library name [EchLib|JustGoLib|XLib] >> ");
			lib = scan.nextLine();
		}while(!lib.equals("EchLib") &&
				!lib.equals("JustGoLib") &&
				!lib.equals("XLib"));
		String id = genid();
		juglib.add(new JuGlib(name, price, desc, lib, id));
		System.out.println("Successfully added new book!");
		System.out.println("Press enter to continue");
	}
	
	public void view() {
		if(juglib.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
		}
		
		for (int i = 0; i < juglib.size(); i++) {
			JuGlib get = juglib.get(i);
			System.out.println("List of Book :");
			System.out.println("======================================================================");
//			System.out.println("||%7s||%7s||%7s||", "Library Name", );
			System.out.println("||Library Name || Book Id || Book name || Book Price || Book Description || Library Country||");
			if(get.getLibrary().equals("EchLib")) {
				System.out.printf("||%3s || %3s || %3s || Rp.%3d || %3s || %3s||\n", get.getLibrary(), get.getId(), get.getName(), get.getPrice(), get.getDesc(), "Singapore");
//				System.out.println("Country : Singapore");
			} else if(get.getLibrary().equals("JustGoLib")) {
				System.out.printf("||%3s || %3s || %3s || Rp.%3d || %3s || %3s||\n", get.getLibrary(), get.getId(), get.getName(), get.getPrice(), get.getDesc(), "Indonesia");
//				System.out.println("Country : Indonesia");
			} else if(get.getLibrary().equals("XLib")) {
				System.out.printf("||%3s || %3s || %3s || Rp.%3d || %3s || %3s||\n", get.getLibrary(), get.getId(), get.getName(), get.getPrice(), get.getDesc(), "Malaysia");	
//				System.out.println("Country : Malaysia");
			}
//			System.out.printf("||%3s || %3s || %3s || Rp.%3d || %3s || %3s||\n", get.getName(), get.getId(), get.getName(), get.getPrice(), get.getDesc(), get.getLibrary());
			System.out.println("======================================================================");	
		}
		System.out.println("Press enter to continue...");
	}
	
	
	
	public void update() {
		if(juglib.isEmpty()) {
			System.out.println("Book Id not found!");
			System.out.println("Press enter to continue...");
		}
		
		
		for (int i = 0; i < juglib.size(); i++) {
			int choose;
			String name;
			int price;
			String desc;
			do {
				System.out.println("Update");
				System.out.println("Update book price");
				System.out.println("Update book description");
				System.out.println("Choose [1-3] >> ");
				choose = scan.nextInt();
				JuGlib get = juglib.get(choose);
					if(choose == 1) {
						System.out.println("Input book name >>");
						name = scan.nextLine();
						get.setName(name);
						System.out.println("Succesfully changed book name!");
						System.out.println("Press enter to continue...");
					}else if(choose == 2){
						do {
							System.out.println("Input book price [more than 2000]");
							price = scan.nextInt();
							scan.nextLine();
							get.setPrice(price);
							System.out.println("Succesfully changed book price!");
							System.out.println("Press enter to continue...");		
						}while(price < 20000);
					} else if(choose == 3) {
						do {
							System.out.println("Input book description [5..20] >> ");
							desc = scan.nextLine();
							if(desc.length() < 5 || desc.length() > 20) {
								System.out.println("Description should be between 5 and 20 characters");
							}
							get.setDesc(desc);
						}while(desc.length() < 5 || desc.length() > 20);
						System.out.println("Succesfully changed book description!");
						System.out.println("Press enter to continue...");
					}
					
					
				}while(choose < 1 || choose > 3);
		}

	}
	
	public Main() {
		int choose;
		do {
			System.out.println("Welcome to JuGlib");
			System.out.println("1. View Book");
			System.out.println("2. Add Book");
			System.out.println("3. Update Book");
			System.out.println("4. Exit");
			System.out.println("Choose [1 - 4] >>");
			choose = scan.nextInt();
			scan.nextLine();
			switch(choose) {
			case 1:
				view();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			}
		}while(choose != 4);
	}

	public static void main(String[] args) {
		new Main();

	}

}
