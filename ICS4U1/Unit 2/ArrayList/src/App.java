import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ArrayList<String> colours = new ArrayList<>(Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Purple"));

        colours.add(null)

        for (int i = 0; i < colours.size(); i++){
            System.out.println(colours.get(i));
        }

    }
}
