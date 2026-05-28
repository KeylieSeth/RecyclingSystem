package infrastructure;
import java.io.*;
import java.util.List;
import domain.Product;
import domain.Material;

public class FileHandler {

    public void save(List<Product> products,
                     List<Material> materials,
                     String fileName)
            throws IOException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(products);
            out.writeObject(materials);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> loadProducts(String fileName)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            return (List<Product>) in.readObject();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Material> loadMaterials(String fileName)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            in.readObject();

            return (List<Material>) in.readObject();
        }
    }
    public void saveReport(String report, String fileName)
            throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        }    
    }
}