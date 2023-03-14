/*
We all know that remembering passwords is not easy, but writing down a password on a piece of paper is not secure enough. That is why you decided to write down your password in an intricate way.
The password is an n+2 characters string a1a2…an+2 and you wrote down on n separate papers all the possible three letter continuous substrings: a1a2a3,a2a3a4,…,anan+1an+2.
However, over time you forgot your original password as well as the order of the papers containing the three letter substrings. 
To make things worse, you are not even sure if you did not lose some of the papers. 
Although not a perfect check, you want to check if you can construct at least one string out of the papers you have.
*/
import java.util.*;
class week2 {
    public static int injectiveMap(char x, char y){
      int a = Character.getNumericValue(x);
      int b = Character.getNumericValue(y);
      return (a + b) * (a + b + 1) / 2 + a; //Cantor pairing function
    }
    public static void testCase() {
      short[] deg = new short[5000];
      ArrayList<LinkedList<Integer>> aq = new ArrayList<LinkedList<Integer>>();
      int n = In.readInt();
      int inv=0;
      for (int i = 0; i < 5000; i++) aq.add(new LinkedList<>());
      for (int i = 0; i < n; i++) {
        String s = In.readWord();
        inv = injectiveMap(s.charAt(0),s.charAt(1));
        int v = injectiveMap(s.charAt(1),s.charAt(2));
        deg[inv]++; 
        deg[v]--;
        aq.get(inv).add(v);
      }
      int[] count = new int[2]; 
      for (int i = 0; i < 5000; i++) {
        if (deg[i] == 1) { count[0]++; inv = i; }
        if (deg[i] == -1) count[1]++; 
        if (Math.abs(deg[i])>1) {
          count[0] = -1;
          break;}
      }
      if (count[0] == 0 && count[1] == 0 || count[0]+count[1]==2) {
        connected(inv,aq);
        for (LinkedList<Integer> i : aq) if (!i.isEmpty()) inv = -1;
        if (inv != -1) Out.println("yes");
        else Out.println("no");
      }else Out.println("no");
    }
    public static void connected(int q, ArrayList<LinkedList<Integer>> aq){ while(!aq.get(q).isEmpty()) connected(aq.get(q).poll(),aq);}
}
