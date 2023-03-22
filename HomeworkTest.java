import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkTest {
    public static void main(String[] args) throws Exception {
        greedyColoringCircle(6);
    }
    public static int[] greedyColoringCircle(int length) {
        int[] in = new int[length];
        int[] neededColors = new int[length];
        for(int i=0;i<length;i++) in[i]=i;
        List<List<Integer>> permutations =permute(in);
        for(List<Integer> x : permutations) neededColors[needed(x)-1]++;
        System.out.println(Arrays.toString(neededColors));
        return neededColors;
    }
    public static int needed(List<Integer> x){
        int s = x.size();
        int[] colors = new int[s];
        boolean[] init = new boolean[s];
        colors[x.get(0)] = 0;
        init[x.get(0)] = true;
        for(int i = 1; i<x.size(); i++){
            if((init[(x.get(i)+1)%s]) || init[(x.get(i)-1+s)%s]){
                if(init[(x.get(i)+1)%s] && init[(x.get(i)-1+s)%s]) {
                    int j=0;
                    while(j==colors[(x.get(i)+1)%s]||j==colors[(x.get(i)-1+s)%s]) j++;
                    colors[x.get(i)] = j;
                    init[x.get(i)]=true;
                }else{
                    if(init[(x.get(i)+1)%s]){
                        colors[x.get(i)] = colors[(x.get(i)+1)%s]==0 ? 1 : 0;
                        init[x.get(i)]=true;
                    }else{
                        colors[x.get(i)] = colors[(x.get(i)-1+s)%s]==0 ? 1 : 0;
                        init[x.get(i)]=true;
                    }
                }
            }else{
                colors[x.get(i)] = 0;
                init[x.get(i)]=true;
            }
        }
        int m = 0; 
        for(int i : colors) m = Math.max(i,m);
        return ++m;
    }
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> l = new ArrayList<List<Integer>>();
        for(int j = 0; j<nums.length; j++) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            t.add(nums[j]);
            l.add(t);
        }      
        for(int i = 0; i<nums.length; i++) {
            int s = l.size();
            for(int j = s-1; j>=0;j--){
                for(int k = 0; k<nums.length; k++){
                    List<Integer> a = new ArrayList<Integer>(l.get(j));
                    if(!a.contains(nums[k])){
                        a.add(nums[k]);
                        if(!l.contains(a)) l.add(a);
                    }
                }
            }    
        }
        l.removeIf((a)->a.size()!=nums.length);
        return l;
    }
}
