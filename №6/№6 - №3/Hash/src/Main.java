import java.util.Scanner;
import HashProcessing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введіть строку: ");
        Scanner in = new Scanner(System.in);
        String str = in.next();

        StringRawHash StringRH = new StringRawHash();
        StringHardHash StringHH = new StringHardHash();

        System.out.print('\n'+ "Кількість елементів у хеші: "+ StringRH.hash(str) +'\n') ;

        System.out.print("Хеш строки як сума кодів її символів, кожен яких множиться на номер власної позиції: " + StringHH.hash(str)+ '\n') ;
    }
}