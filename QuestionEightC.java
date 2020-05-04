import java.util.*;
public class QuestionEightC {
    public static void main(String[] args) {
        int j = -3;
        for (int i = 0; i < 3; i++) {
            if ((j + 2 == 3) || (j + 2 == 2)) {
                j--;
            } else {
                if (j + 2 == 0) {
                    j += 2;
                } else {
                    j = 0;
                }
            }
            
            if (j <= 0) {
                j = 3 - i;
            }
        }
    }
}