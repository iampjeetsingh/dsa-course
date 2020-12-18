package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ExtractUniqueCharacters {
    public static class Solution {
        public static String uniqueChar(String str){
            HashMap<Character, Boolean> map = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : str.toCharArray()){
                if(!map.containsKey(c)){
                    stringBuilder.append(c);
                    map.put(c, true);
                }
            }
            return stringBuilder.toString();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String takeInput() throws IOException {
        String str = br.readLine();
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(Solution.uniqueChar(str));


    }
}
