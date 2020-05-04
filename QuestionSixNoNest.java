import java.util.*;
public class QuestionSixNoNest {
    public static void main(String[] args) {
        int x, y, z;
	int max = -1, mid = -1, min = -1;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter three unique numbers: "); 
        x = sc.nextInt();  
	y = sc.nextInt();  
	z = sc.nextInt();  
		
	if (x - y > 0) {
	    max = x;
	    min = y;
	} else {
	    max = y;
	    min = x;
	}
	
	if (min - z > 0) {
	    mid = min;
            min = z;
        } else {
	    mid = z;
      	    min = min;
	} 

	if (max - z > 0) {
	    max = max;
        } else {
            mid = max;
   	    min = min;
   	    max = z;
   	}
	
	System.out.println("max value is: " + max);
	System.out.println("mid value is: " + mid);
	System.out.println("min value is: " + min);
    }
}