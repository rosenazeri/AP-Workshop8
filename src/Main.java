import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String getNote() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("#")) {
                break;
            }
            text.append(line).append("\n");
        }
        return text.toString();
        }
    public static void main(String[] args) throws IOException {
        Scanner x = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Add\n2 - Remove\n3 - Notes\n4 - Export\n5 - Exist");
            int num = x.nextInt();
            if (num == 5){
                return;
            }
            else if (num == 1) {
                System.out.println("Choose a word for title:");
                String title = x.next();
                System.out.println("Write your note:");
                System.out.println("Press '#' to finish or Enter to continue:");
                String note = getNote();
                boolean exist = false;
                for (AddNote addNote : AddNote.AddNoteList) {
                    if (addNote.getLabel().equals(title)) {
                        System.out.println("Duplicated Title");
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    AddNote.AddNotes(title, note, LocalDate.now());
                }
            }
            else if (num == 2) {
                AddNote.RemoveNote();
            }
            else if (num == 3) {
                AddNote.Show();
            }
            else if (num == 4) {
                AddNote.file();
            }
        }
    }
}