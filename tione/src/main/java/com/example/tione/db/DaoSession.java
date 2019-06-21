package com.example.tione.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.tione.Fengzhuang;

import com.example.tione.db.FengzhuangDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig fengzhuangDaoConfig;

    private final FengzhuangDao fengzhuangDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        fengzhuangDaoConfig = daoConfigMap.get(FengzhuangDao.class).clone();
        fengzhuangDaoConfig.initIdentityScope(type);

        fengzhuangDao = new FengzhuangDao(fengzhuangDaoConfig, this);

        registerDao(Fengzhuang.class, fengzhuangDao);
    }
    
    public void clear() {
        fengzhuangDaoConfig.clearIdentityScope();
    }

    public FengzhuangDao getFengzhuangDao() {
        return fengzhuangDao;
    }

}
