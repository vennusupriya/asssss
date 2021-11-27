package com.graded.assignment;


import java.util.*;
import java.util.Map.Entry;
//import com.hcl.assignment.utils.*;


public class MagicOfBooks  {
	
	Book b = new Book();
	
	Scanner sc = CustomScanner.getScanner();
	
	Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
	Map<Integer, Object> bookMapForOrder1 = new HashMap<Integer, Object>();
	
	
	ArrayList<Book> bookList = new ArrayList<>();
	
	public void add() throws InvalidDataEntered{
		try {    
		
		Book b=new Book();
		
		System.out.println("Enter book id:");
		int bookId = sc.nextInt();
		b.setBookId(bookId);
		
		System.out.println("Enter book name:");
		b.setBookName(sc.next());
		
		System.out.println("Enter book price:");
		int price = sc.nextInt();
		b.setPrice(price);
		
		System.out.println("Enter book genre\n Press A for Auto Biography\n Press N for Novels\n Press T for Technical books  :");
		b.setGenre(sc.next());
		
		System.out.println("Enter no. of copies sold:");
		b.setNoOfCopiesSold(sc.nextInt());
		
		System.out.println("Enter book status\n Press B For Best Selling\n Press R For Regular Selling:");
		b.setStatus(sc.next());
		
		bookList.add(b);
		bookMap.put(bookId,b);
		bookMapForOrder1.put(price,b);
		
		if(b.equals(null)) {
	       	 throw new InvalidDataEntered();
	     }
		
		System.out.println("Book is added successfully...");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		catch(InvalidDataEntered e){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty string or invalid string entered");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}

	}	
	
	public void delete() throws InvalidDataEntered {
		try {
		
		System.out.println("Enter book id which you want to remove:");
		int bookId = sc.nextInt();
		System.out.println();
		
		if(bookId<=0) {
			throw new InvalidDataEntered();
		}
		
		bookMap.remove(bookId);
		
		System.out.println("Book is successfully removed...");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		}catch(InvalidDataEntered e){
		
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty string or invalid string entered");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
	}
	
	public void update() throws InvalidDataEntered {
	
		try {
		
		System.out.println("Enter book id which you want to update:");
		int bookId = sc.nextInt();
		b.setBookId(bookId);

		System.out.println("Enter book name:");
		b.setBookName(sc.next());		
		
		System.out.println("Enter book price:");
		b.setPrice(sc.nextInt());
		
		System.out.println("Enter book genre:");
		b.setGenre(sc.next());
		
		System.out.println("Enter no. of copies sold:");
		b.setNoOfCopiesSold(sc.nextInt());
		
		System.out.println("Enter book status:");
		b.setStatus(sc.next());
		
		if(b==null) {
	       	 throw new InvalidDataEntered();
	     }
		
		bookMap.replace(bookId, b);
		
		System.out.println("Book details updates sucessfully...");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
	}
		catch(InvalidDataEntered e){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty string or invalid string entered");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
	}

	public void display() {
		
		System.out.println("Books Details:");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		//Traversing map  
	    for(Entry<Integer, Book> entry:bookMap.entrySet()){    
	        int key=entry.getKey(); 
	     
	        Book b=(Book) entry.getValue();  
	  
	        System.out.println(key+" "+b.name+" "+b.price+" "+b.genre+" "); 
	        System.out.println();
	    } 
	    
	    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}	
	
	public void count() {
		
		System.out.println("Total books in stores as per book id: "+bookMap.size());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
	

	public void arrageOrder() throws InvalidDataEntered{
		
		boolean flag = true;
		
		try {
	
		while(flag) {
		
		System.out.println("Please Enter your choice:");
		System.out.println("Press 1 for Display books by Low To High Price");
		System.out.println("Press 2 for Display books by High To Low Price");
		System.out.println("Press 3 for Display Best Selling book");
		System.out.println("Press 8 for exit");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		int choice = sc.nextInt();
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		switch(choice) {
		case 1:
			
			System.out.println("Display books by Low To High Price");
			System.out.println();
			System.out.println("Book Details:");
			System.out.println();
			Map<Integer, Object> treeMap = new TreeMap<>(bookMapForOrder1);
			
			for(Entry<Integer, Object> entry:treeMap.entrySet()){    
		         
		        Book b=(Book) entry.getValue();  
		
		          
		        System.out.println(b.bookId+" "+b.name+" "+b.price+" "+b.genre+" ");
		        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		    } 
			break;
		
		case 2:
			System.out.println("Display books by High To Low Price");
			System.out.println();
			
			Map<Integer, Object> treeMapReverseOrder= new TreeMap<>(bookMapForOrder1);
			
			
			// putting values in navigable map
		      NavigableMap<Integer, Object> nmap = ((TreeMap<Integer, Object>) treeMapReverseOrder).descendingMap();
		      
		      System.out.println("Book Details:");
		      
		      for(Entry<Integer, Object> entry:nmap.entrySet()){    
			      
			        Book b=(Book) entry.getValue();  
			  
			        System.out.println(b.bookId+" "+b.name+" "+b.price+" "+b.genre+" ");   
			        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			    }
			break;
		case 3:
			System.out.println("Display Best Selling Book:");
			System.out.println();
			
			String bestSelling = "B";
		        
		        
	        ArrayList<Book> genreBookList = new ArrayList<Book>();
		         
		         Iterator<Book> iter=bookList.iterator();
		         
		         while(iter.hasNext())
		         {
		             Book b=(Book)iter.next();
		             if(b.status.equals(bestSelling)) {
		            	 genreBookList.add(b);
		         }
		         
		         
		         if(genreBookList.isEmpty()){
		             System.out.println("None of the book available in Best Selling ");
		             System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		             continue;
		         }
		         }
		         
		         
		         
		         System.out.println("Book Details:"); 
		         
		         Iterator<Book> it = genreBookList.iterator();
		         while(it.hasNext()){
		             
		             Book b=(Book)it.next();
		             
				     System.out.println(b.bookId+" "+b.name+" "+b.price+" "+b.genre+" ");
				     System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			     }
				
			
			break;
		case 0:
				flag = false;
				System.out.println("Returning to main screen");
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				break;
			
		default:
			throw new InvalidDataEntered();
		}
		}

		}
		catch(InvalidDataEntered e){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty string or invalid string entered");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}	
	}
	
	
	public void displayByGenre() throws InvalidDataEntered {
		try {
		System.out.println("Enter book genre\n Press A for Auto Biography\n Press N for Novels\n Press T for Technical Books:");
        String genre = sc.next().toUpperCase();
        System.out.println();
        
        if(genre==null) {
        	throw new InvalidDataEntered();
        }
        
         ArrayList<Book> genreBookList = new ArrayList<Book>();
         
         Iterator<Book> iter=bookList.iterator();
         
         while(iter.hasNext())
         {
             Book b=(Book)iter.next();
             if(b.genre.equals(genre)) {
            	 genreBookList.add(b);
         }
            
         if(genreBookList.isEmpty()){
             System.out.println("None of the book available in  "+genre);
             System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
             continue;
         }
         }
         
         Iterator<Book> it = genreBookList.iterator();
         
         System.out.println("Book Details:");  
         while(it.hasNext()){
             
             Book b=(Book)it.next();
            
		     System.out.println(b.bookId+" "+b.name+" "+b.price+" "+b.genre+" ");
		     System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	     }
		}
		catch(InvalidDataEntered e){
			 System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty string or invalid string entered");
			 System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
}
}