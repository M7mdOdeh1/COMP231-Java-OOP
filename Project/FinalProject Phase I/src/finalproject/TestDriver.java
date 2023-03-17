package finalproject;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.management.openmbean.KeyAlreadyExistsException;

public class TestDriver {

	public static Scanner inp= new Scanner(System.in);
	
	public static void main(String[] args) {
				
		MediaRental mediaRental= new MediaRental();
		
		readInfoFromFile(mediaRental);
		FileWriter customer, media;
		
		int menu=0;
		
		while (true) { //keep showing the menu until the user exit it
			System.out.println("Enter a number between 1 and 9");
			System.out.println(
					"1- Add Customer \t2- Add Media  \t\t3-Add to cart \n4-Remove from cart \t5-Process Requests One \t"
							+ "6- Process Requests Two \n7-Return Media \t\t8- Search Media \t9- Enter other numbers to Save and Exit");
			
			while(true) // keep taking input until the input is integer
				try {
					menu = inp.nextInt();
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Please enter integer only");
					inp.next();
				}
			
			
			switch(menu) {
			case 1: 
				testAddingCustomers(mediaRental);
			break;
			case 2: testAddingMedia(mediaRental);
			break;
			case 3: testingAddingToCart(mediaRental);
			break;
			case 4: testingRemovingFromCart(mediaRental);
			break;
			case 5: testProcessingRequestsOne(mediaRental);
			break;
			case 6: testProcessingRequestsTwo(mediaRental);
			break;
			case 7: testReturnMedia(mediaRental);
			break;
			case 8: testSearchMedia(mediaRental);
			break;
				default:	
					try {
						customer = new FileWriter("customer.txt");
						media = new FileWriter("media.txt");
					
						customer.write(mediaRental.getAllCustomersInfo());  //print all customers info in the file
						media.write(mediaRental.getAllMediaInfo());    //print all media info in the file

						customer.close();
						media.close();
					} catch (IOException ex) {
						System.out.println(ex);						
					}
										 
					System.out.println("Ending program...");
					System.exit(0);
			}
			
		}
		
	}
	
	public static void testAddingCustomers(MediaRental mediaRental) {
		String name, address,plan;
		
		
		while(true) {  //keep taking info until plan be LIMITED or UNLIMITED
			try {
				System.out.println("Enter the name, address and the plan(LIMITED or UNLIMITED) for the customer");
				name=inp.next();
				address=inp.next();
				plan=inp.next();
				mediaRental.addCustomer(name, address, plan);
				System.out.println("Done...");
				break;
			}catch(KeyAlreadyExistsException ex) {  //throw exception if customer name is already exist in the list
				System.out.println(ex.getMessage());
			}catch(IllegalArgumentException ex){   //throw exception if plan not "LIMITED" or "UNLIMITED"
				System.out.println(ex.getMessage());
			} 
				
		
		}	
	}
	
	
	public static void testAddingMedia(MediaRental mediaRental) {
		int menu;		
		String title, rating, artist, songs;
		int no_of_copies;
		double weight;
		
		System.out.println("Enter a number from 1-3");
		System.out.println("1- Add an Album \t 2- Add a Movie \t 3- Add a Game");
		
		while(true) //keep taking input until the input is integer
			try {
				
				menu=inp.nextInt();
				break;
			}catch(InputMismatchException ex) {
				System.out.println("Please enter an integer number only: ");
				inp.next();
			}
	
		
		switch (menu) {    
		case 1:         //add Album
			while(true)   //keep taking input until no errors in the inputs
				try {
					System.out.print("Enter the title: ");
					title = inp.next();
					System.out.print("number of copies: ");
					no_of_copies = inp.nextInt();
					System.out.print("the artist: ");
					artist = inp.next();
					System.out.print("The songs: ");
					songs = inp.next();
					mediaRental.addAlbum(title, no_of_copies, artist, songs);
					System.out.println("Done...");
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Please enter an integer number only for no_of_copies!!!");
					inp.next();
				}catch(KeyAlreadyExistsException ex) { //throw exception if media title is existed
					System.out.println(ex.getMessage());
				}
			break;
			
		case 2:  //add movie    
			
			while (true) {  //keep taking input until no errors in the inputs
				try {
					System.out.print("Enter the title: ");
					title = inp.next();
					System.out.print("number of copies: ");
					no_of_copies = inp.nextInt();
					System.out.print("rating(DR, HR, AC): ");
					rating = inp.next();
					mediaRental.addMovie(title, no_of_copies, rating);
					System.out.println("Done...");
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Please enter an integer number only for number of copies!!! ");
					inp.next();
				}catch(KeyAlreadyExistsException ex) {
					System.out.println(ex.getMessage());
				} catch (IllegalArgumentException ex) {
					System.out.println("Rating only can be : DR or HR or AC");
					inp.next();
				}
			}
			break;
			
		case 3:       //add Game
			
			while(true) {    //keep taking input until no errors in the inputs
				try {
					System.out.print("Enter the title: ");	
					title =inp.next();
					System.out.print("number of copies: ");
					no_of_copies = inp.nextInt();
					System.out.print("the weight: ");
					weight = inp.nextDouble();
					mediaRental.addGame(title, no_of_copies, weight);
					System.out.println("Done...");
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Invalid input, Re-enter it agian");
					inp.next();
				}catch(KeyAlreadyExistsException ex) {
					System.out.println(ex.getMessage());
				}
			}
			break;
			
		default:
			System.out.println("Invalid input!!!");
			break;
		}
	}
	
	
		
		
	
