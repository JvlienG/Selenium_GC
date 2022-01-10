package fr.zenity.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class ArticlePage extends Page{


    private ExcelData excelData = new ExcelData();

    public void pause(int time){
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }


    /* ------------------- BY ------------------- */
        By search = By.id("search");
        By produit = By.cssSelector(".product-item:nth-child(1) .title");

        By panier = By.xpath("//a[@href='/panier.html']");
        By valider = By.xpath("//a[contains(.,'Valider mon panier')]");

    private String productTitle;



/* ######### RECHERCHE D'ARTICLE ######### */

    public void searchArticle() throws IOException {
        excelData.loadData("Search");

        WebElement wSearch = this.driver.findElement(search);
        wSearch.sendKeys(excelData.getResearch() + '\n');
    }

    public void isSearchPage(){
        String Search = excelData.getResearch();
        System.out.println(Search.replace(" ", "+"));
        this.pause(4000);
        assertTrue(this.driver.getCurrentUrl().contains(Search.replace(" ", "+")));
    }

/* ######### SELECTION D'ARTICLE ######### */

    public void selectFirst(){
        WebElement wProduit = this.driver.findElement(produit);
        this.productTitle = wProduit.getText();
        wProduit.click();
    }

    public void isSelected(){
        String product = this.productTitle.toLowerCase(Locale.ROOT);
        product = product.replace(" ", "-");
        product = product.replace(":", "");
        System.out.println(product.replaceAll("-{2,}", "-"));
        product = product.replaceAll("-{2,}", "-");
        assertTrue(this.driver.getCurrentUrl().contains(product));
    }

/* ######### PANIER ######### */

    public void seeCart() {
        WebElement wPanier = this.driver.findElement(panier);
        wPanier.click();
    }

    public void confirmCart() {
        WebElement wValider = this.driver.findElement(valider);
        wValider.click();
    }

    public void addArticle() {
        By produit = By.xpath("//a[contains(.,'Ajouter au panier')]");
        WebElement wProduit = this.driver.findElement(produit);
        wProduit.click();

        this.pause(2000);

        By addproduit = By.xpath("//a[contains(.,'Voir mon panier')]");
        WebElement wAddProduit = this.driver.findElement(addproduit);
        wAddProduit.click();
    }


}
