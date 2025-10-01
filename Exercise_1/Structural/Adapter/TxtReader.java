package Exercise_1.Structural.Adapter;

public class TxtReader implements AdvancedDocumentReader {
    @Override
    public void readDocx(String fileName) {
        // Do nothing
    }

    @Override
    public void readTxt(String fileName) {
        System.out.println("Reading Text file: " + fileName);
    }
}
