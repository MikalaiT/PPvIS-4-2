package model;

public class Producer {
    private String name;
    private int unp;

    public Producer(String name, int unp) {
        this.name = name;
        this.unp = unp;
    }

    public Producer(String name) {
        this(name,88888);
    }

    public Producer(int unp) {
        this("имя производителя",unp);
    }

    public Producer() {
        this("имя производителя",88888);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnp() {
        return unp;
    }

    public void setUnp(int unp) {
        this.unp = unp;
    }
}
