import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class StackLanguage {

    private static class Command{
        private final String CMD;
        private final List<String> ARGS;
        private Command(String cmd, List<String> args) {
            CMD = cmd;
            ARGS = args;
        }
    }
    private final List<Command> CMD_LIST;
    private final Deque<Double> STACK;

    StackLanguage() {
        this.CMD_LIST = new ArrayList<>();
        this.STACK = new ArrayDeque<>();
    }

    /**
     * reads stack commands from a file.
     * @param f the file you want to check
     */
    void readFile(String f) {
        try(BufferedReader b = new BufferedReader(new FileReader(f))){
            String l = null;
            while((l = b.readLine()) != null){
                String[] comps = l.split(" ");
                String cmd = comps[0];
                List<String> args = Arrays.stream(comps).toList().stream().skip(1).toList();
                this.CMD_LIST.add(new Command(cmd,args));
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Interperets the list of instructions
     * @return does all the instructions
     */
    double interpret() {
        Map<String,Double> env = new HashMap<>();
        for(Command c : this.CMD_LIST){
            List<String> a = c.ARGS;
            switch(c.CMD){
                case "DECL" -> env.put(a.get(0),Double.parseDouble(a.get(1)));
                case "PUSH" -> this.STACK.push(Double.parseDouble(a.get(0)));
                case "POP" -> env.put(a.get(0), this.STACK.pop());
                case "PEEK" -> {
                    if(!env.containsKey(a.get(0))) {
                        throw new IllegalArgumentException("PEEK: err " + a.get(0));
                    }
                    else{
                        env.put(a.get(0),this.STACK.peek());
                    }
                }
                case "ADD" -> {
                    double tos = this.STACK.pop();
                    this.STACK.push(tos + Double.parseDouble(a.get(0)));
                }
                case "SUB" -> {
                    double tos = this.STACK.pop();
                    this.STACK.push(tos - Double.parseDouble(a.get(0)));
                }
                case "XCHG" -> {
                    if(!env.containsKey(a.get(0))){
                        throw new IllegalArgumentException("XCHG: err " + a.get(0));
                    }
                    else{
                        double tos = this.STACK.pop();
                        this.STACK.push(env.get(a.get(0)));
                        env.put(a.get(0),tos);
                    }
                }
                case "DUP" -> this.STACK.push(this.STACK.peek());
                default ->
                    throw new IllegalArgumentException("interpret: bad cmd type " + c.CMD);
            }
        }
        if(this.STACK.isEmpty()){
            throw new NoSuchElementException("interpret: empty stack");
        }
        else{
            return this.STACK.peek();
        }
    }
}
