package org.example;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    /**
     * @param url the url of the website we are scrpaing
     * @return the HtmlPage object of the url
     */
    public static HtmlPage getDocument(String url) {
        HtmlPage page = null;
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the price of the product in the URL
     */
    public static String getPriceFromURL(String URL){
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement priceHtml = page.getFirstByXPath("//div[@class='sc-dd9e2587-7 bwPUUQ']/span[last()]");
        String name = priceHtml.asNormalizedText();
        return name;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the amount of the product in the URL
     */

    public static String getAmountFromURL(String URL){

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement amountHtml = page.getFirstByXPath("//div[@class='sc-dd9e2587-2 fmWgoH']/span");
        String name = amountHtml.asNormalizedText();
        return name;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the price of the product in the URL
     */
    public static String getNameFromURL(String URL){
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement nameHtml = page.getFirstByXPath("//h2[@class ='style__Title2-sc-__sc-1nwjacj-3 iPNYeh sc-dd9e2587-4 fcZXLp']");
        String price = nameHtml.asNormalizedText();
        return price;
    }



    public static void main(String[] args) throws IOException {

       

    
        System.out.println(getAmountFromURL("https://getir.com/en/product/nuh-un-ankara-farfalle-pasta-zhjulxK8aH/"));
        System.out.println(getNameFromURL("https://getir.com/en/product/nuh-un-ankara-farfalle-pasta-zhjulxK8aH/"));
        System.out.println(getPriceFromURL("https://getir.com/en/product/nuh-un-ankara-farfalle-pasta-zhjulxK8aH/"));





    }
}