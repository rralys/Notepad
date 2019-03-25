import static java.lang.System.arraycopy;
import static java.lang.Math.floorDiv;

public class Notebook {
    private final int INITIAL_LEN = 100;
    private final float INC_VALUE = 1.5f;
    private final float DEC_VALUE = 0.75f;

    private Record[] aNotebook;
    /*Here we place current value of the latest record in the array which is filled in. Adding a record increases the index by 1, removing a record decreases it.*/
    private int lastRecord;

    public Notebook(Record rec) {

        aNotebook = new Record[INITIAL_LEN];

        if (rec == null) {

            System.out.println("Cannot initialize the notebook with null record.");

        }

        aNotebook[0] = rec;
        lastRecord = 1;

    }

    public void setNotebook(Record[] notebook) {

        lastRecord = getLastRecordIndex(notebook); /*find the last record index of the new notebook.*/

        arraycopy(notebook, 0, aNotebook, 0, lastRecord - 1);
    }

    public Notebook addRecord(Record rec) {

        if (rec == null) {
            System.out.println("Cannot add null record to the notebook.");
            return this;
        }

        int len = aNotebook.length;
        int newLen = len;

        if (lastRecord == len-1) {

            newLen = (int) (len * INC_VALUE);

        }

        if (newLen == len) {
            lastRecord++;
            aNotebook[lastRecord-1] = rec;
        } else {
            expandNotebook(newLen, rec);
        }

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

        for (int i = 0; i < lastRecord; i++) {

            Record curRec = aNotebook[i];

            if (curRec == null) {
                break; /* we do not add null records, so if a null is reached no further actual records are present and we just return -1.*/
            }

            if (curRec.getPhoneNumber().equals(phoneNumber)) {
                res = i;
                break;
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
            newLen = (int) (len * DEC_VALUE);
        }

        Record[] newNotebook = new Record[newLen];

        int newIndex = recIndex + 1;

        arraycopy(aNotebook, 0, newNotebook, 0, recIndex);
        arraycopy(aNotebook, newIndex, newNotebook, recIndex, newLen - newIndex);

        lastRecord--;

        if (newLen < len) {
            aNotebook = new Record[newLen];
        }

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
                System.out.println(curRec);
            }
        }
    }

    public int getCurrentIndex() {
        return lastRecord;
    }

    public int getNotebookLen(){
        return aNotebook.length;
    }

    public static int getLastRecordIndex(Record[] notebook) {
        int res = 0;
        for (Record curRec : notebook) {
            if (curRec != null) {
                res++;
            } else {
                break; /*if record is null we reached the end of the actual records array, all entities past null are null as well, because we do not add null records.*/
            }
        }

        return res;
    }

    private void expandNotebook(int newLen, Record rec) {
        int len = aNotebook.length;
        Record[] newNotebook = new Record[newLen];

        arraycopy(aNotebook, 0, newNotebook, 0, len - 1);

        lastRecord++;
        newNotebook[lastRecord-1] = rec;

        aNotebook = new Record[newLen]; /*if we called the expandNotebook method, then new length is greater than old one, so no need to compare.*/

        arraycopy(newNotebook,0, aNotebook, 0 , newLen-1);
    }
}
