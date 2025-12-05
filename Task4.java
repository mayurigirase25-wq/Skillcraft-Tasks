import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class ProductScraper {

    public static void main(String[] args) {

        // Replace with your target website URL
        String url = "https://example.com/products";

        try {
            // Connect to website
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();

            // Select product container (change CSS selectors based on website)
            Elements products = doc.select(".product-card");

            // Create CSV file
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Product Name,Price,Rating\n");

            // Loop through each product
            for (Element product : products) {

                String name = product.select(".product-title").text();
                String price = product.select(".product-price").text();
                String rating = product.select(".product-rating").text();

                csvWriter.append(name).append(",");
                csvWriter.append(price).append(",");
                csvWriter.append(rating).append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Product data extracted and saved to products.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
