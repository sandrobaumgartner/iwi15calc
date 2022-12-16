package at.edu.c02.calculator;

import java.util.HashMap;

public class Store {
    private static Store instance;
    private Double singleStore;
    private HashMap<String, Double> bigStore;

    private Store() {
        bigStore = new HashMap<>();
    }

    public static Store getInstance() {
        if(instance == null) {
            return new Store();
        }
        return instance;
    }

    public double getSingleStore() {
        return singleStore;
    }

    public void setSingleStore(Double singleStore) {
        this.singleStore = singleStore;
    }

    public HashMap<String, Double> getBigStore() {
        return bigStore;
    }

    public void setBigStore(HashMap<String, Double> bigStore) {
        this.bigStore = bigStore;
    }
}
