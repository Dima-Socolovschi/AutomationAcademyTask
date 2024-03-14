import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

//        String text = "We have text. Text we; have. Have, we -text. About! all.";
//        String text = "dr. dr. dr";
//        String text = "";
//        String text = "test test";
//        String text = "2. 2. 2. 2. 3. . ... 5 . 5 . .. ... 7.";
        String text = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";

        String[] words = new String[0];
        boolean noRepeatedWords = true;
        
        if(text.contains(".")){
            words = text.substring(text.indexOf("."))
                    .replaceAll("[;!@#$%^&*()_+=/.,~-]", "")
                    .toLowerCase()
                    .split("\\s");
        }

        Map<String, Integer> wordsCounter = new HashMap<>();
        
        for (String w : words) {
            if (wordsCounter.containsKey(w)) {
                wordsCounter.put(w, wordsCounter.get(w)+1);
            } else if (!w.isEmpty()){
                wordsCounter.put(w, 1);
            }
        }

        for (Map.Entry<String, Integer> e : wordsCounter.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println("Word " + "'" + e.getKey() + "'" + " is repeated " + e.getValue() + " time/times.");
                noRepeatedWords = false;
            }
        }

        try {
            if (noRepeatedWords) {
                throw new Exception("There are no repeated words in text.");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
