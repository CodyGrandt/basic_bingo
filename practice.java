public class practice {

	public static void main ( String [ ] args ) {


		int [ ] array = new int [ 5 ];
		System.out.println ( array.length );

		for (int i = 0 ; i < array.length - 1 ; i++ )
			array [ i ] = 1;

		int count = 0;
		for ( int i = 0 ; i < array.length ; i++ )
			if ( array [ i ] > 0 )
				count++;

		System.out.println ( count );
	



	}
	
}
