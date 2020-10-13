package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IntAsArrayIncrement {
    @EpiTest(testDataFile = "int_as_array_increment.tsv")
    public static List<Integer> plusOne(List<Integer> array) {
        if (array.size() < 1) {
            return array;
        }
        if (array.size() == 1) {
            if(array.get(0) == 9 ){
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.add(1);
                newArray.add(0);
                return newArray;
            }
            array.set(0,array.get(0)+1);
            return array;
        }

        boolean carry = false;
        int i = array.size() - 1;
        do {
            if (carry && i == 0 && array.get(0) == 9) {
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.add(1);
                if(array.get(0) == 9){
                    array.set(0,0);
                }else{
                    array.set(0,array.get(0)+1);
                }
//                newArray.add(0);
                for (int j = 0; j < array.size(); j++) {
                    newArray.add(array.get(j));

                }
                return newArray;
            }

            if (carry) {
                if (array.get(i) == 9) {
                    carry = true;
                    array.set(i, 0);
                } else {
                    array.set(i, array.get(i) + 1);
                    carry = false;
                }
            } else if (array.get(i) == 9) {
                carry = true;
                array.set(i, 0);
            } else {

                array.set(i, array.get(i) + 1);
            }
            i--;
        } while (carry);


        return array;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
