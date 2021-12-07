
import java.util.*;
import java.io.*;


public class CardPrinter
{
	public  String [] names = new String [70];
	public  String login = "";
	public  String password = "";
	public  int count = 0;
	public  String current = "";
	
	public CardPrinter () 
	{
		try{
			File arrivals = new File("E:\\Projects\\Hotel Items\\Card Printer\\arrivals.txt");
			Scanner reader = new Scanner(arrivals);
			
			current = reader.next();
			login = "Login: blueridge";
			password = "Password: blue1313";
			while(true)
			{
				cycle(reader);
				if(!reader.hasNext())
				{
					break;
				}
				collector(reader);
				//print();
				count++;
				
			}
		}catch(FileNotFoundException e){
			System.out.println("Scanner or File failure.");
		}
	}
	
	 
	//prints name and wifi info
	public void print()
	{
		
		
		System.out.println(names[count]);
		System.out.println();
		System.out.println(login);
		System.out.println(password);
		System.out.println();

	}
	
	//gets last name in current string
	public void collector (Scanner reader)
	{
		for(int i = 0; i < 3; i++)
		{
			current = reader.next();
		}
		
		current = current.substring(0, current.length()-1);
		names[count] = current;
	}
	
	//cycles to line with vital info
	public void cycle(Scanner reader)
	{
		while(!current.equals("BRI"))
		{
			current = reader.next();
			if(!reader.hasNext())
			{
				break;
			}
		}
	}
	
	
	
	
	
}