package com.example.tione;

import com.example.tione.db.DaoMaster;
import com.example.tione.db.DaoSession;
import com.example.tione.db.FengzhuangDao;

import java.util.List;

public class Datahelper {
    private  static Datahelper datahelper;
    private FengzhuangDao fengzhuangDao;

    public static Datahelper getDatahelper() {
        if (datahelper==null){
            synchronized (Datahelper.class){
                if (datahelper==null){
                    datahelper =new Datahelper();
                }
            }
        }
        return datahelper;
    }

    public Datahelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "ss.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        fengzhuangDao = daoSession.getFengzhuangDao();
    }
    public void insert(Fengzhuang fengzhuang){
        fengzhuangDao.insertOrReplace(fengzhuang);
    }
    public List<Fengzhuang> quary(){
        return fengzhuangDao.queryBuilder().list();
    }
}
