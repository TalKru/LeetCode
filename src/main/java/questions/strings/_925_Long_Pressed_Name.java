package questions.strings;

/*
Your friend is typing his name into a keyboard. Sometimes,
when typing a character c, the key might get long pressed,
and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.
Return True if it is possible that it was your friends name,
with some characters (possibly none) being long pressed.

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.

Constraints:
1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.
 */
public class _925_Long_Pressed_Name {

    public static void main(String[] args) {

//        String name = "jessi";
//        String typed = "jjeessi";
        String name = "alex";
        String typed = "aaleexa";

        System.out.println(isLongPressedName(name, typed));
    }


    public static boolean isLongPressedName(String name, String typed) {

        if (name.length() > typed.length()) {
            return false;
        }
        int k = 0;
        char last = ' ';

        for(int i = 0; i < typed.length(); i++){

            if(k < name.length() && name.charAt(k) == typed.charAt(i)){

                last = typed.charAt(i);
                k++;
            }
            else if(typed.charAt(i) != last) {
                return false;
            }
        }
        return (k == name.length()) ? true : false;
    }

}
