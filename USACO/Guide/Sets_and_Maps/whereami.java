import java.util.*;
import java.io.*;

public class whereami {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("whereami.in"));
		int n = in.nextInt();
		String mailboxes = in.next();
		ArrayList<String> seqs = new ArrayList<>();
		for(int i = 1; i<=n; i++){
			boolean unique = true;
			for(int j = 0; j<=n-i; j++){
				String current = mailboxes.substring(j,j+i);
				if(seqs.contains(current)){
					unique = false;
					break;
				}
				seqs.add(current);
			}
			if(unique){
				System.out.println(i);
				PrintWriter out = new PrintWriter(new File("whereami.out"));
				out.println(i);
				out.close();
				in.close();
				System.exit(0);
			}
		}
	}
}