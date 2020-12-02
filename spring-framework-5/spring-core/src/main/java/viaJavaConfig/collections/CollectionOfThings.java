package viaJavaConfig.collections;

import java.util.List;

public class CollectionOfThings {
    List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "CollectionOfThings{" +
                "names=" + names +
                '}';
    }
}
