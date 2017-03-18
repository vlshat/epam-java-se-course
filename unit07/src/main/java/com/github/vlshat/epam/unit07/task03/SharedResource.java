package com.github.vlshat.epam.unit07.task03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 18.03.17.
 */
public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