	public static void testingAddingToCart(MediaRental mediaRental) {  //add [mediaTitle] to [customerName's cart]
		String customerName, title;
		System.out.println("Enter Customer Name and Media Title");
		customerName = inp.next();
		title = inp.next();
		if(mediaRental.addToCart(customerName, title))
			System.out.println("Done...");
		else
			System.out.println("Failed");
	}
	
	public static void testingRemovingFromCart(MediaRental mediaRental) {  //remove [mediaTitle] to [customerName's cart]
		String customerName, title;
		System.out.println("Enter Customer Name and Media Title");
		customerName = inp.next();
		title = inp.next();
		if(mediaRental.removeFromCart(customerName, title))
			System.out.println("Done...");

		
	}
	
	public static void testProcessingRequestsOne(MediaRental mediaRental) { 
	//print cart and rented list before and after processing Requests	
		System.out.println("=======Before Processing========");
		printCartAndRented(mediaRental);
		System.out.println("================================");

		System.out.println("--------------------------------");
		String s=mediaRental.processRequests();
		if(!s.equals(""))
			System.out.println(s);
		else
			System.out.println("There is no request to process");		
		System.out.println("--------------------------------");

		System.out.println("=======After Processing========");
		printCartAndRented(mediaRental);
		System.out.println("================================");

	}
	
	public static void testProcessingRequestsTwo(MediaRental mediaRental) {
		//print cart and rented list after processing Requests	

		System.out.println("--------------------------------");
		String s=mediaRental.processRequests();
		if(!s.equals(""))
			System.out.println(s);
		else
			System.out.println("There is no request to process");
		
		System.out.println("--------------------------------");

		
		System.out.println("=======After Processing========");
		printCartAndRented(mediaRental);
		System.out.println("================================");
	}
	
	public static void testReturnMedia(MediaRental mediaRental) {  //return the media from rented list to the system
		String customerName, title;
		System.out.println("Enter Customer Name and Media Title");
		customerName = inp.next();
		title = inp.next();
		
		if(mediaRental.returnMedia(customerName, title))
			System.out.println("Done...");
		else
			System.out.println("Failed");

		
	}
	
