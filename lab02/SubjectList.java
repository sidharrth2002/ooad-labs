import java.util.*;

public class SubjectList {
    public static void main(String[] args) {

        //Test 1
        // Subject s1 = new Subject("s1", 'A');
        // Subject s2 = new Subject("s2", 'B');
        // Subject s3 = new Subject("s3", 'C');

        // Subject[] subs = new Subject[5];
        // for (int i = 0; i<5; i++) {
        //     subs[i] = new Subject("s"+i, 'A');
        // }

        //Test 2
        ArrayList<Subject> subs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //randomly populate
            if (i%2 == 0) {
                subs.add(new Subject("s"+i, 'A'));
            } else {
                subs.add(new Subject("s"+i, 'B'));
            }
        }

        //before remove
        System.out.println("Before Removal: ");
        System.out.println(subs);
        
        for (int i=0;i<subs.size();i++) { 
            if (subs.get(i).getCode().equals("s2"))
                subs.remove(i);
        }

        //after remove
        System.out.println("After Removal: ");
        System.out.println(subs);
    }
}