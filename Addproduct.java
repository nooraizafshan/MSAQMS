
package msaqms;
import java.nio.file.Paths;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class Addproduct extends javax.swing.JFrame {
DefaultTableModel tableModel = new DefaultTableModel();
    private String imagepath; // Add this field to store the image path

    private Product product;
    private Product.Mobile mobile;
    String path;
           
    public Addproduct() 
    {
         mobiletable = new JTable();

        mobiletable.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int selectedRow = mobiletable.getSelectedRow();
        if (selectedRow != -1) {
         //   populateFieldsFromTable(selectedRow);
        }
    }
});
        initComponents();
                this.product = new Product();  // Initialize the product object

          displayMobileDetailsInTable();
    
    }

 private static void validateInputs(String id, String model, String name, String brand, double price, int stock) {
        // You can add more validation rules as needed
        if (id.isEmpty() || model.isEmpty() || name.isEmpty() || brand.isEmpty() || price <= 0 || stock <= 0) {
          throw new IllegalArgumentException("Please provide valid values for all fields.");
        }}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        stock1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Ram = new javax.swing.JComboBox<>();
        Rom = new javax.swing.JComboBox<>();
        CamerinMp = new javax.swing.JComboBox<>();
        addbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        brand1 = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        name1 = new javax.swing.JTextField();
        Browsesaveimgbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        Model = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        delidfield = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mobiletable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        viewbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Mobileshop");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 5, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 153, 153));
        jButton6.setText("close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1350, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Enter mobile name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Id");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 30, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Brand");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("RAM in Gb");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Storage in Gb");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 100, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Price");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Stock");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 20));

        stock1.setForeground(new java.awt.Color(153, 153, 153));
        stock1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        stock1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel2.add(stock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Camera in MP");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, 20));

        Ram.setForeground(new java.awt.Color(153, 153, 153));
        Ram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2GB", "4GB", "8GB", "16GB" }));
        Ram.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel2.add(Ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 110, -1));

        Rom.setForeground(new java.awt.Color(153, 153, 153));
        Rom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4GB", "8GB", "12GB", "16GB", "20GB", "24GB", "28GB", "32GB", "38GB", "56GB", "64GB", "120GB", "164GB", "240GB", "256G", " " }));
        Rom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel2.add(Rom, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, -1));

        CamerinMp.setForeground(new java.awt.Color(153, 153, 153));
        CamerinMp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        CamerinMp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jPanel2.add(CamerinMp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 110, -1));

        addbtn.setBackground(new java.awt.Color(255, 51, 0));
        addbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addbtn.setForeground(new java.awt.Color(153, 153, 153));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel2.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 210, 40));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 51, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, 140, 30));

        updatebtn.setBackground(new java.awt.Color(255, 153, 0));
        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(153, 153, 153));
        updatebtn.setText("Update ");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 210, 40));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("Upload Picture");
        jPanel6.add(jLabel12);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 220, 40));

        Price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 140, 20));

        brand1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(brand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, 20));

        id1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 100, 20));

        name1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 100, 20));

        Browsesaveimgbtn.setBackground(new java.awt.Color(255, 51, 0));
        Browsesaveimgbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Browsesaveimgbtn.setForeground(new java.awt.Color(153, 153, 153));
        Browsesaveimgbtn.setText("Browse");
        Browsesaveimgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowsesaveimgbtnActionPerformed(evt);
            }
        });
        jPanel2.add(Browsesaveimgbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 90, 30));

        delbtn.setBackground(new java.awt.Color(255, 153, 0));
        delbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delbtn.setForeground(new java.awt.Color(153, 153, 153));
        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        jPanel2.add(delbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 200, 40));

        Model.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(Model, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 140, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Model");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 50, -1));

        image.setText("jLabel14");
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 160, 190));
        jPanel2.add(delidfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 750, 630));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.add(jPanel5);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Mobile_Stock");
        jPanel4.add(jLabel11);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 590, 40));

        mobiletable.setBackground(new java.awt.Color(204, 204, 204));
        mobiletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Brand", "Name", "model", "price", "stock", "ram", "rom ", "camerainMp"
            }
        ));
        mobiletable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mobiletableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mobiletableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(mobiletable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 590, 530));
        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 90, 50));

        viewbtn.setBackground(new java.awt.Color(255, 153, 0));
        viewbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewbtn.setForeground(new java.awt.Color(153, 153, 153));
        viewbtn.setText("View");
        viewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Admincat cat=new Admincat();
