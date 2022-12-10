package org.example;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

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



    public static void main(String[] args) throws IOException {

        /*

        // Define the search term
        String searchQuery = "iphone 13";

        // Instantiate the client
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        // Set up the URL with the search term and send the request
        String searchUrl = "https://www.migros.com.tr/patlican-kemer-kg-p-1afde98" + URLEncoder.encode(searchQuery, "UTF-8");
        HtmlPage page = client.getPage(searchUrl);

        // Retrieve all <li> elements
        HtmlElement itemPriceHtml =  page.getFirstByXPath("//span[@class='amount']/text()");
        String itemPrice = itemPriceHtml.asNormalizedText();

        System.out.println(itemPrice);

        */


        /*
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("https://www.migros.com.tr/patlican-kemer-kg-p-1afde98");


        HtmlElement itemPriceHtml =  page.getFirstByXPath("/html/body/sm-root/div/main/sm-product/article/sm-product-detail-page/div[2]/fe-product-price/div/div/span/text()");


        System.out.println(itemPriceHtml.asNormalizedText());

        */

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument("https://getir.com/kategori/meyve-sebze-VN2A9ap5Fm/");

        ArrayList<HtmlElement> list = new ArrayList<HtmlElement>();

        List<?> anchors = page.getByXPath("//article[@class='sc-82bcadf4-0 iCZWKw']");
        for (int i = 0; i < anchors.size(); i++) {
            list.add((HtmlElement) anchors.get(i));

        }


        for(HtmlElement element : list ){
            System.out.println(element.asNormalizedText());
        }













    }
}