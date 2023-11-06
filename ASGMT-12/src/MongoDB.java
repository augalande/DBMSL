import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import java.util.Scanner;
import com.mongodb.ConnectionString;

public class MongoDB {
 private static MongoCollection<Document> collection;
 
 public static void main(String args[]) {
  try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
   MongoDatabase database = mongoClient.getDatabase("asgmt12");
   collection = database.getCollection("student");
   
   Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Create a document");
                System.out.println("2. Read all documents"); 
                System.out.println("3. Update a document");
                System.out.println("4. Delete a document");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        createDocument();
                        break;
                    case 2:
                     readAllDocuments(); // Call the new method to read all documents
                        break;
                    case 3:
                     updateDocument();
                        break;
                    case 4:
                     deleteDocument();
                        break;
                    case 5:
                     System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }
 
 private static void createDocument() {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter Name: ");
  String name = sc.nextLine();
  System.out.print("Enter Age: ");
  int age = sc.nextInt();
  sc.nextLine();
  System.out.print("Enter email: ");
  String email = sc.nextLine();
  
  Document document = new Document("Name",name)
    .append("Age", age)
    .append("Email", email);
  
  collection.insertOne(document);
  
  System.out.println("Inserted Document Successfully");
 }
 
 private static void readAllDocuments() {
  FindIterable<Document> documents = collection.find();
  for(Document doc:documents) {
   System.out.println(doc);
  }
 }
 
 private static void updateDocument() {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter Name to update: ");
  String name = sc.nextLine();
  System.out.println("Which field to update");
  System.out.println("1. Age");
  System.out.println("2. email");
  System.out.print("Enter choice: ");
  int ch = sc.nextInt();
  sc.nextLine();
  
  if(ch==1) {
   System.out.print("Enter new Age: ");
   int age = sc.nextInt();
   sc.nextLine();
   
   collection.updateOne(Filters.eq("Name",name), Updates.set("Age", age));
   System.out.println("Age update success");
  }
  else if(ch==2) {
   System.out.print("Enter new email: ");
   String email = sc.nextLine();
   
   collection.updateOne(Filters.eq("Name",name), Updates.set("Email", email));
   System.out.println("email update success");
  }
  else {
   System.out.println("Invalid Choice");
  }
  
 }
 private static void deleteDocument() {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter Name to delete: ");
  String name = sc.nextLine();
  
  collection.deleteOne(Filters.eq("Name",name));
  System.out.println("Delete success");
 }
}