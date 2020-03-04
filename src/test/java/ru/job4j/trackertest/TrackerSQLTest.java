package ru.job4j.trackertest;


import org.junit.Test;
import ru.job4j.trackersql.Item;
import ru.job4j.trackersql.TrackerSQL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Comp on 09.11.2017.
 */
public class TrackerSQLTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        Item add = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "test1", 1, "test1");
            add = tracker.add(item);
            assertThat(tracker.findAll(), is(item));
        }
        assertNotNull(add);
    }

    @Test
    public void whenFindByIdNewItemThenTrackerHasSameItem() throws Exception {
        Item add = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "1", "test1", 1, "test1");
            add = tracker.add(item);
            assertThat(tracker.findById(item.getId()), is(item));
        }
        assertNotNull(add);
    }

    @Test
    public void whenFindByNameNewItemThenTrackerHasSameItem() throws Exception {
        Item add = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "1", "test1", 1, "test1");
            add = tracker.add(item);
            assertThat(tracker.findByName(item.getId()), is(item));
            String name = "test1";
            Item[] item2 = {item};
            item2 = tracker.findByName(name);
            assertThat(item2, is(item));
        }
        assertNotNull(add);

    }

    @Test
    public void whenUpdateNewItemThenTrackerHasOtherItem() throws Exception {
        Item add = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "1", "test1", 1, "test1");
            add = tracker.add(item);
            Item item1 = new Item("2", "2", "test2", 2, "test2");
            item1.setId(item.getId());

            tracker.update(item1);
            assertThat(tracker.findAll(), is(item1));
        }
        assertNotNull(add);
    }

    @Test
    public void whenReplaceNewItemThenTrackerHasOtherItem() throws Exception {
        Item add = null;
        Item add1 = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "1", "test1", 1, "test1");
            Item item1 = new Item("2", "2", "test2", 2, "test2");
            add1 = tracker.add(item);
            add = tracker.add(item1);

            tracker.replace("2", item1);
            assertThat(tracker.findAll(), is(item1));
        }
        assertNotNull(add);
        assertNotNull(add1);
    }

    @Test
    public void whenDeleteNewItemThenTrackerHasNullItem() throws Exception {
        Item add = null;
        Item add1 = null;

        try (TrackerSQL tracker = new TrackerSQL()) {
            assertNotNull(tracker.init());
            Item item = new Item("1", "1", "test1", 1, "test1");
            Item item1 = new Item("2", "2", "test2", 2, "test2");
            Item[] test = {item1};
            add1 = tracker.add(item);
            add = tracker.add(item1);

            tracker.delete(item.getId());
            assertThat(tracker.findAll(), is(test));
        }
        assertNotNull(add);
        assertNotNull(add1);
    }
}
