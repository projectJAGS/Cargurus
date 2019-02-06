/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author gapa0
 */
public class CarGurusTest {

    private WebDriver driver;
    private String baseUrl;
    
    public CarGurusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    System.setProperty("webdriver.chrome.driver", "c:\\qa\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.cargurus.com/";
    }
    
    @After
    public void tearDown() {
    }


    
    //FIND USED CARS BY MAKE AND MODEL IN THE SPECIFIC AREA CODE
    
    @Test
    public void usedVWJetta60004_Positive() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_makerSelect"))).selectByVisibleText("Volkswagen");
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("carPickerUsed_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_modelSelect"))).selectByVisibleText("Jetta");
    driver.findElement(By.id("carPickerUsed_modelSelect")).click();
    driver.findElement(By.id("dealFinderZipUsedId")).sendKeys("60004");
    driver.findElement(By.id("dealFinderForm_0")).click();
    assertEquals("Used Volkswagen Jetta for Sale in Arlington Heights, IL", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }

    @Test
    public void usedVW60004_Positive() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_makerSelect"))).selectByVisibleText("Volkswagen");
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("dealFinderZipUsedId")).sendKeys("60004");
    driver.findElement(By.id("dealFinderForm_0")).click();
    assertEquals("Used Volkswagen for Sale in Arlington Heights, IL", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }

    @Test
    public void usedVWJetta600_Negative() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_makerSelect"))).selectByVisibleText("Volkswagen");
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("carPickerUsed_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_modelSelect"))).selectByVisibleText("Jetta");
    driver.findElement(By.id("dealFinderForm_0")).click();
    
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }    
    
    
    @Test
    public void usedVWJetta_Negative() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_makerSelect"))).selectByVisibleText("Volkswagen");
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("carPickerUsed_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerUsed_modelSelect"))).selectByVisibleText("Jetta");
    driver.findElement(By.id("dealFinderForm_0")).click();
    
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
       
    
    @Test
    public void usedCarNoInfo_Negative() {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("dealFinderForm_0")).click();
    
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
       
    
    @Test
    public void usedAll60004_Positive() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("dealFinderZipUsedId")).sendKeys("60004");
    driver.findElement(By.id("dealFinderForm_0")).click();
    assertEquals("Used Cars for Sale in Arlington Heights, IL", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();   
    }    
    
    @Test
    public void usedAll7Zip_Negative() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::img[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find great deals from top-rated dealers'])[1]/following::label[1]")).click();
    driver.findElement(By.id("carPickerUsed_makerSelect")).click();
    driver.findElement(By.id("dealFinderZipUsedId")).sendKeys("1234567");
    driver.findElement(By.id("dealFinderForm_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    
    //FIND USED CARS BY BODY STYLE IN THE SPECIFIC AREA CODE
    
    
    @Test
    public void usedSUV33119_Positive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sedan'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).sendKeys("33119");
    driver.findElement(By.id("dealFinderFormBody_0")).click();
    assertEquals("Used SUVs / Crossovers for Sale in Miami Beach, FL", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();  
    }
    
    @Test
    public void usedSUV331_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sedan'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).sendKeys("331");
    driver.findElement(By.id("dealFinderFormBody_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    @Test
    public void usedSUV7Zip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sedan'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).sendKeys("6666666");
    driver.findElement(By.id("dealFinderFormBody_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    
    @Test
    public void usedSUVNoZip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sedan'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::input[1]")).clear();
    driver.findElement(By.id("dealFinderFormBody_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
 
    
    //FIND USED CARS BY PRICES IN THE SPECIFIC AREA CODE
    
    
    @Test
    public void allPrices90046_Positive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("90046");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    assertEquals("Used Cars for Sale in Los Angeles, CA", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();  
    }
    
    @Test
    public void allFrom24K90046_Positive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")).click();
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]"))).selectByVisibleText("$24,000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("90046");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    Select priceFrom = new Select(driver.findElement(By.xpath("//*[@id=\"newPriceSearchHeaderForm\"]/div[3]/select[1]")));
    String priceF = priceFrom.getFirstSelectedOption().getText();
    assertEquals("$24,000", priceF);
    }

    @Test
    public void allFrom24KTo120K90046_Positive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")).click();
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]"))).selectByVisibleText("$24,000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]"))).selectByVisibleText("$120,000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("90046");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    Select priceFrom = new Select(driver.findElement(By.xpath("//*[@id=\"newPriceSearchHeaderForm\"]/div[3]/select[1]")));
    String priceF = priceFrom.getFirstSelectedOption().getText();
    assertEquals("$24,000", priceF);
    Select priceTo = new Select(driver.findElement(By.xpath("//*[@id=\"newPriceSearchHeaderForm\"]/div[3]/select[2]")));
    String priceT = priceTo.getFirstSelectedOption().getText();
    assertEquals("$120,000", priceT);
   
    }
    
    
    @Test
    public void allTo120K90046_Positive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]"))).selectByVisibleText("$120,000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("90046");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    Select priceTo = new Select(driver.findElement(By.xpath("//*[@id=\"newPriceSearchHeaderForm\"]/div[3]/select[2]")));
    String priceT = priceTo.getFirstSelectedOption().getText();
    assertEquals("$120,000", priceT);
    }
    
    @Test
    public void pricesNoInfo_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    @Test
    public void prices7Zip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("9999999");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    @Test
    public void prices3Zip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[2]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::input[1]")).sendKeys("123");
    driver.findElement(By.id("dealFinderFormPrice_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }

    // FIND A NEW CAR TO BUY IN THE SPECIFIC AREA 
    @Test
    public void newLexuNX10012_Positive(){    
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_makerSelect"))).selectByVisibleText("Lexus");
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_modelSelect"))).selectByVisibleText("NX 300");
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    driver.findElement(By.id("dealFinderZipNewId")).click();
    driver.findElement(By.id("dealFinderZipNewId")).clear();
    driver.findElement(By.id("dealFinderZipNewId")).sendKeys("10012");
    driver.findElement(By.id("newCarSearchForm_0")).click();
    assertEquals("New Lexus NX 300 for Sale in New York, NY", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }
    
    @Test
    public void newLexuNX6Zip_Negative(){    
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_makerSelect"))).selectByVisibleText("Lexus");
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_modelSelect"))).selectByVisibleText("NX 300");
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    driver.findElement(By.id("dealFinderZipNewId")).clear();
    driver.findElement(By.id("dealFinderZipNewId")).sendKeys("101010");
    driver.findElement(By.id("newCarSearchForm_0")).click(); 
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    @Test
    public void newLexuNX3Zip_Negative(){    
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_makerSelect"))).selectByVisibleText("Lexus");
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_modelSelect"))).selectByVisibleText("NX 300");
    driver.findElement(By.id("carPickerNew_modelSelect")).click();
    driver.findElement(By.id("dealFinderZipNewId")).clear();
    driver.findElement(By.id("dealFinderZipNewId")).sendKeys("101");
    driver.findElement(By.id("newCarSearchForm_0")).click(); 
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    
    @Test
    public void newNoInfo_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("newCarSearchForm_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
    
    @Test
    public void newNoMakeNoModel10012_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("dealFinderZipNewId")).clear();
    driver.findElement(By.id("dealFinderZipNewId")).sendKeys("10012");    
    driver.findElement(By.id("newCarSearchForm_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please select a make and model.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
     
    @Test
    public void newNoModel10012_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[3]/following::span[1]")).click();
    driver.findElement(By.id("carPickerNew_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerNew_makerSelect"))).selectByVisibleText("Lexus");
    driver.findElement(By.id("carPickerNew_makerSelect")).click();    
    driver.findElement(By.id("dealFinderZipNewId")).clear();
    driver.findElement(By.id("dealFinderZipNewId")).sendKeys("10012");    
    driver.findElement(By.id("newCarSearchForm_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please select a make and model.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }
       
   
    
    // FIND A CERTIDIED CAR IN SPECIFIC AREA
    
    @Test
    public void certMercC98101_Postive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("carPickerCpo_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerCpo_makerSelect"))).selectByVisibleText("Mercedes-Benz");
    driver.findElement(By.id("carPickerCpo_makerSelect")).click();
    driver.findElement(By.id("carPickerCpo_modelSelect")).click();
    new Select(driver.findElement(By.id("carPickerCpo_modelSelect"))).selectByVisibleText("C-Class");
    driver.findElement(By.id("carPickerCpo_modelSelect")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("98101");
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    assertEquals("Certified Mercedes-Benz C-Class for Sale in Seattle, WA", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }
    
    @Test
    public void certMercNoModel98101_Postive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("carPickerCpo_makerSelect")).click();
    new Select(driver.findElement(By.id("carPickerCpo_makerSelect"))).selectByVisibleText("Mercedes-Benz");
    driver.findElement(By.id("carPickerCpo_makerSelect")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).clear();    driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("98101");
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    assertEquals("Certified Mercedes-Benz for Sale in Seattle, WA", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }
       
    @Test
    public void certNoMakeNoModell98101_Postive(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("98101");
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    assertEquals("Used Cars for Sale in Seattle, WA", driver.findElement(By.xpath("//*[@id=\"listingResultsContentBody\"]/div[1]/h1")).getText());
    driver.quit();
    }
       
    @Test
    public void certNoInfo_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }        
    
    @Test
    public void cert7Zip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("1010101");
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }        
        
    @Test
    public void cert2Zip_Negative(){
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='near'])[4]/following::span[1]")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).click();
    driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("10");
    driver.findElement(By.id("dealFinderFormCPO_0")).click();
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      assertEquals("Please specify a valid ZIP code.", alertText);
    } catch (NoAlertPresentException e) {
    }
    driver.quit();    
    }        
           
    
    
    
    
    
    
    
    
}
    
 
    
    
    
  
