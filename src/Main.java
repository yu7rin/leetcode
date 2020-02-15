import java.util.HashSet;

public class Main {

    public static void main(String[] args) {


            HashSet s = new HashSet<>();
            for(int i = 1; i <100 ; i++){
                s.add(i);
                s.remove(i - 1);
            }
            System.out.print(s.size());


    }


}
