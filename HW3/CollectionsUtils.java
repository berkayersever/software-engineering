// Collections methods sort, reverse, fill, copy, max and min.
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtils 
{
   private static void output( List< Character > listRef )
   {
      System.out.print( "The list is: " );

      for ( Character element : listRef )
         System.out.printf( "%s ", element );

      System.out.printf( "\nMax: %s", Collections.max( listRef ) );
      System.out.printf( "  Min: %s\n", Collections.min( listRef ) );
   }	
	
   public static void main( String[] args )
   {
      //sort
	   String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
       List< String > list_cards = Arrays.asList( suits ); // create List
       System.out.printf( "Unsorted array elements: %s\n", list_cards );
       Collections.sort( list_cards ); // sort ArrayList
       System.out.printf( "Sorted array elements: %s\n", list_cards );
	   
	   
	  // create and display a List< Character >
      Character[] letters = { 'P', 'C', 'M' };
      List< Character > list = Arrays.asList( letters ); // get List
      System.out.println( "list contains: " );
      output( list );

      // reverse and display the List< Character >
      Collections.reverse( list ); // reverse order the elements
      System.out.println( "\nAfter calling reverse, list contains: " );
      output( list );

      // create copyList from an array of 3 Characters
      Character[] lettersCopy = new Character[ 3 ]; 
      List< Character > copyList = Arrays.asList( lettersCopy ); 

      // copy the contents of list into copyList
      Collections.copy( copyList, list );
      System.out.println( "\nAfter copying, copyList contains: " );
      output( copyList );

      // fill list with Rs 
      Collections.fill( list, 'R' ); 
      System.out.println( "\nAfter calling fill, list contains: " );
      output( list );
   }
}