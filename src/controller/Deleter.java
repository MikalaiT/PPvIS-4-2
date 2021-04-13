package controller;

import model.Records;
import view.Table;

public class Deleter {
    public static int delete(Table table, String[] args){
        Records toDelete = Searcher.search(table.getRecords(), args);
        table.setRecords(table.getRecords().delete(toDelete));
        return toDelete.getData().length;
    }
}