cat.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed
 
    



private void displayMobileDetailsInTable() {
    Object[][] data = getDataForTable();
    tableModel.setDataVector(data, new Object[]{"Id", "Brand", "Name", "Model", "Price", "Stock", "RAM", "ROM", "CameraInMP"});
    mobiletable.setModel(tableModel);
}
// Modify the getDataForTable method in your Addproduct class
public Object[][] getDataForTable() {
    try (BufferedReader reader = new BufferedReader(new FileReader("mobile_data.txt"))) {
        List<Object[]> dataList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] mobileData = line.split(", ");  // Adjust based on your data format

            dataList.add(mobileData);
        }

        return dataList.toArray(new Object[dataList.size()][]);
    } catch (IOException e) {
        Logger.getLogger(Addproduct.class.getName()).log(Level.SEVERE, null, e);
        return new Object[0][0];
    }
}

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
    Product product = new Product();
    try {
        String id = id1.getText();
        String brand = brand1.getText();
        String name = name1.getText();
        String model = Model.getText();
        double price = Double.parseDouble(Price.getText());
        int stock = Integer.parseInt(stock1.getSelectedItem().toString());
        String ram = Ram.getSelectedItem().toString();
        String rom = Rom.getSelectedItem().toString();
        String cameraInmp = CamerinMp.getSelectedItem().toString();
            validateInputs(id, model, name, brand, price, stock);
            product.addMobile(id, brand, name, model, price, stock, ram, rom, cameraInmp);
            product.sortMobileList();
            JOptionPane.showMessageDialog(null, "Mobile added successfully!");
//            // Uncomment the line below to display mobile details in the table after adding
            displayMobileDetailsInTable();
    }catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numeric values for price and stock.");
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
            }
    
    }//GEN-LAST:event_addbtnActionPerformed
//will solved in step 2
    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
    // Get the selected row index
    int selectedRow = mobiletable.getSelectedRow();

    // Check if any row is selected
    if (selectedRow >= 0) {
        // Get the ID from the selected row
        String idToDelete = mobiletable.getValueAt(selectedRow, 0).toString();

        // Call the deleteMobile method
       product.readMobileDataFromFile();
        product.deleteMobile(idToDelete);
JOptionPane.showMessageDialog(null, "deleted");
        // Display the updated data in the table
        displayMobileDetailsInTable();
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete.");
    }

    }//GEN-LAST:event_delbtnActionPerformed

//stores the image data into  file//
private void writeImagePathToFile(String imagePath) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("mobile_image_path.txt", true))) {
        // Append the image path to the file
        writer.println(imagePath);
        JOptionPane.showMessageDialog(null, "Image path written to file successfully!");
    } catch (IOException ex) {
        Logger.getLogger(Addproduct.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error writing image path to file.");
    }
}

    private static final String IMAGE_STORAGE_PATH = "mobile_image_path.txt";
//correct code
    private void BrowsesaveimgbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowsesaveimgbtnActionPerformed

    JFileChooser jf = new JFileChooser();
    int result = jf.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = jf.getSelectedFile();
        if (selectedFile != null) {
            // Use Path for better file path handling
            File imagePath = new File(IMAGE_STORAGE_PATH, selectedFile.getName());

           // Path imagePath = Paths.get(IMAGE_STORAGE_PATH, selectedFile.getName());

            try {
                // Check if the selected file is an image
                String fileType = Files.probeContentType(selectedFile.toPath());
                if (fileType != null && fileType.startsWith("image/")) {
                    BufferedImage bi = ImageIO.read(selectedFile);
                    Image img = bi.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon ii = new ImageIcon(img);

                    image.setIcon(ii);

                    // Write the image path to the text file
                    writeImagePathToFile(imagePath.toString());
//
                } else {
                    JOptionPane.showMessageDialog(null, "Selected file is not an image.");
                }
            } catch (IOException ex) {
                Logger.getLogger(Addproduct.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace(); // Print exception details for debugging
           }
        } else {
          System.out.println("No file selected.");
        }
    } else {
        // Handle the case when the file chooser dialog is canceled
        System.out.println("File selection canceled.");
    }

    }//GEN-LAST:event_BrowsesaveimgbtnActionPerformed

    private void viewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbtnActionPerformed
         displayMobileDetailsInTable();        
