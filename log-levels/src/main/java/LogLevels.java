public class LogLevels {
    
    public static String message(String logLine) {
        String[] log = logLine.split(":");
        return log[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] log = logLine.split(":");
        String logFormateado = log[0].replace("[", "").replace("]", "");
        return logFormateado.toLowerCase();
    }

    public static String reformat(String logLine) {
        String[] log = logLine.split(":");
        String formatedLog = log[0].replace("[", "(").replace("]", ")");
        return (log[1].trim() + " " +formatedLog.toLowerCase());
    }

}
