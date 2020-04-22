import java.util.Scanner;
class palindrom {

    public static boolean palindrom(String str) {
        str = str.toLowerCase();
        int i = 0;
        int j = str.length()-1;
        while (i <= j) {
            //!(a-z) skip
            if(!(str.charAt(i)>='a'&&str.charAt(i)<='z'))
                i++;
            if(!(str.charAt(j)>='a'&&str.charAt(j)<='z')){
                j--;
            }else if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else {
                // System.out.println("i"+str.charAt(i));
                // System.out.println("j"+str.charAt(j));
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter string: ");
        String str = scan.nextLine();
        System.out.println(palindrom(str));
    }
}