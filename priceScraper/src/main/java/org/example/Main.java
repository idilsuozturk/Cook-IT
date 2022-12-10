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

        

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument("https://getir.com/en/category/fruits-veg-tBYm30SlS9/");

        ArrayList<HtmlElement> list = new ArrayList<HtmlElement>();

        List<?> anchors = page.getByXPath("//article[@class='sc-82bcadf4-0 iCZWKw']");
        for (int i = 0; i < anchors.size(); i++) {
            list.add((HtmlElement) anchors.get(i));
            System.out.println();

        }


        for(HtmlElement element : list ){
            System.out.println(element.asNormalizedText());
        }













    }
}