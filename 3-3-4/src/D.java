/**
 * Created by Bea on 05/02/2017.
 */
public class D {
    int i = 4;
    int j;
    D(){
        print("i = " + i + ", j = " + j);
        j = 7;
    }
    static int x1 = print("static D.x1");
    static int print(String s){
        System.out.println(s);
        return 9;
    }
}
