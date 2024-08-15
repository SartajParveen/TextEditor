import notepad.Notepad;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Notepad notepad = new Notepad(5);

        do{
            System.out.println("Choose your option");
            System.out.println("1. Display the text");
            System.out.println("2. Display the text from given lines");
            System.out.println("3. Insert the text");
            System.out.println("4. Insert Multiple lines of text");
            System.out.println("5. Delete the text");
            System.out.println("6. Delete from given lines");
            System.out.println("7. Copy the text");
            System.out.println("8. Paste the text");
            System.out.println("9. Undo your action");
            System.out.println("10. Redo your action");
            System.out.println("11. Exit");

            System.out.println("Enter the choice");
            int choice = sc.nextInt();
            int lineNumber = 0;

            switch(choice) {
                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("Enter the starting line and ending line value: ");
                    int startLine = sc.nextInt();
                    int endLine = sc.nextInt();
                    notepad.display(startLine, endLine);
                    break;
                case 3:
                    System.out.println("Enter the text: ");
                    String text = sc.next();
                    System.out.println("Enter the line number: ");
                    lineNumber = sc.nextInt();
                    notepad.insertLine(lineNumber, text);
                    break;
                case 4:
                    System.out.println("Enter the line number: ");
                    lineNumber = sc.nextInt();
                    System.out.println("Enter no.of lines");
                    int n = sc.nextInt();
                    String[] textArr = new String[n];
                    for(int i=0; i<n; i++){
                        textArr[i] = sc.next();
                    }
                    notepad.insertLine(lineNumber, textArr);
                    break;
                case 5:
                    System.out.println("Enter the line number: ");
                    lineNumber = sc.nextInt();
                    notepad.delete(lineNumber);
                    break;
                case 6:
                    System.out.println("Enter the starting line and ending line value: ");
                    startLine = sc.nextInt();
                    endLine = sc.nextInt();
                    notepad.delete(startLine, endLine);
                    break;
                case 7:
                    System.out.println("Enter the starting line and ending line value: ");
                    startLine = sc.nextInt();
                    endLine = sc.nextInt();
                    notepad.copy(startLine, endLine);
                    break;
                case 8:
                    System.out.println("Enter the line number: ");
                    lineNumber = sc.nextInt();
                    notepad.paste(lineNumber);
                    break;
                case 9:
                    notepad.undo();
                    break;
                case 10:
                    notepad.redo();
                    break;
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");

            }
        }while(true);
    }
}
