
import model.Product;

import Services.productService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        productService productServic = new productService();
        Scanner sc= new Scanner(System.in);
        // Cargar productos desde un archivo CSV
        System.out.println("Seleciona por favor que va realizar \n1.Ver Productos\n2.Añadir\n3.Consultar ");

            int seleccion = 0;
            while (seleccion!=3) {
                seleccion = sc.nextInt();
                switch (seleccion) {

                    case 1-> productServic.cargarProductosDesdeCSV("C:\\Users\\acer\\IdeaProjects\\CSV\\csv-product-exercise-java\\resources\\inventory.csv");
                    case 2-> productServic.add();
                    case 3-> productServic.remove();
                }

            }
        }

    }
