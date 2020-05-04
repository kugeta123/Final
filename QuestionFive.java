public class QuestionFive {
    static int row = -1;
    public static void main(String[] args) {
        int[][] x = {{0,1,1,1}, {0,0,0,0}, {3,3,0,3}, {0,0,0,0}}; //case #1 
        //int[][] arr = {{0,1,1,1}, {2,0,2,2}, {3,3,0,3}, {0,0,0,0}}; //case #2
        int n = x.length;
        for (int i = 0; i < n; i++) {    
            for(int j = 0; j < n; j++) {
                if(x[i][j] == 0) {
                    j++;
                } else {
                    break;
                }
            
                if (j == n - 1) {
                    row = i + 1;
                    System.out.println("First all-Zero row is: " + row); 
                    break;
                }
            }
            if (row != -1) {
                break;
            }
        }   
    }
}