package currencyexchange2.persistancee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class DatabaseReader implements Loader {
    
    private final String fileName;

    public DatabaseReader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Iterable<String> read() {
        return (Iterable<String>) () -> new Iterator<String>(){
            
            BufferedReader reader = createReader();
            String nextLine = nextLine();
            
            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }
            
            @Override
            public String next() {
                String line = nextLine;
                nextLine = nextLine();
                return line;
            }
            
            private BufferedReader createReader() {
                try {
                    return new BufferedReader(new FileReader(new File(fileName)));
                } catch (FileNotFoundException ex) {
                    
                    return null;
                }
            }

            private String nextLine() {
                String line;
                try {
                    line = reader.readLine();
                } catch (IOException ex) {
                    return null;
                }
                return line;
            }
        };
    }
}
    
    

