package presentation;

import java.util.Scanner;
import application.MaterialService;

public class MaterialMenu {
    private MaterialService materialService;
    private Scanner scanner;
    
    public MaterialMenu(MaterialService ms, Scanner scanner){
        this.materialService = ms;
        this.scanner = scanner;
    }
}