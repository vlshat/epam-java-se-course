package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladislaw on 24.02.17.
 */
public class Folder extends OfficeSupply{

    private List<Paper> folder = new ArrayList<>();

    public Folder(String title, BigDecimal price) {
        super(title, price);
    }

    public void addPaper(Paper paper){
        folder.add(paper);
    }

    public List<Paper> getPapers(){
        return folder;
    }
}
