package Exercise_1.Structural.Adapter;


public class Main {
    public static void main(String[] args) {
        PdfReader reader = new PdfReader();

        reader.read("pdf", "research_paper.pdf");
        reader.read("docx", "assignment.docx");
        reader.read("txt", "notes.txt");
        reader.read("xls", "data.xls");
    }
}

