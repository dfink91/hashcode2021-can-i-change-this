package com.canIChangeThis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Worker {

    HashCodeDriver driver;

    public void run() {
        System.out.println("worker runs");

        System.out.println(System.getProperty("user.dir"));
        ArrayList<String> files = new ArrayList<>();
        files.add("a");
        files.add("b");
        files.add("c");
        files.add("d");
        files.add("e");
        files.add("f");
        int counter = 0;
        while (counter < files.size()) {
            String file = files.get(counter);
            if (file != null) {
                try {
                    String fileContent = Files.readString(Path.of("in",  File.separator, file + ".txt"));
                    String[] lines = fileContent.lines().toArray(String[]::new);
                    String[] resultLines = new String[0];
                    if (driver != null)
                        resultLines = driver.run(lines);

                    Path outPath = Path.of("output",  file + ".txt");
                    if (Files.notExists(outPath))
                        Files.createFile(outPath);
                    Files.writeString(outPath,
                            Arrays.stream(resultLines).collect(Collectors.joining("\n")));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            counter++;
        }
    }
}
