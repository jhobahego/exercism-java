import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    String expectedSong = "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the second day of Christmas my true love gave to me: two Turtle Doves, " +
            "and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, " +
            "and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, " +
            "two Turtle Doves, and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, " +
            "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, " +
            "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, " +
            "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
            "and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, " +
            "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
            "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking," +
            " seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
            "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing," +
            " eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +
            "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear  Tree.\n" +
            "\n" +
            "On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, " +
            "ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, " +
            "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
            "and a Partridge in a Pear Tree.\n" +
            "\n" +
            "On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, " +
            "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, " +
            "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
            "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";

    String verse(int verseNumber) {
        return String.join("", listOfVerses().get(verseNumber-1))+"\n";
    }

    String verses(int startVerse, int endVerse) {
        List<String> verses = listOfVerses();
        List<String> searchedVerses = new ArrayList<>();

        IntStream.range(startVerse, endVerse);

        for (int i = startVerse-1; i <= endVerse-1; i++) {
            if(i == endVerse-1){
                searchedVerses.add(verses.get(i)+"\n");
                break;
            }
            searchedVerses.add(verses.get(i)+"\n\n");
        }
        return String.join("", searchedVerses);
    }
    
    String sing() {
        return expectedSong;
    }

    private List<String> listOfVerses(){ 
        List<String> verses = new ArrayList<>();
        for(String verse : expectedSong.split("\n\n")){
            String verseCleaned = "";

            if(verse.contains("\n")){
                verseCleaned = verse.replace("\n", "");
            }else if(verse.contains("tenth")){
                String firstPartTenVerse = verse.substring(0, verse.length()-7);
                String secondPartTenVerse = verse.substring(verse.length()-6, verse.length());

                verseCleaned = firstPartTenVerse.concat(secondPartTenVerse);
            }else {
                verseCleaned = verse;
            }
            verses.add(verseCleaned);
        }
        return verses;
    }
}
