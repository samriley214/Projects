import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem7 {
    public static LinkedHashSet<String> largeToSmall (HashMap<String, Integer> M){
        int c = 1;
        for(int x : M.values()){
            if(x > c){
                c = x;
            }
        }
        Set<String>[] holder = new LinkedHashSet[c];
        for(int i = 0; i < holder.length;i++){
            holder[i] = new LinkedHashSet<String>();
        }
        for(String k : M.keySet()){
            //i = M.get(k);
            //holder[i - 1].add(k);
        }
        for(int i = holder.length; i > 0; i-- ){

        }
        return null;
    }

}
