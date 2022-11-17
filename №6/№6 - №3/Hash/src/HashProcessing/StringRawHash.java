package HashProcessing;


public class StringRawHash implements StringProcessing {

    @Override
    public int hash(String str) {

        String str_hash = Integer.toString(str.hashCode());
        System.out.println("Хеш строки: "+ str_hash);

        int count = 0;
        for(int i = 0; i < str_hash.length(); i++) {
            count++;
        }
        return count;
    }
}
