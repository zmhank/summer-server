package cn.cerc.db.core;

import cn.cerc.db.mysql.MysqlConnection;

public interface IHandle extends ISessionOwner{
    
    default Object getProperty(String key) {
        return getSession().getProperty(key);
    }

    default String getCorpNo() {
        return getSession().getCorpNo();
    }

    default String getUserCode() {
        return getSession().getUserCode();
    }

    default String getUserName() {
        return getSession().getUserName();
    }

    // 设置自定义参数
    default void setProperty(String key, Object value) {
        getSession().setProperty(key, value);
    }

    default void close() {
        getSession().close();
    }

    default MysqlConnection getConnection() {
        return (MysqlConnection) getSession().getProperty(MysqlConnection.sessionId);
    }

}
