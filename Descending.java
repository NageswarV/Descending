import java.util.*;
class mainClass {
        public static void main(String args[] ) throws Exception {
        Scanner scan=new Scanner(System.in);
        int n,i,k;
        n=scan.nextInt();
        k=scan.nextInt();
        int array[]=new int[n];
        for(i=0;i<n;i++)
        {   
        array[i]=scan.nextInt();
        }
        Descending desc=new Descending();
        String result=desc.orderByWeight(array,n,k);
        System.out.println(result);
    }
}
class Descending{
    public static String orderByWeight(int[] array,int n,int k){
    String[] str=new String[k];
    int i;
    StringBuffer result=new StringBuffer();
    for(i=0;i<k;i++)
    str[i]="";
    for(i=0;i<n;i++)
    {   
        str[array[i]%k]+=array[i]+ " ";
    }
    
    while(k>0)
    {   k--;
        int[] arr = Arrays.stream(str[k].substring(0, str[k].length()-1).split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);
        str[k]="";
    for(int j=0;j<arr.length;j++)
        str[k]+=arr[j]+" ";
        result.append(str[k]);
    }
    return new String(result);
    }
}
