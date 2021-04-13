package model;

public class Records {
    private Record[] data;

    public Records(Record[] data) {
        this.data = data;
    }

    public Records() {
        this(new Record[0]);
    }

    public Records(int n){
        this(new Record[n]);
    }

    public Record[] getData() {
        return data;
    }

    public void setData(Record[] data) {
        this.data = data;
    }

    public void addRecord(Record record){
        Record[] newRecords = new Record[data.length+1];
        for (int i = 0; i < data.length; i++) {
            newRecords[i]=data[i];
        }
        newRecords[newRecords.length-1] = record;
        data=newRecords;
    }

    public Records delete(Records toDelete){
        for (int i = 0; i < this.getData().length; i++) {
            boolean successfullyDelete = false;
            for (int j = 0; j < toDelete.getData().length && !successfullyDelete; j++) {
                if (toDelete.getData()[j]==this.getData()[i]){
                    delete(this.getData()[i]);
                    successfullyDelete=true;
                }
            }
            if (successfullyDelete){
                i--;
            }
        }
        return this;
    }

    private void delete(Record record){
        Record[] newRecords = new Record[getData().length-1];
        int j=0;
        for (int i = 0; i < getData().length; i++) {
            if (getData()[i]!=record){
                newRecords[j]=getData()[i];
                j++;
            }
        }
        setData(newRecords);
    }
}
