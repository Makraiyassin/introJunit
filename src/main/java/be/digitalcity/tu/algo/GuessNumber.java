package be.digitalcity.tu.algo;

public class GuessNumber {
    public static void main(String[] args) {
        int min = 5;
        int max = 1_000_000_000;
        for (int i = 0; i < 10; i++) {
            int numberToGuess = (int) (Math.random() * 999_999_996) + 5;
            System.out.println(numberToGuess);
            guessNumberWithRandom(min,max,numberToGuess);
            guessNumberWithBinarySearch(min,max,numberToGuess);
            System.out.println("----------------------------------------");
        }
    }

    public static void guessNumberWithRandom(int min, int max, int numberToGuess) {
        int guessedNumber = (int) (Math.random()*(max - min + 1))+min;
        int count = 0;
        while (guessedNumber != numberToGuess){
            count++;
            if(numberToGuess > guessedNumber){
                min = guessedNumber;
                guessedNumber = (int) (Math.random()*(max - min + 1))+min;
            }else {
                max = guessedNumber;
                guessedNumber = (int) (Math.random()*(max - min + 1))+min;
            }
        }
        System.out.println("Random method:\n win in "+count+" rounds: "+guessedNumber);
    }
    public static void guessNumberWithBinarySearch(int min, int max, int numberToGuess) {
        int guessedNumber = (max + min) / 2;
        int count = 0;
        while (guessedNumber != numberToGuess){
            count++;
            if(numberToGuess > guessedNumber){
                min = guessedNumber+1;
                guessedNumber = (max + min)/2;
            }else {
                max = guessedNumber-1;
                guessedNumber = (max + min)/2;
            }
        }
        System.out.println("Binary search method:\n win in "+count+" rounds: "+guessedNumber);
    }
}
