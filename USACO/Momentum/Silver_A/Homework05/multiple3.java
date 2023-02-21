import java.util.*;
import java.io.*;
import java.math.BigInteger;

public final class multiple3 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
	int n = in.nextInt();
	int[] a2 = new int[n];
	for(int i = 0; i<n; i++){
		a2[i] = in.nextInt();
	}

	ArrayList<Integer> a = new ArrayList<>();
	for(int i : a2) a.add(i);
	Collections.sort(a);
	int sum = 0;
	for(int i : a) sum += i;

	boolean one = a.contains(1); boolean four = a.contains(4); boolean seven = a.contains(7);
	boolean two = a.contains(2); boolean five = a.contains(5); boolean eight = a.contains(8);
	
	if(sum % 3 == 1){	
		if(one) a.remove(Integer.valueOf(1));
		else if(four) a.remove(Integer.valueOf(4));
		else if(seven) a.remove(Integer.valueOf(7));
		if(!one && !four && seven){
			if(two && five){
				a.remove(Integer.valueOf(2));
				a.remove(Integer.valueOf(5));
			}
			else if(two && eight){
				a.remove(Integer.valueOf(2));
				a.remove(Integer.valueOf(8));
			}
			else if(five && eight){
				a.remove(Integer.valueOf(5));
				a.remove(Integer.valueOf(8));
			}
		}
	}
	if(sum % 3 == 2){
		if(two) a.remove(Integer.valueOf(2));
		else if(five) a.remove(Integer.valueOf(5));
		else if(eight) a.remove(Integer.valueOf(8));
		if(!two && !five && !eight){
			if(one && four){
				a.remove(Integer.valueOf(1));
				a.remove(Integer.valueOf(4));
			}
			if(one && seven){
				a.remove(Integer.valueOf(1));
				a.remove(Integer.valueOf(7));
			}
			if(four && seven){
				a.remove(Integer.valueOf(4));
				a.remove(Integer.valueOf(7));
			}
		}
	}
	Collections.reverse(a);

	String resultStr = "";
	for(int i : a) resultStr += String.valueOf(i);
	BigInteger MOD = new BigInteger("1000000007");
	BigInteger result = new BigInteger(resultStr);
	result = result.mod(MOD);


	System.out.println(result);
  }
}