package Services;

import model.RemoveToString;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import model.Product;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class readerMavenCSV {

    public void  readerMavenCSV (){
        //1. Instanciar la clase productServicetos para poder llamar la lista
        productService productService = new productService();
        //2.Obtener la lista de productos que se encuentra en el objeto productService
        List<Product> productList = productService.getProductList();

        try {
            //3.leer el archivo CSV
            FileReader fileReader = new FileReader("C:\\Users\\acer\\IdeaProjects\\readerCSV\\csv-product-exercise-java\\resources\\inventory.csv");
            CSVParser readerCSV = new CSVParser(fileReader, CSVFormat.DEFAULT);


            boolean primeraFila = true;

            for (CSVRecord csvRecord : readerCSV) {
                if (primeraFila) {
                    primeraFila = false;
                    continue;
                }

                int codigo = Integer.parseInt(csvRecord.get(0));
                String nombre = csvRecord.get(1);
                String descripcion = csvRecord.get(2);
                String categoria = csvRecord.get(3);
                String etiqueta = csvRecord.get(4);
                double precio = Double.parseDouble(csvRecord.get(5));
                String url = csvRecord.get(6);

                Product producto = new Product(codigo, nombre, descripcion, categoria, etiqueta, precio, url);
                productList.add(producto);

                RemoveToString remove = new RemoveToString(codigo, nombre, descripcion, categoria, etiqueta, precio, url);
                System.out.println(remove);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}