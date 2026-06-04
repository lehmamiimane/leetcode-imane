class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
    int counter = 0;

    for (String event : events) {
        if (counter == 10) {
            break;
        }

        switch (event) {
            case "W":
                counter++;
                break;

            case "WD":
            case "NB":
                score++;
                break;

            default:
                score += Integer.parseInt(event);
        }
    }

    return new int[]{score, counter};
    }
}