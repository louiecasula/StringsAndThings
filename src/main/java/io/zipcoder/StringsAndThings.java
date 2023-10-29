package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String[] words = input.toLowerCase().split(" ");
        int count = 0;

        for (String word : words) {
            int finalIndex = word.length() - 1;
            char finalChar = word.charAt(finalIndex);
            if (finalChar == 'y' || finalChar == 'z') {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.toLowerCase().replace(remove.toLowerCase(), "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCount = 0, notCount = 0;
        String is = "is";
        String not = "not";
        int length = input.length();

        for (int i = 0; i <= length - is.length(); i++) {
            int j;
            for (j = 0; j < is.length(); j++) {
                if (input.charAt(i + j) != is.charAt(j)) {
                    break;
                }
            }
            if (j == is.length()) {
                isCount++;
                j = 0;
            }
        }

        for (int i = 0; i <= length - not.length(); i++) {
            int j;
            for (j = 0; j < not.length(); j++) {
                if (input.charAt(i + j) != not.charAt(j)) {
                    break;
                }
            }
            if (j == not.length()) {
                notCount++;
                j = 0;
            }
        }

        System.out.printf("is: %d, not: %d", isCount, notCount);
        if (isCount == notCount) return true;
        else return false;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean happy = true;
        String[] charArray = input.split("");

        for (int i = 0; i <= input.length() - 1; i++) {
            if ((charArray[i].equals("g")) && (charArray[i + 1].equals("g"))) {
                System.out.println("HAPPY " + i);
                i++;
            }
            else if ((charArray[i].equals("g")) && (!charArray[i + 1].equals("g"))){
                happy = false;
                System.out.println("UNHAPPY " + i);
                break;
            }
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int length = input.length();
        int sum = 0;

        for (int i = 0; i <= length - 3; i++) {
            char first = input.charAt(i);
            char second = input.charAt(i + 1);
            char third = input.charAt(i + 2);
            if (first == second && first == third) {
                sum++;
            }
        }
        return sum;
    }
}
