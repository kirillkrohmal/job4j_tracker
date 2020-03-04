package ru.job4j.parsersql;


import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserSQL {
    private static final Logger log = Logger.getLogger(ParserSQL.class);

    public static void main(String[] args) throws Throwable {
        List<Vacancy> vacancyList = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job")
                .get();

        Elements listNews = doc.select("a[href]");


        for (Element element : listNews) {
            String name = element.text();
            String text = String.valueOf(element.text("msgBody"));
            String link = element.attr("href");

            vacancyList.add(new Vacancy(name, text, link));
        }

        vacancyList.forEach(System.out::println);

    }
}


