    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.util.List;
    public class GUI {
        private final WestminsterShoppingManager shoppingManager;

        private static final String WINDOW_TITLE = "Westminster Shopping Centre";

        // Sample data and column names for JTable

        private static final String[] COLUMN_NAMES = {"Product ID", "Name","Category", "Price(£)","info"};

        JFrame f = new JFrame(WINDOW_TITLE);
        final JPanel mainPanel = new JPanel();
        final JPanel headerPanel = new JPanel(new FlowLayout());
        final JPanel tablePanel = new JPanel();

        JComboBox<String> cb;
        JTable table;
        DefaultTableModel tableModel;

        public GUI(WestminsterShoppingManager shoppingManager) {
            this.shoppingManager = shoppingManager;
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            // Create JComboBox and add it to the headerPanel
            JLabel label1 = new JLabel("Select product category: ");
            String[] choices = {"All", "Electronics", "Clothing"};
            cb = new JComboBox<>(choices);

            headerPanel.add(label1);
            headerPanel.add(cb);

            // Create JTable
            tableModel = new DefaultTableModel(convertListToArray(), COLUMN_NAMES);
            table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Enable sorting for the table
            table.setAutoCreateRowSorter(true);

            // Set up JTable properties
            table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setFillsViewportHeight(true);

            // Add the JTable to the tablePanel
            tablePanel.add(scrollPane);

            // Add sub-panels to the main panel
            mainPanel.add(headerPanel);
            mainPanel.add(tablePanel);

            // Add main panel to the frame
            f.add(mainPanel);

            // Set frame properties
            f.setSize(1000, 600);
            f.setLocation(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }

        private Object[][] convertListToArray() {
            List<Product> productList = shoppingManager.getListOfProducts();
            Object[][] array = new Object[productList.size()][WestminsterShoppingManager.COLUMN_NAMES.length];

            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                array[i] = new Object[]{
                        product.getProductID(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getType(),
                        product.getPrice()
                };
            }
            return array;
        }
        public void updateTable() {
            SwingUtilities.invokeLater(() -> {
                Object[][] data = convertListToArray();
                tableModel.setDataVector(data, COLUMN_NAMES);
                tableModel.fireTableDataChanged();
            });
        }


        public void setShoppingManager(WestminsterShoppingManager shoppingManager) {
        }
    }
