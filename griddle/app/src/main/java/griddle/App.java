/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package griddle;

import static com.mongodb.client.model.Filters.eq;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Scanner;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;



public class App {

    public static void main(String[] args) {
        Create create = new Create();
        Read read = new Read();

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://dalphin64:gamerdude420@thebestclustertoeverexi.espjq.mongodb.net/?retryWrites=true&w=majority&appName=TheBestClusterToEverExist";
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] create product \n [2] view product(s)s");
        String select_method = scanner.nextLine();

        if (select_method.equals("1")){
            create.create_product();
            } else {
                System.out.println("[1] specific product \n [2] all products");
                String read_method = scanner.nextLine();
                if (read_method.equals("1")){
                    read.read_one();
                } else{
                    read.read_all();
                }
            }
    }
}
