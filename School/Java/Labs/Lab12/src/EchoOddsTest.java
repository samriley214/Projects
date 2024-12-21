
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EchoOddsTest {

    @org.junit.jupiter.api.Test
    void echoOdds(){
        EchoOdds.echoOdds("file1a.in");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        try (BufferedReader b = new BufferedReader(new FileReader("file1a.out"))){
            String l = null;
            while ((l = b.readLine()) != null) {
                list1.add(Integer.parseInt(l));
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        try(BufferedReader b = new BufferedReader(new FileReader("file1a.out"))){
            String l = null;
            while((l = b.readLine()) != null){
                list2.add(Integer.parseInt(l));
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        assertEquals(list1,list2);
    }
}
