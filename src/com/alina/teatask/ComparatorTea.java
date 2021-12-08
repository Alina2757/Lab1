package com.alina.teatask;

import com.alina.teatask.tea.Tea;

import java.util.Comparator;

public class ComparatorTea implements Comparator<Tea> {

    @Override
    public int compare(Tea o1, Tea o2) {
        //compare teas by theirs name lengths
        return Integer.compare(o1.getTaste().name().length(),
                o2.getTaste().name().length());
    }
}
