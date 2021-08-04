
public abstract class SalaryListCreator {

    protected Encoder encoder;

    public SalaryListCreator(Encoder encoder) {
        this.encoder = encoder;
    }

    protected abstract String doCreate(Employee[] employees);

    protected static String addZeroPrefix(String str, int length) {
        String temp = "";
        for (int i = 0; i < length - str.length(); i++) {
            temp = temp + "0";
        }
        str = temp + str;
        return str;
    }

    protected String getRecordSeparator() {
        return System.lineSeparator();
    }

    protected String getItemSeparator() {
        return " ";
    }
}
