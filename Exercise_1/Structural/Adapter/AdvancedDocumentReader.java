package Exercise_1.Structural.Adapter;

public interface AdvancedDocumentReader {
    void readDocx(String fileName);
    void readTxt(String fileName);
}