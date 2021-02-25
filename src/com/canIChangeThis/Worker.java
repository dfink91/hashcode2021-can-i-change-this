package com.canIChangeThis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Worker {

    public static class FileDriver {
        String f;
        HashCodeDriver d;
        FileDriver(String f, HashCodeDriver d) {
            this.f = f;
            this.d = d;
        }
    }

    ArrayList<FileDriver> fileDrivers;

    public void run() {
        System.out.println("worker runs");

        System.out.println(System.getProperty("user.dir"));
        int counter = 0;
        while (counter < fileDrivers.size()) {
            FileDriver fd = fileDrivers.get(counter);
            String file = fd.f;
            if (file != null) {
                try {
                    String fileContent = Files.readString(Path.of("in",  File.separator, file + ".txt"));
                    String[] lines = fileContent.lines().toArray(String[]::new);
                    String[] resultLines = new String[0];
                    if (fd.d != null)
                        resultLines = fd.d.run(lines);

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
