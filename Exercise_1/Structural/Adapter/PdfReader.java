package Exercise_1.Structural.Adapter;

public class PdfReader implements DocumentReader {
    DocumentAdapter adapter;

    @Override
    public void read(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("pdf")) {
            System.out.println("Reading PDF file: " + fileName);
        }
        else if (fileType.equalsIgnoreCase("docx") || fileType.equalsIgnoreCase("txt")) {
            adapter = new DocumentAdapter(fileType);
            adapter.read(fileType, fileName);
        }
        else {
            System.out.println("Invalid file type: " + fileType + " not supported");
        }
    }
}
