package com.demo.treeSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item  implements Comparable<Item>{
    private String description;
    private int partNum;

    @Override
    public String toString() {
        return "[" +
                "description='" + description +
                ", partNum=" + partNum +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNum == item.partNum && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNum);
    }

    @Override
    public int compareTo(Item o) {
        int dif = Integer.compare(partNum,o.partNum);
        return dif != 0 ? dif : description.compareTo(o.description);
    }

}
