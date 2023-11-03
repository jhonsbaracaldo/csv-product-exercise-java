import java.util.List;
public class Main {
    public static void main(String[] args) {
        productService productServic = new productService();

        // Cargar productos desde un archivo CSV
        productServic.cargarProductosDesdeCSV("C:\\Users\\Mauricio\\IdeaProjects\\csv-reader-java\\resources\\inventory.csv");

        // Obtener la lista de productos
        List<Product> productos = productServic.obtenerProductos();
        productServic.anadirproducto();

        // Imprimir la lista de productos
        for (Product producto : productos) {
            System.out.println("Name: " + producto.getName());
            System.out.println("Description: " + producto.getDescription());
            System.out.println("Category: " + producto.getCategory());
            System.out.println("Label: " + producto.getLabel());
            System.out.println("Price: " + producto.getPrice());
            System.out.println("URL: " + producto.getUrl());
            System.out.println();
       }

    }
}