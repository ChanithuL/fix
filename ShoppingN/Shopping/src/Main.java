import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        GUI gui = new GUI(shoppingManager);

        shoppingManager.setGUI(gui);
        shoppingManager.Menu();
        //GUI gui = new GUI(shoppingManager);
        //shoppingManager.Add();
    }

}