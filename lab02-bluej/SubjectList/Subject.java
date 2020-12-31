
/**
 * Write a description of class SubjectList here.
 *
 * @author Sidharrth
 * @version (10/12/2020)
 */

public class Subject {
    private String code;
    private char result;

    Subject(String cd, char res) {   
        this.code = cd;
        this.result = res;
    }
    
    public String getCode() {    
        return code;
    }
    
    public char getResult() {
       return result;
    }
    
    public String toString() {   
        return("Subject: "+code+" - "+result);
    }

}

