
package msaqms;
import java.io.Serializable;

import javax.swing.table.TableModel;
import java.io.InputStream;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Product implements Serializable
{
   private  Mobile head;


   static class Mobile
  {
    private String id;
    private String brand;
    private String name;
    private String model; 
    private double price;
    private String ram;
    private String rom;
    private String cameraInmp;
    private String imagePath;
    private int stock;
    private Mobile next;

     public Mobile(String id, String brand, String name, String model, double price, int stock, String ram, String rom, String cameraInmp) 
    // Constructor code

        {
            this.id = id;
            this.brand = brand;
            this.name = name;
            this.model = model;
            this.price = price;
            this.ram = ram;
            this.rom = rom;
            this.cameraInmp = cameraInmp;
            //this.next = next;
            this.stock = stock;
        }
        
        
     
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setCameraInmp(String cameraInmp) {
        this.cameraInmp = cameraInmp;
    }

    public String getCameraInmp() {
        return cameraInmp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String Model) {
        this.model = Model;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }

    public String getRom() {
        return rom;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

   
    public void setPrice(double price) {
        this.price = price;
    }

    // Constructors, getters, setters

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

   

    public double getPrice() {
        return price;
    }
     @Override
public String toString() {
    return String.format("%s, %s, %s, %s, %.2f, %d, %s, %s, %s", id, brand, name, model, price, stock, ram, rom, cameraInmp);
}
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Mobile mobile = (Mobile) obj;
    return id.equals(mobile.id);
}

}
   static class Image 
   {
       
       
   }
   
   
   
                        /////////////////////////////////     //add method///////////////////////////////////////
     
     
    public int length=0;
    DefaultTableModel tableModel = new DefaultTableModel();
    
    
    
    public void addMobile(String id, String brand, String name, String model, double price, int stock, String ram, String rom, String cameraInmp) {
    // Create a new Mobile object with the provided data
    Mobile data = new Mobile(id, brand, name, model, price, stock, ram, rom, cameraInmp);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mobile_data.txt", true))) {
        // Format the data as a string and write it to the file
        String formattedData = String.format("%s, %s, %s, %s, %.2f, %d, %s, %s, %s",
                id, brand, name, model, price, stock, ram, rom, cameraInmp);
        writer.write(formattedData);
        writer.newLine();
    } catch (IOException e) {
        // Log any IOException that occurs
        Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
    }

    // Add the new Mobile object to the linked list
    if (head == null) {
        // If the list is empty, set the new Mobile object as the head
        head = data;
    } else {
        // If the list is not empty, find the last element and append the new Mobile object
        Mobile current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = data;
    }

    // Update the length and table display
    length++;
    //   bubbleSortById(head);
    updateTable();
}
    
    
    //in order to view data read  data  from file
    
      private Object[][] readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mobile_data.txt"))) {
            // Assuming each line in the file represents a mobile's details
            return reader.lines()
                    .map(line -> line.split(", "))  // Split by the delimiter, adjust based on your data format
                    .toArray(Object[][]::new);
        } catch (IOException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            return new Object[0][0];
        }
    }

    // Modify the updateTable method to use the data from the file
    private void updateTable() {
       Object[][] data = getDataForTable();
    tableModel.setDataVector(data, new Object[]{"Id", "Brand", "Name", "Model", "Price", "Stock", "RAM", "ROM", "CameraInMP"});

    }
    
    
    //get data for table  for update
    public Object[][] getDataForTable() {
    try (BufferedReader reader = new BufferedReader(new FileReader("mobile_data.txt"))) {
        List<Object[]> dataList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] mobileData = line.split(", ");  // Adjust based on your data format
            dataList.add(mobileData);
        }

        return dataList.toArray(new Object[0][0]);
    } catch (IOException e) {
        Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        return new Object[0][0];
    }
     }
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    
    
    
    
    
    
    ///////////////////Delete Mobile Details By Click on table row//////////////////////
    
    
    
    
    
    
    private String mobileToFileString(Mobile mobile) {
    // Replace this with the actual formatting logic based on your Mobile class
    return mobile.getId() + "," + mobile.getBrand() + "," + mobile.getModel() + "\n";
}
    
    private void updateFile(String id) {
    Object[][] mobiles = readDataFromFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mobile_data.txt"))) {
        for (Object[] mobile : mobiles) {
            String currentId = mobile[0].toString();

            // Skip the mobile with the specified ID, as it's being deleted
            if (!currentId.trim().equals(id.trim())) {
                String formattedData = String.format("%s, %s, %s, %s, %.2f, %d, %s, %s",
                        mobile[0], mobile[1], mobile[2], mobile[3], (double) mobile[4], (int) mobile[5],
                        mobile[6], mobile[7]);

                writer.write(formattedData);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception according to your needs
    }
}
    
    //Delete method//
          
    public void deleteMobile(String id)
    {
         Mobile current = head;
         Mobile previous = null;

    while (current != null) {
                if (current.getId().equals(id)) {

       // if (current.getId().trim().equals(id.trim())) {
            // Found the mobile to delete
            if (previous != null) {
                // If the mobile is not the head of the list
                previous.next = current.next;
            } else {
                // If the mobile is the head of the list
                head = current.next;
            }

            // Update the file after deleting from the linked list
            updateFile(id);  // Pass the id to updateFile

            System.out.println("Mobile with ID " + id + " deleted successfully.");
            return;
        }
        previous = current;
        current = current.next;
    }

    JOptionPane.showMessageDialog(null, "Mobile with ID " + id + " not found.");

}


/////////////////////////UpDate Mobile details////////////////////////


 
 
  public void updateMobile(String id, String brand, String name, String model, double price,int stock, String ram, String rom, String cameraInmp) {

      
      Object[][] dataList = readDataFromFile();

// Read existing data from the file
        Mobile updatedMobile = new Mobile(id, brand, name, model, price, stock, ram, rom, cameraInmp);
        
        // Find the index of the mobile to update in the linked list
        int index = -1;
                for (int i = 0; i < dataList.length; i++) {

                        if (dataList[i][0].toString().equals(id)) {

                index = i;
                break;
            }
        }

        if (index != -1) {
            // Update the mobile at the found index
                    dataList[index] = new Object[]{id, brand, name, model, price, stock, ram, rom, cameraInmp};

                   writeDataToFile(dataList);

        } else {
            // Handle case when mobile with given ID is not found
            System.out.println("Mobile with ID " + id + " not found.");
        }
    } 
  
  //write method to write data into file
  
  private static void writeDataToFile(Object[][] mobiles) 
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mobile_data.txt"))) {
        for (Object[] mobile : mobiles) {
            String formattedData = String.format("%s, %s, %s, %s, %.2f, %d, %s, %s",
                    mobile[0], mobile[1], mobile[2], mobile[3], (double) mobile[4], (int) mobile[5],
                    mobile[6], mobile[7]);

            writer.write(formattedData);
            writer.newLine();

            System.out.println("Mobile with ID " + mobile[0] + " written to file successfully.");
        }
    } catch (IOException e) {
        System.out.println("Error writing mobile data to file: " + e.getMessage());
        e.printStackTrace();
    }
}

  
  // ViewMobilesTocustomer()

 public void retrieveDataForGUI() {
        List<Mobile> mobiles = readMobileDataFromFile();
        List<String> imagePaths = readImagePathsFromFile();

        if (!mobiles.isEmpty() && mobiles.size() == imagePaths.size()) {
            for (int i = 0; i < mobiles.size(); i++) {
                Mobile mobile = mobiles.get(i);
                String imagePath = imagePaths.get(i);

                // You can now use 'mobile' and 'imagePath' to display the data in your GUI
                System.out.println("Mobile: " + mobile);
                System.out.println("Image Path: " + imagePath);
            }
        } else {
            System.out.println("Error: Mobile data and image paths don't match.");
        }
        
    }
 

    protected List<Mobile> readMobileDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mobile_data.txt"))) {
            List<Mobile> mobiles = new ArrayList<>();
            String line;
  
            while ((line = reader.readLine()) != null) {
                String[] mobileData = line.split(", ");
                   if (mobileData.length >= 9) {
                Mobile mobile = new Mobile(mobileData[0], mobileData[1], mobileData[2],
                        mobileData[3], Double.parseDouble(mobileData[4]), Integer.parseInt(mobileData[5]),
                        mobileData[6], mobileData[7],mobileData[8]);

                // Set the image path for each mobile
                String imagePath = readImagePathsFromFile().get(mobiles.size());
                mobile.setImagePath(imagePath);

                mobiles.add(mobile);
                 } else {
                // Log an error or handle the case where the data is not in the expected format
                System.err.println("Invalid data format: " + line);
                   }
            }

            return mobiles;
        } 
    catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e)
        {
    System.err.println("Error reading mobile data: " + e.getMessage());
    e.printStackTrace();
    return new ArrayList<>();
}
    }

 
    public List<String> readImagePathsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mobile_image_path.txt"))) {
            List<String> imagePaths = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                imagePaths.add(line);
            }

            return imagePaths;
        } catch (IOException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            return new ArrayList<>();
        }
    }
    
    
 private static Product.Mobile readMobileDataFromFile(String filePath) {
    Product.Mobile head = null;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] attributes = line.split(","); // Assuming CSV format
         
            Product.Mobile mobile = new Product.Mobile(
                attributes[0].trim(),
                attributes[1].trim(),
                attributes[2].trim(),
                attributes[3].trim(),
                Double.parseDouble(attributes[4].trim()),
                Integer.parseInt(attributes[9].trim()), // Assuming stock is at index 9
                attributes[5].trim(),
                attributes[6].trim(),
                attributes[7].trim()
            );

            // Insert the new mobile node at the beginning of the linked list
            mobile.next = head;
            head = mobile;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return head;
}

//Sort data method//
 
    public  void bubbleSortById(Mobile head) {
        int n = getCount(head);
        boolean swapped;
        Mobile temp;

        for (int i = 0; i < n - 1; i++) {
            Mobile current = head;
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (Integer.parseInt(current.id) > Integer.parseInt(current.next.id)) {
                    // Swap current and current.next
                    temp = current;
                    current = current.next;
                    temp.next = current.next;
                    current.next = temp;
                    swapped = true;
                }

                current = current.next;
            }

            if (!swapped) {
                break;
            }
        }
    }
    
    public void sortMobileList() {
        // Implement your sorting logic here
        // For example, call your existing sorting method on the linked list
        bubbleSortById(head);  // Modify this based on your sorting logic
    }

    private static int getCount(Mobile head) {
        int count = 0;
        Mobile current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
return count;
    }

    
    
 private Mobile findMobileById(String id) {
        Mobile current = head;

        while (current != null) {
            if (current.getId().equals(id)) {
                return current;
            }
            current = current.next;
        }

        return null; // Return null if the mobile with the given ID is not found
 }   }