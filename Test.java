实现无冗余地接受两个字符串，然后把它们无冗余的连接起来。
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s=str.split(" ");
        String ss="";
        for(String res:s){
            ss+=res;
        }
        System.out.println(ss);
        sc.close();
    }
}
给一个字符类型的数组chas和一个整数size，
请把大小为size的左半区整体右移到右半区，右半区整体移动到左边。
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        String str=sc.next();
        if(k<=0||str.length()<=0){
           System.out.println("");
        }else{
            k%=str.length();
        System.out.println(func(str,k));
        }
        sc.close();
    }
    
    public static String reverse(String str,int start,int end){
        char[] arr=str.toCharArray();
        while(start<end){
            char tmp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=tmp;
        }
        return new String(arr);
    }
    
    public static String func(String str,int k){
        str=reverse(str,0,k-1);
        str=reverse(str,k,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }
}

给定字符类型的数组chas，请在单词间做逆序调整。只要做到单词的顺序逆序即可，对空格的位置没有要求。
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(str==null){
            System.out.println("");
        }else{
            System.out.println(reverse(str));
        }
    }
    
    public static String reverse(String str){
        char[] res=str.toCharArray();
        int l=0;
        int r=0;
        for(int i=0;i<res.length;i++){
            l=i;
            while(i!=res.length&&res[i]!=' '){
                i++;
            }
            r=i-1;
            while(l<r){
                char tmp=res[l];
                res[l++]=res[r];
                res[r--]=tmp;
            }
        }
        return new String(res);
    }
}

