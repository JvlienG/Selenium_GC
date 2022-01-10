package fr.zenity.pageObjects;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

public class ExcelData extends Page{

    private static final String fileName = "/Users/julien/Documents/ZENITY_/GC_SeleniumX_1/src/main/resources/Donnes.xlsx";
    final File file = new File(fileName);


    private String adresseMail;
    private String password;

    private String pseudo;
    private double civilite;
    private String nom;
    private String prenom;
    private String tel;
    private String dateOfBirth;
    private String adresse;
    private String zipCode;
    private String city;

    private String research;


    public void loadData(String sheetName) throws IOException {
        final Workbook workbook = WorkbookFactory.create(file);
        final Sheet currentSheet = workbook.getSheet(sheetName);

        if(sheetName.equals("Create")) {
            adresseMail = currentSheet.getRow(1).getCell(1).getStringCellValue();
            password = currentSheet.getRow(2).getCell(1).getStringCellValue();
            pseudo = currentSheet.getRow(3).getCell(1).getStringCellValue();
            civilite = currentSheet.getRow(4).getCell(1).getNumericCellValue();
            nom = currentSheet.getRow(5).getCell(1).getStringCellValue();
            prenom = currentSheet.getRow(6).getCell(1).getStringCellValue();
            tel = currentSheet.getRow(7).getCell(1).getStringCellValue();
            dateOfBirth = currentSheet.getRow(8).getCell(1).getStringCellValue();
            adresse = currentSheet.getRow(9).getCell(1).getStringCellValue();
            zipCode = currentSheet.getRow(10).getCell(1).getStringCellValue();
            city = currentSheet.getRow(11).getCell(1).getStringCellValue();
        }

        else if(sheetName.equals("Connexion")){
            this.adresseMail = currentSheet.getRow(1).getCell(1).getStringCellValue();
            this.password = currentSheet.getRow(2).getCell(1).getStringCellValue();
        }

        else if(sheetName.equals("Search")){
            this.research = currentSheet.getRow(1).getCell(0).getStringCellValue();
        }

        else if(sheetName.equals("Update")){
            this.tel = currentSheet.getRow(1).getCell(1).getStringCellValue();
            this.adresse = currentSheet.getRow(2).getCell(1).getStringCellValue();
            this.city = currentSheet.getRow(3).getCell(1).getStringCellValue();
            this.zipCode = currentSheet.getRow(4).getCell(1).getStringCellValue();
        }

        else{
            System.out.println("Aucun classeur correspondant");
        }


    }

    /* GETTER CREATION DE COMPTE / CONNEXION */

        public String getAdresseMail(){
            return this.adresseMail;
        }

        public String getPassword(){
            return this.password;
        }

        public String getPseudo(){
            return this.pseudo;
        }

        public double getCivilite(){
            return this.civilite;
        }

        public String getNom(){
            return this.nom;
        }

        public String getPrenom(){
            return this.prenom;
        }

        public String getTel(){
            return this.tel;
        }

        public String getDateOfBirth(){
            return this.dateOfBirth;
        }

        public String getAdresse(){
            return this.adresse;
        }

        public String getZipCode(){
            return this.zipCode;
        }

        public String getCity(){
            return this.city;
        }

    /* GETTER ARTICLE / PANIER */

        public String getResearch(){
            return this.research;
        }

}
