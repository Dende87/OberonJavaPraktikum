package ue1Java5;

import java.util.ArrayList;

/**
 * Created by Dende on 26.11.2016.
 */
public class AutoboxingUnboxing {

    public static void main(String[] args){
        ArrayList memory = new ArrayList();
        memory.add(4711);
        memory.add(46);
        memory.add(33);

        int sum = 0;
        for (int i = 0; i < memory.size(); i++){
            Integer iWrapper = (Integer) memory.get(i);
            sum += iWrapper;
        }

        System.out.println("Sum = " + sum);
    }
}
