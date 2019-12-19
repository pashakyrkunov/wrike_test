public class MailGenerator {

    public static String generateMail() {
        StringBuilder result = new StringBuilder();
        int count = (int)(Math.random() * 10);
        for(int i = 0; i < count; i++) {
            result.append((char)('a' + Math.random() * 25 ));
        }
        result.append("+wpt@wriketask.qaa");
        return result.toString();
    }

}


