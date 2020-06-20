//joaquin neira lasala ---> 20.162.813-K
import java.util.*;
class EdadSigni{
    public static void signi(int[] false_arr,int k,int size){
        int tmp=false_arr[k-1]-false_arr[0];
        for(int i=0;i<size-k;i++){
            if(false_arr[i+k-1]-false_arr[i]<tmp)
                tmp=false_arr[i+k-1]-false_arr[i];
        }
        System.out.println(tmp);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt(),K=scanner.nextInt();
        int[] arr=new int[size];
        for(int i=0; i<size; i++)
            arr[i]=scanner.nextInt();
        Arrays.sort(arr);
        signi(arr,K,size);
    }
}