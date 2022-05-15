import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Library {
    String name;
    String author;
    String genre;
    String descrip;
    public Library(String nameOfBook, String authorOfBook, String genreOfBook, String description ) {
        author = authorOfBook;
        name = nameOfBook;
        genre = genreOfBook;
        descrip = description;
    }

    public static void menu() {
        System.out.println("1 - see what books do we have,");
        System.out.println("2 - add a book,");
        System.out.println("3 - remove a book,");
        System.out.println("4 - view an info about particular book,");
        System.out.println("5 - save what books do we have in a file,");
        System.out.println("6 - quit.");
    }

    public String list() {
        return "title: " + this.name + "\nauthor: " + this.author + "\ngenre: " + this.genre + "\ndescription: " + this.descrip;
    }

    public String names() {
        return this.name;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Library> listOfBooks = new ArrayList<Library>();
        listOfBooks.add(new Library("book1", "author1", "genre1", "description1"));
        listOfBooks.add(new Library("book2", "author2", "genre2", "description2"));
        listOfBooks.add(new Library("book3", "author3", "genre3", "description3"));
        String bookToRemove;
        String bookToSee;
        String newTitle;
        String newAuthor;
        String newGenre;
        String newDescrip;
        String blankValue;
        System.out.println("Welcome in our library, choose a thing you'd like to do (write a number):");
        Library.menu();
        String input = scanner.next();
        boolean working = true;
        while (working) {
            if (input.equals("1")) {
                input = "0";
                for (int i = 0; i<listOfBooks.size(); i++) {
                    System.out.println(listOfBooks.get(i).names());
                }
                Library.menu();
                input = scanner.next();
            }else if (input.equals("2")) {
                input = "0";
                System.out.println("What's the title?");
                blankValue = scanner.nextLine();
                newTitle = scanner.nextLine();
                System.out.println("Who is the author?");
                newAuthor = scanner.nextLine();
                System.out.println("What's the genre?");
                newGenre = scanner.nextLine();
                System.out.println("What's the description?");
                newDescrip = scanner.nextLine();
                listOfBooks.add(new Library(newTitle, newAuthor, newGenre, newDescrip));
                Library.menu();
                input = scanner.next();
            }else if (input.equals("3")) {
                input = "0";
                System.out.println("Which book would you like to remove from library (write a name)?");
                for (int i = 0; i<listOfBooks.size(); i++) {
                    System.out.println(listOfBooks.get(i).names());
                }
                blankValue = scanner.nextLine();
                bookToRemove = scanner.nextLine();
                int isRemoved = 0;
                for (int i = 0; i<listOfBooks.size(); i++) {
                    if (listOfBooks.get(i).name.equals(bookToRemove)) {
                        listOfBooks.remove(i);
                        isRemoved++;
                    }
                }
                if (isRemoved==0) {
                    System.out.println("We don't have such a book!");
                }
                Library.menu();
                input = scanner.next();
            }else if (input.equals("4")) {
                input = "0";
                System.out.println("About which book would you like to see info (write it's name)?");
                for (int i = 0; i<listOfBooks.size(); i++) {
                    System.out.println(listOfBooks.get(i).names());
                }
                blankValue = scanner.nextLine();
                bookToSee = scanner.nextLine();
                int isExisting = 0;
                for (int i = 0; i<listOfBooks.size(); i++) {
                    if (listOfBooks.get(i).name.equals(bookToSee)) {
                        System.out.println(listOfBooks.get(i).list());
                        isExisting++;
                    }
                }
                if (isExisting==0) {
                    System.out.println("We don't have such a book!");
                }
                Library.menu();
                input = scanner.next();
            }else if (input.equals("5")) {
                input = "0";
                try {
                    FileWriter writer = new FileWriter("books_in_library.txt");
                    writer.write("title:" + listOfBooks.get(0).name + " author:" + listOfBooks.get(0).author + " genre:" + listOfBooks.get(0).genre + " description:" + listOfBooks.get(0).descrip + "\n");
                    for (int i=1; i<listOfBooks.size(); i++) {
                        writer.append("title:").append(listOfBooks.get(i).name).append(" author:").append(listOfBooks.get(i).author).append(" genre:").append(listOfBooks.get(i).genre).append(" description:").append(listOfBooks.get(i).descrip).append("\n");
                    }
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                Library.menu();
                input = scanner.next();
            }else if (input.equals("6")) {
                working = false;
            }else {
                input = "0";
                System.out.println("Please choose correct number:");
                Library.menu();
                input = scanner.next();
            }
        }
    }
}