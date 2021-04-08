import java.io.*;
import java.util.*;

public class bigrams {

    static void getBigrams(String fileName, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        String word2 = "";
        while (file.hasNext()){
            String word1 = word2;
            word2 = file.next();
            String word = word1 + " " + word2;
            Integer count = words.get(word);
            if (count != null){
                count++;
            }
            else
                count = 1;
            words.put(word, count);
        }
        file.close();
    }

    static int getMaxOccurrence(Map<String, Integer> words){
        int max = 1;
        for (Map.Entry<String, Integer> word: words.entrySet()){
            if (word.getValue() > max){
                max = word.getValue();
            }
        }
        return max;
    }



    public static void main(String [] args) throws FileNotFoundException {
        Map<String, Integer> words = new HashMap<String, Integer>();
        getBigrams("D:\\Projects\\test\\123.txt", words);
        int max = getMaxOccurrence(words);
        for (Map.Entry<String, Integer> word: words.entrySet()){
            if (word.getValue() == max){
                System.out.println(word);
            }
        }
        boolean found = false;
        for(int i = 0; i <19;) {
            for (Map.Entry<String, Integer> word: words.entrySet()) {
                if (word.getValue() == max - 1 == true){
                    //the next if statement is to make sure only 20 results will be printed if there are many results with the same occurrence
                    // if removed, more than 20 result might be printed because they all have the same occurrence
                    if(i<19){
                        System.out.println(word);
                        found = true;
                        i++;
                    }

                }
            }
            if(found == true){
                found = false;
            }
            max = max - 1;
        }
    }
}
