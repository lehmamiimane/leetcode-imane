class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");

    for (int i = 0; i < words.length; i++) {
        String word = words[i].toLowerCase();

        if (word.length() > 2) {
            words[i] = Character.toUpperCase(word.charAt(0))
                    + word.substring(1);
        } else {
            words[i] = word;
        }
    }

    return String.join(" ", words);
    }
}