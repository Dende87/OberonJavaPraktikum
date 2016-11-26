package ue1Java5;

/**
 * Created by Dende on 26.11.2016.
 */
enum Season{Spring, Summer, Autumn, Winter}

public class EnumTest {

    public static void main(String[] args){
        Season time = Season.Winter;
        System.out.println("It is " + time);

        switch (time){
            case Spring: System.out.println("spring"); break;
            case Summer: System.out.println("summer"); break;
            case Autumn: System.out.println("autumn"); break;
            case Winter: System.out.println("winter"); break;
        }
    }
}
