package Exercise_1.Structural.Adapter;

public class DocxReader implements AdvancedDocumentReader {
    @Override
    public void readDocx(String fileName) {
        System.out.println("Reading Word document: " + fileName);
    }

    @Override
    public void readTxt(String fileName) {
        // Do nothing
    }
}
