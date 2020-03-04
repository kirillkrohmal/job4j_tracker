package ru.job4j.parsersql;

public class Vacancy {

    private String name;
    private String text;
    private String link;

    public Vacancy(String name, String text, String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
