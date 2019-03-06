import static java.lang.System.arraycopy;
import static java.lang.Math.floorDiv;

public class Notebook {

    private Record[] aNotebook;
    /*Here we place current value of the latest record in the array which is filled in. Adding a record increases the index by 1, removing a record decreases it.*/
    private int lastRecord;

    public void Notebook(Record rec) {

        aNotebook = new Record[100];

        if (rec == null) {

            Record curRec = new Record();
            rec = curRec.populateRecord();

        }

        aNotebook[0] = rec;
        lastRecord = 1;

    }

    public void setNotebook(Record[] notebook) {

        this.aNotebook = notebook;
    }

    public Notebook addRecord(Record rec) {

        if (rec == null) {
            System.out.println("Cannot add null record to the notebook.");
            return this;
        }

        int len = aNotebook.length;
        int newLen = len;

        if (lastRecord == len) {

            newLen = (int) (len * 1.5);

        }

        Record[] newNotebook = new Record[newLen];

        arraycopy(aNotebook, 0, newNotebook, 0, len - 1);

        newNotebook[len] = rec;
        lastRecord++;

        arraycopy(newNotebook,0, aNotebook, 0 , newLen);

        return this;
    }

    public int findRecord(String phoneNumber) {

        /*
         * We try to find index of the record in the notebook array using unique ID which is the phone number.
         *
         * If nothing is found return -1.*/

        int len = this.aNotebook.length;
        /*We will return -1 in case if nothing is found.*/
        int res = -1;

        for (int i = 0; i < len; i++) {

            Record curRec = aNotebook[i];

            if (curRec.getPhoneNumber().equals(phoneNumber)) {
                res = i;
            }
        }
        return res;
    }

    public Notebook removeRecord(String phoneNumber) {

        int recIndex = this.findRecord(phoneNumber);

        if (recIndex == -1) {

            System.out.println("Cannot remove the record with phone number " + phoneNumber + "because it is not found.");
            return this;
        }
        int len = aNotebook.length;
        int newLen = len;

        if (lastRecord == floorDiv(len, 2)) {
            newLen = (int) (len * 0.75);
        }

        Record[] newNotebook = new Record[newLen];

        arraycopy(aNotebook, 0, newNotebook, 0, recIndex - 1);
        arraycopy(aNotebook, recIndex + 1, newNotebook, recIndex, len - recIndex);

        lastRecord--;

        arraycopy(newNotebook,0, aNotebook, 0 , newLen);

        return this;
    }

    public Notebook editRecord(String phoneNumber, Record newRecord) {

        if (newRecord == null) {
            System.out.println("Cannot replace a record with null.");
            return this;
        }

        int recIndex = findRecord(phoneNumber);

        if (recIndex == -1) {
            System.out.println("Cannot edit the record with phone number " + phoneNumber + "because it is not found.");
            return this;
        }

        aNotebook[recIndex] = newRecord;

        return this;
    }

    public void showAllRecords(){

        for (Record curRec : aNotebook) {
            if (curRec != null) {
                System.out.println(curRec.toString());
            }
        }
    }
}
