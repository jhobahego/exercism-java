import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House{
    String[] finalParts = {"the house that Jack built.", "the malt ", "the rat ", "the cat ", "the dog ",
            "the cow with the crumpled horn ", "the maiden all forlorn ", "the man all tattered and torn ",
            "the priest all shaven and shorn ", "the rooster that crowed in the morn ", "the farmer sowing his corn ",
            "the horse and the hound and the horn "};

    String[] firstParts = {"that lay in", "that ate", "that killed", "that worried", "that tossed", "that milked", "that kissed", "that married", "that woke", "that kept", "that belonged to"};// TODO

    String verse(int numVerse){
        return String.join("", createSongLines(numVerse));
    }

    String verses(int from, int to){
        return IntStream.rangeClosed(from, to)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    String sing() {
        List<String> verses = createSongLines(12);

        int totalLines = 12;
        int verseIndex = 0; // Initial index of song
        LinkedList<String> allSong = new LinkedList<>();
        do{
            int index = 0;
            String completedVerse = "";
            for(String verse : verses){
                if(index == verseIndex){
                    completedVerse = completedVerse.concat(verse.replaceFirst("^(.*?)\\bthe\\b", "This is the"));
                }else if(index > verseIndex){
                    completedVerse = completedVerse.concat(verse);
                }
                index++;
            }
            verseIndex++;
            allSong.addFirst(completedVerse);
        }while(verseIndex != totalLines);

//        return verses(1, 12); correct answer also.
        return String.join("\n", allSong);
    }

    List<String> createSongLines(int cantVerses) {
        LinkedList<String> allLines = new LinkedList<>();

        int actualPosition = 0;
        while (actualPosition < cantVerses) {
            if(actualPosition == cantVerses-1){
                allLines.addFirst(String.format("This is %s", finalParts[actualPosition]));
            }else {
                allLines.addFirst(firstParts[actualPosition] + " " + finalParts[actualPosition]);
            }

            actualPosition++;
        }
        return allLines;
    }

}