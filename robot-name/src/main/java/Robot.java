import java.util.*;

class Robot{
    private static final GenerateRandomNumber randomNames = new GenerateRandomNumber();
    private static String name;
    public Robot(){
        reset();
    }

    public static String getName(){
        return name;
    }
    public void reset(){//Temporal -- Debo ver si funciona o sino implementarlo
        name = randomNames.generateName();
    }

    private static class GenerateRandomNumber {
        private final Set<String> usedNames = new HashSet<>();
        private final Random random = new Random();
        private String generateName(){
            String name;
            do {
                name = ""+(char)('A'+ random.nextInt(26))+(char)('A'+random.nextInt(26))
                        + (random.nextInt(10)) + (random.nextInt(10))
                        +(random.nextInt(10));
            }while (usedNames.contains(name));

            usedNames.add(name);
            return name;
        }
    }
}