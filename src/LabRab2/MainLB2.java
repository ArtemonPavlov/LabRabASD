package LabRab2;

public class MainLB2 {
    public static void main(String[] args) {
        int[] skebob = {1,2,3,4};
        int[] skpos = {0,3,1,2};
        int[] skcol = {0,1,2,3};
        for(int i = 0; i < skebob.length; i++){
            boolean found = false;
            for(int pos: skpos){
                if (i == pos){
                    found = true;
                    break;
                }
            }
            if (found){
                System.out.print(skebob[i]);
            } else {
                System.out.print(0);
            }
        }
    }
}