package sampler;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by heisenbug on 2020/02/16.
 */
public class FileStreamSampler {


    private void searchFile(){
        Pattern pattern = Pattern.compile("(^[0-9])");

        try {
            File tempDir = new File("./"); // NOI18N
            DirectoryStream<Path> files = Files.newDirectoryStream(tempDir.toPath());

            try {
                for (Path p : files) {
                    String fname = p.toFile().getName();
                    File[] subf = p.toFile().listFiles(a->  pattern.matcher(a.getName()).find());
                    for(File f: subf){
                        System.out.println("File name "+ f.getName());
                    }
                }
            } finally {
                files.close();
            }
        } catch (IOException ex) {
            System.err.println("deleteHeapTempFiles failed");   // NOI18N
            ex.printStackTrace();
        }
    }

    private void searchFileLambda(){
        Pattern pattern = Pattern.compile("(^[0-9])");
        //Pattern pattern = Pattern.compile("(^[A-Z])");

        File tempDir = new File("./");

        Arrays.stream(tempDir.listFiles(a-> pattern.matcher(a.getName()).find())).forEach(
            f-> {
                Arrays.stream(f.listFiles()).forEach(subf->{
                    System.out.println("File name "+ subf.getName());
                });
            }
        );
    }

    public static void main(String[] arg){

        FileStreamSampler fileStreamSampler = new FileStreamSampler();
        fileStreamSampler.searchFile();
        fileStreamSampler.searchFileLambda();

    }
}
