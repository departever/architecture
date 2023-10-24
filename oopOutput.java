import java.util.*;
import java.io.*;

public class oopOutput {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;

    public oopOutput(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void output(String filename){
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
