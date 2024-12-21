import java.util.List;

public class Problem9 {
    /**
     * This method take a list and returns its values as a comma separated string
     * @param l the list you want to stringify
     * @return the list l as a comma separated string
     * @param <T> generic object
     */
    public static <T> String stringifyList(List<T> l){
        String holder = "";
        for(int i = 0; i < l.size() - 1;i++){
            holder += l.get(i).toString() + ",";
        }
        return holder + l.getLast().toString();
    }

}
