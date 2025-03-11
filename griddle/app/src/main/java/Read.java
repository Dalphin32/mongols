package griddle;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.gt;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.Scanner;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class Read{
    String uri = "mongodb+srv://dalphin64:gamerdude420@thebestclustertoeverexi.espjq.mongodb.net/?retryWrites=true&w=majority&appName=TheBestClusterToEverExist";

    public void read_one(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("select product name:");
        String prod_name = scanner.nextLine();

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ShopLand");
            MongoCollection<Document> collection = database.getCollection("Products");
            // Creates instructions to project two document fields
            Bson projectionFields = Projections.fields(
                    Projections.include("title", "price", "description"),
                    Projections.excludeId());
            // Retrieves the first matching document, applying a projection and a descending sort to the results
            Document doc = collection.find(eq("title", prod_name))
                    .projection(projectionFields)
                    .first();
            // Prints a message if there are no result documents, or prints the result document as JSON
            if (doc == null) {
                System.out.println("No results found.");
            } else {
                System.out.println(doc.toJson());
            }
        }
    }

    public void read_all(){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ShopLand");
            MongoCollection<Document> collection = database.getCollection("Products");
            // Creates instructions to project two document fields
            Bson projectionFields = Projections.fields(
                    Projections.include("title", "price", "description"),
                    Projections.excludeId());
            // Retrieves the first matching document, applying a projection and a descending sort to the results
            MongoCursor<Document> cursor = collection.find(gt("title",""))
                    .projection(projectionFields)
                    .sort(Sorts.descending("title")).iterator();
            // Prints the results of the find operation as JSON
            try {
                while(cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        }
    }
}