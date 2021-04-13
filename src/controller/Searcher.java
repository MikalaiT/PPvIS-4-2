package controller;

import com.sun.istack.internal.Nullable;
import model.Record;
import model.Records;
import view.Table;

public class Searcher {
//    String productName, String producerName, String producerUNP, String warehouseAmount, String warehouseAddress
    public static Records search(Records records, String[] args){
        Records forReturn = new Records();
        for (int i = 0; i < records.getData().length; i++) {
            Record record = records.getData()[i];
            if ((args[0] != null && record.getProduct().getName().equals(args[0])) ||
                    (args[1] != null && record.getProducer().getName().equals(args[1])) ||
                    (args[2] != null && String.valueOf(record.getProducer().getUnp()).equals(args[2])) ||
                    (args[3] != null && String.valueOf(record.getProduct().getWarehouseAmount()).equals(args[3])) ||
                    (args[4] != null && record.getWarehouse().getAddress().getFullAddress().equals(args[4]))) {
                forReturn.addRecord(record);
            }
        }
        return forReturn;
    }
}
