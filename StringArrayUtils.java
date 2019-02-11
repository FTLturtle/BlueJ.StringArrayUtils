import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length -1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length -2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        for (String s : array) {
            if (s.equals(value)){
                return true;
            }
        }

        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String temp = "";
        for (int i = 0; i < array.length / 2; i++){
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        for (int i = 0; i < array.length / 2; i++){
            if (! array[i].equals(array[array.length - i - 1])){
                return false;
            }
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
                'x', 'y', 'z'};
        boolean letterFound = false;

        for (char c : alphabet) {
            letterFound = false;
            for (String s : array) {
                if (s.toLowerCase().contains("" + c)){
                    letterFound = true;
                    break;
                }
            }

            if (! letterFound){
                return false;
            }
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        int start;
        int index;

        for (String s : array){
            index = s.indexOf(value);

            while (index != -1){
                count++;
                start = index + 1;
                index = s.indexOf(value, start);
            }

        }

        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        while(arrayList.remove(valueToRemove)){ }
        /* NOTE: this works because the remove(object) method returns true if the object 
        is present and false otherwise */

        return arrayList.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        int i = 1;

        while (i < arrayList.size()) {
            if (arrayList.get(i).equals(arrayList.get(i - 1))){
                arrayList.remove(i);
                i--;
            }
            i++;
        }

        return arrayList.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(arrayList.get(0));
        
        for (int i = 1; i < arrayList.size(); i++){
            if (arrayList.get(i).equals(arrayList.get(i -1))){
                arrayList2.set(arrayList2.size() - 1, arrayList2.get(arrayList2.size() - 1) + arrayList.get(i));
            } else {
                arrayList2.add(arrayList.get(i));
            }
        }
        
        return arrayList2.toArray(new String[0]);
    }
}
