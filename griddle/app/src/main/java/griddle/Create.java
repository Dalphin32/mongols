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

public class Create{
    public void create_product(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter product name:");
            String prod_name = scanner.nextLine();

            System.out.println("Please enter product price:");
            String prod_price = scanner.nextLine();

            System.out.println("Please enter product description:");
            String prod_desc = scanner.nextLine();

            String uri = "mongodb+srv://dalphin64:gamerdude420@thebestclustertoeverexi.espjq.mongodb.net/?retryWrites=true&w=majority&appName=TheBestClusterToEverExist";
            try (MongoClient mongoClient = MongoClients.create(uri)) {
                MongoDatabase database = mongoClient.getDatabase("ShopLand");
                MongoCollection<Document> collection = database.getCollection("Products");

                try {
                    // Inserts a sample document describing a movie into the collection
                     InsertOneResult result = collection.insertOne(new Document()
                            .append("_id", new ObjectId())
                            .append("title", prod_name)
                            .append("price", prod_price)
                            .append("description", prod_desc));
                    // Prints the ID of the inserted document
                    System.out.println("Success!\n" + "Name: "+prod_name+"\nPrice: "+prod_price+"\nDescription: "+prod_desc);
            
                // Prints a message if any exceptions occur during the operation
                } catch (MongoException me) {
                    System.err.println("Unable to insert due to an error: " + me);
                }
            }
    }
}