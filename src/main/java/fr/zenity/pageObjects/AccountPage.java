package fr.zenity.pageObjects;

/*import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;*/

import fr.zenity.config.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.IOException;

public class AccountPage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment()+"/client/compte.html";

    private ExcelData excelData = new ExcelData();

    public void pause(int tmps){
        try{
            Thread.sleep(tmps);
        }catch(Exception e){}
    }

    /* ------------------- VARIABILISATION ------------------- */



    /* ------------------- BY ------------------- */

        By compte = By.id("client_email");
        By mdp = By.id("client_password");
        By chmdp = By.id("client_checkpassword");
        By pseudo = By.id("client_nickname");
        By civilite = By.id("client_civility");
        By nom = By.id("client_name");
        By prenom = By.id("client_firstname");
        By num = By.id("client_gsm");
        By date = By.id("client_birthdate");
        By adresse = By.id("client_address");
        By cp = By.id("client_zip");
        By city = By.id("client_city");

        /* #### CREATION DE COMPTE ### */

        By monCompte = By.xpath("//a[@href='/connexion.html']");
        By button = By.xpath("//button[contains(text(),'Je crée mon compte')]");
        By cgv = By.id("cgv");
        By createButton = By.xpath("//button[contains(text(),'Je crée mon compte')]");
        By created = By.xpath("//h2[contains(.,'Compte créé')]");

        /* ### MODIFICATION DE COMPTE ### */

        By uCompte = By.xpath("//span[contains(.,'Mon compte')]");
        By uCompteModif = By.xpath("//a[@href='/client/compte-editer.html']");
        By Udpatebutton = By.xpath("//button[contains(text(),'Modifier')]");


        public void navigateTo(){
            /*if(this.driver.getCurrentUrl().equals(URL)){
                return;
            }
            driver.get(URL);*/
            this.pause(5000);
            WebElement wCompte = this.driver.findElement(uCompte);
            wCompte.click();

        }

        public boolean isLogOut(){
            WebElement wCompte = this.driver.findElement(uCompte);
            wCompte.click();

            if(this.driver.getCurrentUrl().equals("https://www.gamecash.fr/connexion.html")){
                return true;
            }
            return false;
        }

/* ##### CREATION DE COMPTE ##### */

    public void createCompteValid() throws IOException {

        excelData.loadData("Create");

        String adresseMail = excelData.getAdresseMail();
        String mdp = excelData.getPassword();
        String pseudo = excelData.getPseudo();
        double civilite = excelData.getCivilite();
        String nom = excelData.getNom();
        String prenom = excelData.getPrenom();
        String tel = excelData.getTel();
        String date = excelData.getDateOfBirth();
        String adresse = excelData.getAdresse();
        String cp = excelData.getZipCode();
        String ville = excelData.getCity();

        /*WebElement wMonCompte = this.driver.findElement(monCompte);
        wMonCompte.click();*/

        adresseMail(adresseMail);

        WebElement wButt = this.driver.findElement(button);
        wButt.click();

        password(mdp);
        pseudo(pseudo);
        choixCivil(civilite);
        nom(nom);
        prenom(prenom);
        telephone(tel);
        anniv(date);
        adresse(adresse);
        codePostal(cp);
        ville(ville);

        WebElement wCGV = this.driver.findElement(cgv);
        wCGV.click();

        WebElement wCreateButton = this.driver.findElement(createButton);
        wCreateButton.click();
    }

    public boolean createdAccount(){
        if(this.driver.findElement(created).isDisplayed()){
            System.out.println("Compte créé");
            return true;
        }
        System.out.println("Erreur de création");
        return false;
    }

/* ##### MODIFICATION DE COMPTE ##### */

    public void updateAccount() throws IOException {

        excelData.loadData("Update");

        String tel;
        String adresse;
        String ville;
        String cp;

        this.pause(5000);

        WebElement wUCompte = this.driver.findElement(uCompte);
        wUCompte.click();

        WebElement wUCompteModif = this.driver.findElement(uCompteModif);
        wUCompteModif.click();

        try{
            this.driver.wait(4000);
        }catch (Exception e){}

        try {
            tel = excelData.getTel();
        }catch (Exception e)
        {
            tel = "";
        }

        try {
            adresse = excelData.getAdresse();
        } catch (Exception e)
        {
            adresse = "";
        }

        try {
            ville = excelData.getCity();
        } catch (Exception e)
        {
            ville = "";
        }

        try {
            cp = excelData.getZipCode();
        } catch (Exception e) {
            cp = "";
        }


        if (tel.trim().length() != 0 ) {
            telephone(tel);
        }
        if (adresse.trim().length() != 0 ){
            adresse(adresse);
        }
        if (cp.trim().length() != 0 ){
            codePostal(cp);
        }
        if (ville.trim().length() != 0 ) {
            ville(ville);
        }

        WebElement wUpdateButton = this.driver.findElement(Udpatebutton);
        wUpdateButton.click();
    }

/* ##### RENSEIGNEMENT INFORMATIONS #### */

    public void adresseMail(String mail){
        WebElement wCompte = this.driver.findElement(compte);
        wCompte.sendKeys(mail);
    }

    public void password(String myPassword){
        WebElement wMDP = this.driver.findElement(mdp);
        wMDP.sendKeys(myPassword);

        WebElement wChMDP = this.driver.findElement(chmdp);
        wChMDP.sendKeys(myPassword);
    }

    public void pseudo(String vPseudo){
        WebElement wPseudo = this.driver.findElement(pseudo);
        wPseudo.clear();
        wPseudo.sendKeys(vPseudo);
    }

    public void choixCivil(double i ){
        WebElement wCivilite = this.driver.findElement(civilite);
        Select select = new Select(wCivilite);

        if (i == 1)
        {
            select.selectByVisibleText("Monsieur");
        }
        else if (i == 2)
        {
            select.selectByVisibleText("Madame");
        }
    }

    public void nom (String vNom){
        WebElement wNom = this.driver.findElement(nom);
        wNom.clear();
        wNom.sendKeys(vNom);
    }

    public void prenom (String vPrenom){
        WebElement wPrenom = this.driver.findElement(prenom);
        wPrenom.clear();
        wPrenom.sendKeys(vPrenom);
    }

    public void telephone(String vTel){
        WebElement wNum = this.driver.findElement(num);
        wNum.clear();
        wNum.sendKeys(vTel);
    }

    public void anniv (String dateAnniv){
        WebElement wDate = this.driver.findElement(date);
        wDate.clear();
        wDate.sendKeys(dateAnniv);
    }

    public void adresse (String vAdresse){
        WebElement wAdresse = this.driver.findElement(adresse);
        wAdresse.clear();
        wAdresse.sendKeys(vAdresse);
    }

    public void codePostal (String codeP){
        WebElement wCp = this.driver.findElement(cp);
        wCp.clear();
        wCp.sendKeys(codeP);
    }

    public void ville (String ville){
        WebElement wCity = this.driver.findElement(city);
        wCity.clear();
        wCity.sendKeys(ville);
    }
}
