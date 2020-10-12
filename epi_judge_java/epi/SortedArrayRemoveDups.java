package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.List;

public class SortedArrayRemoveDups {
    // Returns the number of valid entries after deletion.
    public static int deleteDuplicates(List<Integer> array) {
        // TODO - you fill in here.
        if (array.size() <= 1) {
            return array.size();
        }
        int slowPointer = 1;
        for (int fastPointer = 1; fastPointer < array.size(); fastPointer++) {

            if (array.get(slowPointer - 1) != array.get(fastPointer)) {
                array.set(slowPointer, array.get(fastPointer));
                slowPointer++;
            }
        }

        return slowPointer;
    }

    @EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
    public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor,
                                                        List<Integer> A)
            throws Exception {
        int end = executor.run(() -> deleteDuplicates(A));
        return A.subList(0, end);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedArrayRemoveDups.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