	public static void testSearchMedia(MediaRental mediaRental) { //search for media according to specific  parameter
		String title, rating, artist, songs;
		
		System.out.print("Enter media title: ");
		inp.nextLine();
		title = inp.nextLine();
		System.out.print("rating: ");
		rating = inp.nextLine();
		System.out.print("artist: ");
		artist = inp.nextLine();
		System.out.print("songs: ");
		songs = inp.nextLine();
		
		System.out.println("======================================");
		System.out.println("The result of the search: ");
		System.out.println(mediaRental.searchMedia(title, rating, artist, songs));
		System.out.println("======================================");

		
	}
	
	private static void printCartAndRented(MediaRental mediaRental){ //print cart and rented list for each customer
		
		for(int i=0; i<mediaRental.getCustomer().size(); i++) {
			Customer c = mediaRental.getCustomer().get(i);	
			
			System.out.print(c.getName()+"'s cart is: "+c.getCart().toString());//print the customer's cart list			
			System.out.println(",  rented items: "+c.getRented().toString()); //print the customer's rented list
		}
	}

	
	private static void readInfoFromFile(MediaRental mediaRental) { //to read the info from the last execution from the file
		                                                          //and restore the same inventory contents
		File customerFile = new File("customer.txt");
		File mediaFile = new File("media.txt"); 
		
		if(customerFile.exists()) {  //if the file doesn't exist it will skip reading customers from file
			try {
				Scanner customerReader = new Scanner(customerFile);
				while(customerReader.hasNextLine()){  //each line represent info about one customer
					String s = customerReader.nextLine();  
					
					String[] customer= new String[5];  //indices  0: name of customer 1:address, 2:plan, 3:cart, 4:rented
					
					for (int i = 0; i < customer.length-1; i++) {
						customer[i] = s.substring(s.indexOf('=')+1, s.indexOf(',')); 
						s = s.substring(s.indexOf('=')+customer[i].length()+3);	
					}
					
					customer[3]= customer[3].substring(1, customer[3].indexOf(']'));
					customer[4]= s.substring(s.indexOf('=')+2, s.indexOf(']'));					

					ArrayList<String> cart= new ArrayList<String>();
					ArrayList<String> rented=new ArrayList<String>();
					
					String[] cartItems= customer[3].split(", ");
					for (int i = 0; i < cartItems.length; i++) {
						if(!cartItems[i].equals(""))
							cart.add(cartItems[i]);
					}
					
					String [] rentedItems = customer[4].split(", ");
					for (int i = 0; i < rentedItems.length; i++) {
						if(!rentedItems[i].equals(""))
							rented.add(rentedItems[i]);
					}
					mediaRental.getCustomer().add(new Customer(customer[0], customer[1], customer[2], cart, rented));
				}
				customerReader.close();
						
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}		
		}
          

          
          if (mediaFile.exists()) {   //if the file doesn't exist it will skip reading media from file
				try {
					Scanner mediaReader = new Scanner(mediaFile);
					while (mediaReader.hasNextLine()) {
						String s = mediaReader.nextLine();
						
						  String[] album= new String[4];
				          String[] movie = new String[3];
				          String[] game = new String[3];
				          
						if (s.substring(0, 5).equals("Album")) { // if the media is Album
							for (int i = 0; i < album.length-1; i++) {
								album[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',')+1);
							}
							album[3]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mediaRental.getMedia().add(new Album(album[0], Integer.parseInt(album[1]), album[2], album[3]));
						} else if (s.substring(0, 5).equals("Movie")) { // if the media is Album
							for (int i = 0; i < movie.length-1; i++) {
								movie[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',') + 1);
							}
							movie[2]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mediaRental.getMedia().add(new Movie(movie[0], Integer.parseInt(movie[1]), movie[2]));

						} else if (s.substring(0, 4).equals("Game")) { // if the media is Album
							for (int i = 0; i < game.length-1; i++) {
								game[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',') + 1);
							}
							game[2]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mediaRental.getMedia().add(new Game(game[0], Integer.parseInt(game[1]), Double.parseDouble(game[2])));
						}
					}
					
					mediaReader.close();

        	  }catch(IOException ex) {
        		  System.out.println(ex.getMessage());
        	  }
        	  
          }

	}

}
