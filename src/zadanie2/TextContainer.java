package zadanie2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "C:\\iasko\\IdeaProject\\untitled\\saved")
public class TextContainer {
    private String text;
    public TextContainer(String text) {
        this.text = text;
    }
    @Saver
    public void save(String path) throws IOException {
        try(BufferedWriter writer  = new BufferedWriter(new FileWriter(path))){
            writer.write(text);
        }
    }


}
