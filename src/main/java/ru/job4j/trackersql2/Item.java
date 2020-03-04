package ru.job4j.trackersql2;


import java.util.Objects;

/**
 * Created by Comp on 12.06.2017.
 */
public class Item {
    private String id;
    private String key;
    private String name;
    private long creat;
    private String description;

    public Item(String id, String key, String name, long created, String description) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.creat = created;
        this.description = description;
    }

    public Item() {

    }

    public Item(String key, String name, long created, String description) {
        this.key = key;
        this.name = name;
        this.creat = created;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return creat;
    }

    public void setCreated(long created) {
        this.creat = created;
    }

    public long getCreat() {
        return creat;
    }

    public void setCreat(long creat) {
        this.creat = creat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return creat == item.creat && Objects.equals(id, item.id) && Objects.equals(key, item.key) && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, name, creat, description);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", creat=" + creat +
                ", description='" + description + '\'' +
                '}';
    }
}
