package Exercise_1.Structural.Adapter;

public class DocumentAdapter implements DocumentReader {
    AdvancedDocumentReader advancedReader;

    public DocumentAdapter(String fileType) {
        if (fileType.equalsIgnoreCase("docx")) {
            advancedReader = new DocxReader();
        } else if (fileType.equalsIgnoreCase("txt")) {
            advancedReader = new TxtReader();
        }
    }

    @Override
    public void read(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("docx")) {
            advancedReader.readDocx(fileName);
        } else if (fileType.equalsIgnoreCase("txt")) {
            advancedReader.readTxt(fileName);
        }
    }
}

