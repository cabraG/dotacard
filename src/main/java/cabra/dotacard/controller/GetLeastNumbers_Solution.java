package cabra.dotacard.controller;

import java.util.*;



public class GetLeastNumbers_Solution {
    public ArrayList<Integer> getLeastNumbers_Solution(ArrayList<Integer> input, int k) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> maxlist = new ArrayList();
        ArrayList<Integer> inlist = new ArrayList();
        ArrayList<Integer> indexlist = new ArrayList();
        if(input.size() == 0 || input == null || k > input.size() || k == 0) {
            return list;
        }

        for(int i = 0;i < k;i ++) {
            list.add(input.get(i));
        }
        for(int i = 0;i < k;i ++) {
            maxlist.add(input.get(i));
        }
        for(int i = 0;i < k;i ++) {
            inlist.add(input.get(i));
        }


        for(int i = k;i < input.size();i ++) {

            int index = getMaxIndex(list);
            if(input.get(i)< list.get(index)) {
                list.set(index, input.get(i));
                inlist.set(index,i);

            }

        }
        for(int x=0;x<k;x++){

            if(inlist.get(x)==input.get(x)){
                indexlist.add(x);
            }
            else
                indexlist.add(inlist.get(x));
        }
        for(int i = k;i < input.size();i ++) {
            int index = getMinIndex(maxlist);
            if(input.get(i) > maxlist.get(index)) {
                maxlist.set(index, input.get(i));
                inlist.set(index,i);
            }
        }


        for(int x=0;x<k;x++){

            if(inlist.get(x)==indexlist.get(x)){
                indexlist.add(x);
            }
            else
                indexlist.add(inlist.get(x));
        }

        return indexlist;
    }


    public int getMinIndex(ArrayList<Integer> list) {
        int init = list.get(0);
        int index = 0;
        for(int i = 1;i < list.size();i ++) {
            if(list.get(i) < init) {
                init = list.get(i);
                index = i;
            }
        }

        return index;
    }

    public int getMaxIndex(ArrayList<Integer> list) {
        int init = list.get(0);
        int index = 0;
        for(int i = 1;i < list.size();i ++) {
            if(list.get(i) > init) {
                init = list.get(i);
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] list = {1,1,1,1,1,1,1,1,1,1};
        ArrayList<Integer> input = new ArrayList();
     for(int i=0;i<list.length;i++) {
               input.add(list[i]);
     }
        int k = 2;

        ArrayList<Integer> glist = new GetLeastNumbers_Solution().getLeastNumbers_Solution(input, k);
        for(int i : glist) {
            System.out.print(i + " ");
        }

    }
}