public class MonProg
{
	public static void main( String[] args )
	{
		System.out.println("nb args=" + args.length);
		try {
			for( int i=0; i<args.length; i++ ) {
				System.out.println("arg " + i + "=" + args[i]);
			}
		catch( Exception ex ) {
			System.out.println("erreur !");
			ex.printStackTrace();
			}
		}
	}
}
