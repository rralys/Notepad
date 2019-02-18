import Record.*;
import System;

public class Notebook {

    private Record[] aNotebook;

    public void setNotebook(Record[] Notebook) {
        this.aNotebook = aNotebook;
    }

    public Notebook addRecord(Record rec) {
        int len = aNotebook.length;

        Record newNotebook [len + 1];

        arraycopy(aNotebook, 0, newNotebook, 0, len - 1);

        newNotebook[len] = rec;

        return newNotebook;
    }

    public Notebook removeRecord(Record rec) {
        int len = aNotebook.length;

        Record newNotebook [len - 1];

        arraycopy(aNotebook, 0, newNotebook, 0, len - 1);

        newNotebook[len] = rec;

        return newNotebook;
    }
}
