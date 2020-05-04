import java.util.*;
public class QuestionSix {
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
	    if (max - z > 0) {
		max = max;
		if (min - z > 0) {
		    mid = min;
		    min = z;
                } else {
	            mid = z;
      	            min = min;
		}
	    } else {
	        max = z;
                mid = x;
       	        min = y;
            }
	} else {
	    max = y;
	    min = x;
	    if (max - z > 0) {
		max = max;
		if (min - z > 0) {
		    mid = min;
		    min = z;
		} else {
		    mid = z;
		    min = min;
		}
            } else {
	        max = z;
		mid = y;
		min = x;
            }        
	}
	System.out.println("max value is: " + max);
	System.out.println("mid value is: " + mid);
	System.out.println("min value is: " + min);
    }
}