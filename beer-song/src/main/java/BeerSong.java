public class BeerSong{

    String template = "%s of beer on the wall, %s of beer.\nTake %s down and pass it around, %s of beer on the wall.\n\n";

    String caseNoBottles = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy " +
            "some more, 99 bottles of beer on the wall.\n\n";
    String sing(int bottles, int to){
        StringBuilder song = new StringBuilder();
        for (int i = to; i > 0; i--) {
            if(bottles > 2){
                song.append(String.format(template, bottles+" bottles", bottles+" bottles", "one", (--bottles)+" bottles"));
                continue;
            }else if(bottles > 1) {
                song.append(String.format(template, bottles+" bottles", bottles+" bottles", "one", (--bottles)+" bottle"));
                continue;
            }
            if(bottles > 0){
                song.append(String.format(template, bottles+" bottle", bottles+" bottle", "it", "no more bottles"));
            }else{
                song.append(caseNoBottles);
            }
            bottles--;
        }

        return song.toString();
    }

    String singSong(){
        return sing(99, 100);
    }
}