// TODO add your handling code here:
    }//GEN-LAST:event_viewbtnActionPerformed
    //correct code//
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
            // Get data from text fields
    String id = id1.getText();
    String brand = brand1.getText();
    String name = name1.getText();
    String model = Model.getText();
    double price = Double.parseDouble(Price.getText());
    int stock = Integer.parseInt(stock1.getSelectedItem().toString());
    String ram =(String) Ram.getSelectedItem();
     String rom =(String) Rom.getSelectedItem();
    String cameraInmp = (String) CamerinMp.getSelectedItem();


    try {
        // Call the updateMobile method
        product.updateMobile(id, brand, name, model, price, stock, ram, rom, cameraInmp);
        
        // Display updated data in the table
        displayMobileDetailsInTable();

        JOptionPane.showMessageDialog(null, "Mobile updated successfully!");
                 displayMobileDetailsInTable();        

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numeric values for price and stock.");
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void mobiletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobiletableMouseClicked

    }//GEN-LAST:event_mobiletableMouseClicked
 //correct code//
    private void mobiletableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobiletableMousePressed
    int row = mobiletable.rowAtPoint(evt.getPoint()); // Get the row index
    int column = mobiletable.columnAtPoint(evt.getPoint()); // Get the column index

    if (SwingUtilities.isRightMouseButton(evt)) { // Check if right mouse button is clicked
        // TODO: Add your code for right mouse button action
        if (row >= 0) {
            // Do something with the right-clicked row and column
            System.out.println("Right-clicked on Row: " + row + ", Column: " + column);
        }
    } else if (SwingUtilities.isLeftMouseButton(evt)) { // Check if left mouse button is clicked
        // TODO: Add your code for left mouse button action
        if (row >= 0) {
            // Populate the fields with data from the selected row
            id1.setText(mobiletable.getValueAt(row, 0).toString());
            brand1.setText(mobiletable.getValueAt(row, 1).toString());
            name1.setText(mobiletable.getValueAt(row, 2).toString());
            Model.setText(mobiletable.getValueAt(row, 3).toString());
             double price = Double.parseDouble(mobiletable.getValueAt(row, 4).toString());
        Price.setText(String.valueOf(price));
         ///   Price.setText(mobiletable.getValueAt(row, 4).toString());
            stock1.setSelectedItem(mobiletable.getValueAt(row, 5).toString());
            Ram.setSelectedItem(mobiletable.getValueAt(row, 6).toString());
            Rom.setSelectedItem(mobiletable.getValueAt(row, 7).toString());
            CamerinMp.setSelectedItem(mobiletable.getValueAt(row, 8).toString());

            // TODO: Display the image if needed
        }
    }
            // TODO add your handling code here:
    }//GEN-LAST:event_mobiletableMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 
        ///img willl not stored through add btn it will store through browse btn 
        
               //iif it's necessary then i wilolo use this code to save  btn instead of browse
    //    JFileChooser fileChooser = new JFileChooser();
     //   int result = fileChooser.showOpenDialog(null);
   // if (result == JFileChooser.APPROVE_OPTION) {
    //    File selectedFile = fileChooser.getSelectedFile();
        // Get the image path from the selected file
     //      InputStream imagePath = selectedFile.getAbsolutePath();
//          File file = new File("mobile_image_path.txt");
       //     InputStream is = new FileInputStream(new File(path));
   
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Browsesaveimgbtn;
    private javax.swing.JComboBox<String> CamerinMp;
    private javax.swing.JTextField Model;
    private javax.swing.JTextField Price;
    private javax.swing.JComboBox<String> Ram;
    private javax.swing.JComboBox<String> Rom;
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField brand1;
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField delidfield;
    private javax.swing.JTextField id1;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mobiletable;
    private javax.swing.JTextField name1;
    private javax.swing.JComboBox<String> stock1;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton viewbtn;
    // End of variables declaration//GEN-END:variables
}
