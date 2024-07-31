import javax.xml.transform.Source;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void ortalamaAl(int sayi1 , int sayi2){
        int ortalama = (sayi1+sayi2)/2;
        System.out.println(ortalama);
    }

    public static double ortalamaHesaplama(int sayi1, int sayi2){
        double ortalama=(sayi1+sayi2)/2;
        return ortalama;
    }

    public static void main(String[] args) {


        ortalamaAl(10,20);
        ortalamaAl(13,20);

        System.out.println(ortalamaHesaplama(10,16));


        /*
        int[] numbers = new int[5];
        String[] students = {"ALI","VELI","AYSE"};

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println("numbers[4]= " + numbers[4]);
        System.out.println("students[0]= " + students[0]);
        System.out.println("-----------------");

        for (int i=0 ; i < students.length; i++){
            System.out.println("students["+i+"]:"+ students[i]);
        }
        */

        /*
        Scanner input =new Scanner(System.in);

        int counter=1;
        do {
            System.out.print("Sayi giriniz:");
            counter= input.nextInt();
        }while(counter != 0);

        System.out.println("cikis yapildi");
        */

        /*
        int counter =1;

        while (counter<=10){
            System.out.println(counter);
            counter++ ;
        }
        */
        /*
        for (int i = 0; i < 10; i++) {
            if (i%2==0) System.out.println("i = " + i);
        }
        */
        /*
        int number1, number2;
        byte process;
        Scanner input = new Scanner(System.in);

        System.out.print("1.Sayiyi giriniz: ");
        number1 = input.nextInt();

        System.out.print("2.Sayiyi giriniz: ");
        number2 = input.nextInt();

        System.out.println("Islem Tipi: (1:Toplama, 2:Cikarma, 3:Carpma, 4:Bölme)");
        process = input.nextByte();

        switch (process) {
            case 1:
                System.out.println("Toplam= "+(number1+number2));
                break;
            case 2:
                System.out.println("Fark= "+ (number1-number2));
                break;
            case 3:
                System.out.println("Çarpım= "+(number1*number2));
                break;
            case 4:
                System.out.println("Bölüm= "+(number1/number2));
                break;
            default:
                System.out.println("Yanlis islem tipi sectiniz!!");
        }
        */

        /*
        int number1= 50, number2=20;

        if(number1 < number2){
            System.out.println("number1 is small");
        } else if (number1==number2) {
            System.out.println("equal");
        }else {
            System.out.println("number1 is big");
        }

        System.out.println("go on");
        */
        /*
        int number1, number2, sum;

        Scanner input = new Scanner(System.in);
        System.out.print("1.Sayiyi giriniz: ");
        number1 = input.nextInt();

        System.out.print("2.Sayiyi giriniz: ");
        number2 = input.nextInt();

        sum = number1 + number2;

        System.out.println("1.Sayi=" + number1);
        System.out.println("2.Sayi=" + number2);
        System.out.println("Toplam=" + sum);
        */
        // ----------------------------
        /*
        String text = "deneme";
        char character = '@';
        float numberDecimal = 17.2f;          //4byte
        byte numberByte= 127;           //-128 ile 127 arasındaki sayıları alır. 1byte
        short numberShort =-32767;      //-32767 32767 . 2byte
        int number = -2147483648;                //-2147483648 2147483647 . 4byte
        int number2;

        number2 = 102;

        System.out.println("text: " + text);
        System.out.println("character: "+ character);
        System.out.println("numberDecimal: "+ numberDecimal);
        System.out.println("numberShort: "+ numberShort);
        System.out.println("numberByte: "+ numberByte);
        System.out.println("number: " + String.valueOf(number));
        System.out.println("number2: " + number2);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Merhaba Dünya\n");
        System.out.println("sout ile");

        */
        //--------------------------------
        /*
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }*/
    }
}