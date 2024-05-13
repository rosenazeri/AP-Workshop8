import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AddNote {
    private String label;
    private String text;
    private LocalDate creationDate;

    public AddNote(String label, String text, LocalDate creationDate) {
        this.label = label;
        this.text = text;
        this.creationDate = LocalDate.now();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static ArrayList<AddNote> AddNoteList = new ArrayList<>();

    public static void AddNotes(String label, String text, LocalDate creationDate) {
        AddNote addNote = new AddNote(label, text, creationDate);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            for (AddNote addNote1 : AddNoteList) {
                writer.write(String.valueOf(addNote1));
                writer.newLine();
            }
            System.out.println("The new note has been added successfully");
            AddNoteList.add(addNote);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public static void RemoveNote() {
        System.out.println("choose one of the notes for removing :");
        int index = 1;
        for (AddNote note : AddNoteList) {
            System.out.println( index + "- " + note.getLabel() + "       " + note.getCreationDate());
            index++;
        }
        Scanner x = new Scanner(System.in);
        int num = x.nextInt();
        if (num > 0 && num <= AddNoteList.size()) {
            AddNoteList.remove(num - 1);
            System.out.println("The note has been removed successfully");
        } else {
            System.out.println("Invalid index. Note not removed.");
        }
    }
    public static void Show(){
        System.out.println("choose one of the notes for Show :");
        int index = 1;
        for (AddNote note : AddNoteList) {
            System.out.println( index + "- " + note.getLabel() + "       " + note.getCreationDate());
            index++;
        }
        Scanner x = new Scanner(System.in);
        int num = x.nextInt();
        if (num > 0 && num <= AddNoteList.size()) {
            String str1 = AddNoteList.get(num-1).getLabel();
            System.out.println("---------------  " + str1 + " ---------------");
            String str2 = AddNoteList.get(num-1).getText();
            System.out.println(str2);
            System.out.println("printed successfully");
        } else {
            System.out.println("Invalid index. Note not removed.");
        }
    }
    public static void file() throws IOException{
        System.out.println("choose one of the notes for Show :");
        int index = 1;
        for (AddNote note1 : AddNoteList) {
            System.out.println( index + "- " + note1.getLabel() + "       " + note1.getCreationDate());
            index++;
        }
        Scanner x = new Scanner(System.in);
        int num = x.nextInt();
        if (num > 0 && num <= AddNoteList.size()) {
            String str1 = AddNoteList.get(num-1).getLabel();
            System.out.println("---------------  " + str1 + " ---------------");
            String str2 = AddNoteList.get(num-1).getText();
            System.out.println(str2);
            String fileName = str1 + ".txt";
            try(BufferedWriter in = new BufferedWriter(new FileWriter(fileName));) {
                in.write(str2);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("exported successfully");
        } else {
            System.out.println("Invalid index. Note not removed.");
        }

    }
}
