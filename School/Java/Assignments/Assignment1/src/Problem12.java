public class Problem12 {
    public static String stateOfMatter(double t, char u){
        String unit = "" + u;
        if (unit.equals("F")){
            if (t <= 32){
                return "solid";
            }
            else if (t > 32 && t < 212){
                return "liquid";
            }
            else{
                return "gas";
            }
        }
        else{
            if (t <= 0){
                return "solid";
            }
            else if (t > 0 && t < 100){
                return "liquid";
            }
            else{
                return "gas";
            }
        }
    }
}
