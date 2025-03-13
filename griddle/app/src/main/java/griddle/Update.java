
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.Scanner;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

public class Update{
    public void update_one(){
        String uri = "mongodb+srv://dalphin64:gamerdude420@thebestclustertoeverexi.espjq.mongodb.net/?retryWrites=true&w=majority&appName=TheBestClusterToEverExist";
        Scanner scanner = new Scanner(System.in);

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ShopLand");
            MongoCollection<Document> collection = database.getCollection("Products");
            //doc to update
            System.out.println("please type title of product to change")
            String selected_title = scanner.nextLine();
            Document query = new Document().append("title",  selected_title);
            // Creates instructions to update the values of three document fields
            Bson updates = Updates.combine(
                    //new values
                    );
            // Instructs the driver to insert a new document if none match the query
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                // Updates the first document that has a "title" value of "Cool Runnings 2"
                UpdateResult result = collection.updateOne(query, updates, options);
                // Prints the number of updated documents and the upserted document ID, if an upsert was performed
                System.out.println("Modified document count: " + result.getModifiedCount());
                System.out.println("Upserted id: " + result.getUpsertedId());
            
            // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        }
    }
}

        /*String uri = "mongodb+srv://dalphin64:gamerdude420@thebestclustertoeverexi.espjq.mongodb.net/?retryWrites=true&w=majority&appName=TheBestClusterToEverExist";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ShopLand");
            MongoCollection<Document> collection = database.getCollection("Products");
            Document query = new Document().append("title",  "Cool Runnings 2");
            // Creates instructions to update the values of three document fields
            Bson updates = Updates.combine(
                    Updates.set("runtime", 99),
                    Updates.addToSet("genres", "Sports"),
                    Updates.currentTimestamp("lastUpdated"));
            // Instructs the driver to insert a new document if none match the query
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                // Updates the first document that has a "title" value of "Cool Runnings 2"
                UpdateResult result = collection.updateOne(query, updates, options);
                // Prints the number of updated documents and the upserted document ID, if an upsert was performed
                System.out.println("Modified document count: " + result.getModifiedCount());
                System.out.println("Upserted id: " + result.getUpsertedId());
            
            // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        }*/