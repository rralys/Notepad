import Record.*;
import System;

public class Notebook {

    private Record[] aNotebook;

    public void setNotebook(Record[] Notebook) {

        this.aNotebook = Notebook;
    }

    public Notebook addRecord(Record rec) {
        int len = aNotebook.length;

        Record newNotebook [len + 1];

        arraycopy(aNotebook, 0, newNotebook, 0, len - 1);

        newNotebook[len] = rec;

        this.aNotebook = newNotebook;

        return this;
    }

    public int findRecord(String phoneNumber) {

        /*
        * We try to find index of the record in the notebook array using unique ID which is the phone number.
        *
        * If nothing is found return -1.*/

        int len = this.aNotebook.length;
        int i;
        int res = -1;

        for (i = 0; i < len; i++) {

            Record curRec = aNotebook[i];
            String curPhoneNumber = curRec.getPhoneNumber();

            if (curPhoneNumber.equals(phoneNumber)) {
                return res = i;
            }
        }

    }

    public Notebook removeRecord(String phoneNumber) {

        int recIndex = this.findRecord(phoneNumber);

        if (i == -1) {

            System.out.println("Cannot remove the record with phone number " + phoneNumber + "because it is not found.");
            return this;
        }
        int len = aNotebook.length;

        Record newNotebook [len - 1];

        arraycopy(aNotebook, 0, newNotebook, 0, recIndex - 1);
        arraycopy(aNotebook, recIndex + 1, newNotebook, recIndex, len - recIndex);

        this.aNotebook = newNotebook;

        return this;
    }

    public Notebook editRecord(String phoneNumber, Record newRecord) {

        int recIndex = this.findRecord(phoneNumber);

        if (recIndex == -1) {
           System.out.println("Cannot edit the record with phone number " + phoneNumber + "because it is not found.");
           return this;
        }

        this.aNotebook[recIndex] = newRecord;

        return this;
    }

    public void showRecord(int recIndex){

        Record curRecord = this.aNotebook[recIndex];

        String textRecord = "";

        textRecord = textRecord.concat(curRecord.getFirstName());
        textRecord = textRecord.concat(" ");
        textRecord = textRecord.concat(curRecord.getLastName());
        textRecord = textRecord.concat(" ");
        textRecord = textRecord.concat(curRecord.getPhoneNumber());
        textRecord = textRecord.concat(" ");
        textRecord = textRecord.concat(curRecord.getEmail());
        textRecord = textRecord.concat(" ");
        textRecord = textRecord.concat(curRecord.getAddress());

        System.out.println(textRecord);
    }

    public void showAllRecords {
        int i;

        int len = this.aNotebook.length;

        for (int i = 0; i < len; i++) {

            this.showRecord(i);

        }
    }
}
