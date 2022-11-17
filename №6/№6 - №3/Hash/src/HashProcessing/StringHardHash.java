package HashProcessing;


public class StringHardHash implements StringProcessing {

    @Override
    public int hash(String str) {

        int result = 0;
        for(int i = 0; i < str.length(); i++) {
            result += ( (int) str.charAt(i) * i);
        }
        return result;
    }
}
