package midtermprep;

import java.util.Iterator;
import java.util.LinkedList;

public class TimeComplex {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        merge(list1, list2);
        merge2(list1, list2);
    }

    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> listToReturn = new LinkedList<>();
        long start = System.nanoTime();
        int i = 0; // list1 pointer
        int j = 0; // list2 pointer
        int list1Size = list1.size();
        int list2Size = list2.size();
        // while (neither source list is entirely processed), continue the loop
        while (i < list1Size && j < list2Size) {
            int currList1Data = list1.get(i);
            int currList2Data = list2.get(j);
            // add the smaller element in either list to new sorted list
            if (currList1Data <= currList2Data) { // smaller element in list1
                listToReturn.add(currList1Data);
                i++;
            } else { // smaller element in list2
                listToReturn.add(currList2Data);
                j++;
            }
        }

        // either list1 or list2 is not done
        // only one loop below will be executed
        // append all remaining elements in list1 (if any) to new sorted list:
        // listToReturn
        while (i < list1Size) {
            listToReturn.add(list1.get(i));
            i++;
        }

        // append all remaining elements in list2 (if any) to new sorted list:
        // listToReturn
        while (j < list2Size) {
            listToReturn.add(list2.get(j));
            j++;
        }
        long finish = System.nanoTime();
        System.out.println(finish - start);
        return listToReturn;
    }

    public static LinkedList<Integer> merge2(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> listToReturn = new LinkedList<>();
        long start = System.nanoTime();
        if (list1.isEmpty()){
            for(int n: list2){
                listToReturn.add(n);
            return listToReturn;
            }
        }
        if (list2.isEmpty()){
            for(int n: list1){
                listToReturn.add(n);
            return listToReturn;
            }
        }
        Iterator iter1 = list1.iterator();
        Iterator iter2 = list2.iterator();
        int i = (int)iter1.next();
        int j = (int)iter2.next();
        while (iter1.hasNext() && iter2.hasNext()){
            if(i<=j){
                listToReturn.add(i);
                i = (int)iter1.next();
            }
            else{
                listToReturn.add(j);
                j = (int)iter2.next();
            }
        }
        if(iter1.hasNext()){
            if(i>j){
                listToReturn.add(j);
                listToReturn.add(i);
                while(iter1.hasNext()){
                    listToReturn.add((int)iter1.next());
                }
            }
        }
        else{
            if(j>i){
                listToReturn.add(i);
                listToReturn.add(j);
                while(iter2.hasNext()){
                    listToReturn.add((int)iter2.next());
                }
            }
        }
        long finish = System.nanoTime();
        System.out.println(finish-start);
        return listToReturn;
        }
}