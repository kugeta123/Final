import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class QuestionOne {
    public static void main(String[] args) {
        //read save string from txt file 
        BufferedReader br = null;
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader("E:/GSU/2nd/PLC/test.txt"));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String string = sb.toString();

    	QuestionOne one = new QuestionOne();
        String str = one.check(string);
        System.out.print(str);
    }
    
    public String check_keywords(String string) {
        String[] str = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
                        "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if",
                        "implements", "import", "instanceof","int", "interface", "long", "native", "new", "null", "package",
                        "private", "protected", "public", "return", "short","static", "strictfp", "super", "switch", 
                        "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"}; 
        
    	for (int i = 0; i < str.length; i++) {
            if (str[i].equals(string)) return "error ";
        }
        return "variable name               ";
    }
    
    public String check(String string) {
        int n = string.length();
        if (n == 0) return "error";
        char c = string.charAt(0);
        if (n == 1) {
            if (c > 47 && c < 58) return "int";
            else return "error";
        }
        char c1 = string.charAt(1);
        if (n == 2) {
            if ((c == '+' || c == '-') && (c1 > 47 && c1 < 58)) return check_positve_or_negative_number(string);
	    if ((c == '.') && (c1 > 47 && c1 < 58)) return check_dot(string);
	}
            
    	char c2 = string.charAt(2);
    	if (n > 2) {
	    if (c == '+' || c == '-' || c == '.' || (c > 47 && c < 58)) {
	        if ((c == '+' || c == '-') && (c1 > 47 && c1 < 58)) return check_positve_or_negative_number(string);
	        if ((c == '.') && (c1 > 47 && c1 < 58)) return check_dot(string);
	        if ((c == '+' || c == '-') && (c1 == '.') && (c2 > 47 && c2 < 58)) return check_positve_or_negative_with_dot_number(string);
	        if (c > 47 && c < 58) return check_number(string);
	    }
	}
	
        if (c == '"') return check_str(string);
        
        if ((c == '_') || (c == '$') || ((c > 64 && c < 91) || (c > 96 && c < 123))) return check_name(string);  
	return "error";
    }
    
    public String check_positve_or_negative_number(String string) {
	int cnt = 1;
	int exp_cnt = 0;
	int exp_idx = 0;
	int com_cnt = 0;
	int com_idx = 0;
		
        for (int i = 1; i < string.length(); i++) {
    	    char c = string.charAt(i);
            if (c > 47 && c < 58) cnt++;
	    if (c == 'e') {
	        exp_idx = i;
	        exp_cnt++;
	    }
	    if (c == '.') {
	        com_idx = i;
	        com_cnt++;
	    }
        }
	
        if (cnt == string.length()) {
            return "int";
        }
	if (cnt == string.length() - 1 && exp_cnt == 1 && exp_idx != string.length() - 1) return "int"; 
	if (cnt == string.length() - 1 && com_cnt == 1 && com_idx != string.length() - 1) return "float";
	if (cnt < string.length() - 1 && com_idx < exp_idx && exp_idx != string.length() - 1) return "float";
	return "error";
    }
    
    public String check_dot(String string) {
	int cnt = 1;
	int exp_cnt = 0;
	int exp_idx = 0;
		
        for (int i = 1; i < string.length(); i++) {
    	    char c = string.charAt(i);
            if (c > 47 && c < 58) cnt++;
	    if (c == 'e') {
	        exp_idx = i;
	        exp_cnt++;
	    }
        }
	
        if (cnt == string.length()) {
            return "float";
        }
	if (cnt == string.length() - 1 && exp_cnt == 1 && exp_idx != string.length() - 1) return "int"; 
	return "error";
    }
    
    public String check_positve_or_negative_with_dot_number(String string) {
	int cnt = 2;
	int exp_cnt = 0;
	int exp_idx = 0;
		
        for (int i = 2; i < string.length(); i++) {
    	    char c = string.charAt(i);
            if (c > 47 && c < 58) cnt++;
	    if (c == 'e') {
	        exp_idx = i;
	        exp_cnt++;
	    }
        }
	
        if (cnt == string.length()) {
            return "float";
        }
	if (cnt == string.length() - 1 && exp_cnt == 1 && exp_idx != string.length() - 1) return "float"; 
	return "error";
    }
	
    public String check_number(String string) {
	int cnt = 1;
	int exp_cnt = 0;
	int exp_idx = 0;
	int com_cnt = 0;
	int com_idx = 0;
		
        for (int i = 1; i < string.length(); i++) {
    	    char c = string.charAt(i);
            if (c > 47 && c < 58) cnt++;
	    if (c == 'e') {
	        exp_idx = i;
	        exp_cnt++;
	    }
	    if (c == '.') {
	        com_idx = i;
	        com_cnt++;
	    }
        }
	
        if (cnt == string.length()) {
            return "int";
        }
	if (cnt == string.length() - 1 && exp_cnt == 1 && exp_idx != string.length() - 1) return "int"; 
	if (cnt == string.length() - 1 && com_cnt == 1 && com_idx != string.length() - 1) return "float";
	if (cnt < string.length() - 1 && com_idx < exp_idx && exp_idx != string.length() - 1) return "float";
	return "error";
    }
	
    public String check_str(String string) {
        int cnt = 2;
        for (int i = 1; i < string.length() - 1; i++) {
            char c = string.charAt(i);
            if (c >= 0 && c < 256) cnt++;
        }
    	char last = string.charAt(string.length() - 1);
	if ((last == '"') && (cnt == string.length())) return "string";
	else return "error";
    }
    
    public String check_name(String string) {
        String check = check_keywords(string);
        if (check == "error") return "error";
        
        int cnt = 1;
    	for (int i = 1; i < string.length(); i++) {
    	    char c = string.charAt(i);   
            if ((c == '_') || (c == '$') || (c > 64 && c < 91) || (c > 96 && c < 123)) cnt++;
            if (cnt == string.length()) return "true";
        }
	return "error";
    }
}