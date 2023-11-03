import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class productService {
    private List<Product> productList;

    public productService() {
        productList = new ArrayList<>();
    }

    public void cargarProductosDesdeCSV(String archivoCSV) {
        try {
            File file = new File(archivoCSV);
            Scanner scanner = new Scanner(file);

            // Saltar la primera línea si contiene encabezados
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");

                if (campos.length == 6) {
                    String nombre = campos[0].trim();
                    String descripcion = campos[1].trim();
                    String categoria = campos[2].trim();
                    String etiqueta = campos[3].trim();
                    double precio = Double.parseDouble(campos[4].trim());
                    String url = campos[5].trim();

                    Product producto = new Product(nombre, descripcion, categoria, etiqueta, precio, url);
                    productList.add(producto);
                    //productList.stream().forEach(x-> System.out.println(x));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Product> obtenerProductos() {
        return productList;
    }
    public void anadirproducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ha elegido añadir producto");

        System.out.print("Ingrese el código del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String categoria = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String etiqueta = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese la cantidad en Stock: ");
        String url = scanner.nextLine();

        Product producto = new Product(nombre, descripcion, categoria, etiqueta, precio, url);
        productList.add(producto);

        System.out.println("Producto agregado a la Base de Datos.");
    }
}

//    public void modificarProducto() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Ingrese el código del producto que desea modificar: ");
//        String codigo = scanner.nextLine();
//
//        if (BasedeDatos.containsKey(codigo)) {
//            Producto producto = BasedeDatos.get(codigo);
//
//            // Muestra los atributos actuales del producto
//            System.out.println("________________________");
//            System.out.println("Producto actual:");
//            System.out.println("________________________");
//            System.out.println("Código: " + producto.getCodigo());
//            System.out.println("Nombre: " + producto.getNombre());
//            System.out.println("Precio: " + producto.getPrecio());
//            System.out.println("Cantidad en Stock: " + producto.getCantidad());
//
//            System.out.println("Ingrese los nuevos valores (deje en blanco para no cambiar):");
//
//            System.out.print("Nuevo código: ");
//            String nuevoCodigo = scanner.nextLine();
//            if (!nuevoCodigo.isEmpty()) {
//                producto.setCodigo(nuevoCodigo);
//            }
//
//            System.out.print("Nuevo nombre: ");
//            String nuevoNombre = scanner.nextLine();
//            if (!nuevoNombre.isEmpty()) {
//                producto.setNombre(nuevoNombre);
//            }
//
//            System.out.print("Nuevo precio: ");
//            String nuevoPrecioS = scanner.nextLine();
//            if (!nuevoPrecioS.isEmpty()) {
//                double nuevoPrecio = Double.parseDouble(nuevoPrecioS);
//                producto.setPrecio(nuevoPrecio);
//            }
//
//            System.out.print("Nueva cantidad en Stock: ");
//            String nuevaCantidadS = scanner.nextLine();
//            if (!nuevaCantidadS.isEmpty()) {
//                int nuevaCantidad = Integer.parseInt(nuevaCantidadS);
//                producto.setCantidad(nuevaCantidad);
//            }
//
//            System.out.println("Producto modificado correctamente.");
//        } else {
//            System.out.println("Producto no encontrado en la Base de Datos.");
//        }
//    }