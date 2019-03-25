import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotebookTest {

    private Record rec;
    private Notebook noteBook;


@Before
    public void createNotebook() {
    rec = new Record("John", "Doe", "+10089527354");
    noteBook = new Notebook(rec);
}

@Test
    public void testAddingRecordIncreasesIndex(){
    noteBook.addRecord(rec);
    int ind = noteBook.getCurrentIndex();
    assertEquals(ind, 2);
}

@Test
    public void testRemovingRecordDecreasesIndex() {
    noteBook.addRecord(rec);
    noteBook.removeRecord("+10089527354");
    int ind = noteBook.getCurrentIndex();
    assertEquals(ind, 1);
}

@Test
    public void testFindRecordReturnsExistingPhoneNumber() {
    assertEquals(noteBook.findRecord("+10089527354"),0);

}

@Test
    public void testNewAddedRecordFoundReturnsTheAddedPhoneNumber() {
    Record rec1 = new Record("Mary", "Blind", "+3478956708");
    noteBook.addRecord(rec1);
    assertEquals(noteBook.findRecord("+3478956708"),1);

}

@Test
    public void testNoRecordFoundReturnsMinusOne() {
    assertEquals(noteBook.findRecord("+79818857467"), -1);
}

@Test
    public void testExcessiveAddingIncreasesArrayLength() {
    for (int i = 0; i < 100; i++) {
        noteBook.addRecord(rec);
    }
    noteBook.addRecord(rec);

    assertEquals(noteBook.getNotebookLen(), 150);
}

@Test
    public void testExcessiveRemoveDecreasesArrayLength(){
    for (int i = 0; i < 100; i++) {
        noteBook.addRecord(rec);
    }
    for (int i = 0; i< 61; i++){
        noteBook.removeRecord("+10089527354");
    }

    assert(noteBook.getNotebookLen()<100);
}

@Test
    public void testToStringReturnsExpectedString(){
    rec.setAddress("Nürnberg, Neuer Markt 3");
    rec.setEmail("jdoe@newmail.com");
    String str = rec.toString();
    assert(str.equals("John Doe +10089527354 jdoe@newmail.com Nürnberg, Neuer Markt 3"));
}
}