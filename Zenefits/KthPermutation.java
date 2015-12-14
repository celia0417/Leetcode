package Zenefits;

public class KthPermutation {
	// m: H counts, n: V counts, k: kth sequence to get
    public static String sequence(int m, int n, int k){
            int i,c,l=m+n;
            i=0;
            char[] arr = new char[l];
            while(k>0){
                    c = combinatorialNumber(l-i-1, n);
                    if(c<=k){ //if k is larger or equal than combinatorial number C(l-i, n), this position should pick V
                            arr[i]='V';
                            k-=c; //update k if V is picked
                            n--; // total count of V 
                    } else { // if k is smaller than combinatorial number, this position cannot be V, in other words, should be H
                            arr[i]='H';
                            m--; //total count of m
                    }
                    i++; //shift to the next position
            }
            
            // Out of the loop, means to find 0th sequence. In that case, just put all 'H' following all 'V'
            while(m>0){
                    arr[i++]='H';
                    m--;
            }
            while(n>0){
                    arr[i++]='V';
                    n--;
            }
            return new String(arr);
    }

    public static int combinatorialNumber(int n, int k){
            long ret = 1;
            for(int i=0;i<k;i++){
                    ret*=n-i;
                    ret/=i+1;
            }
            return (int)ret;
    }
    //Main
    public static void main(String[] args){
            System.out.println(sequence(1, 1, 0));
            System.out.println(sequence(2, 2, 0));
            System.out.println(sequence(2, 2, 5));
    }
}
