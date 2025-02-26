package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String dest) {
        var futureContent1 = readFile(file1);
        var futureContent2 = readFile(file2);

        return futureContent1.thenCombine(futureContent2, (content1, content2) -> {
            try {
                Path destPath = Paths.get(dest);
                Files.write(destPath, (content1 + content2).getBytes(), StandardOpenOption.CREATE);
                return dest;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
        });
    }

    private static CompletableFuture<String> readFile(String file) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(file);
                return Files.readString(path);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String dir) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return Arrays.stream(new File(dir).listFiles())
                    .mapToLong(file -> file.isFile() ? file.length() : getSize(file))
                    .sum();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });
    }

    private static Long getSize(File file) {
        return file.isFile() 
            ? file.length() 
            : Arrays.stream(file.listFiles()).mapToLong(f -> getSize(f)).sum();
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var file1 = "src/main/resources/file1.txt";
        var file2 = "src/main/resources/file2.txt";
        var dest = "src/main/resources/dest.txt";

        unionFiles(file1, file2, dest).get();
        // END
    }
}

