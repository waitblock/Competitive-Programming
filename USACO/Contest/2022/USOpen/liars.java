import java.util.*;

public class liars {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    ArrayList<String> gl = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();

    for(int i = 0; i<n; i++){
      gl.add(in.next());
      values.add(in.nextInt());
    }
    in.close();

    int min_greater = Integer.MAX_VALUE;
    int max_less = Integer.MIN_VALUE;

    // System.out.println(gl);
    // System.out.println(values);
    int result = Integer.MAX_VALUE;
    for(int i = 0; i<n; i++){
      result = Math.min(result, count_liars(gl, values, values.get(i)+1));
      result = Math.min(result, count_liars(gl, values, values.get(i)-1));
      result = Math.min(result, count_liars(gl, values, values.get(i)));
    }
    System.out.println(result);
  }

  static int count_liars(ArrayList<String> gl, ArrayList<Integer> values, int location){
    int count = 0;
    for(int i = 0; i<gl.size(); i++){
      // System.out.println(gl.get(i));
      // System.out.println(values.get(i));
      // System.out.println(location);
      // System.out.println("---");
      if(gl.get(i).equals("L")){
        if(values.get(i) <= location){
          count++;
        }
      }
      if(gl.get(i).equals("G")){
        if(values.get(i) >= location){
          count++;
        }
      }
    }
    return count;
  }
}