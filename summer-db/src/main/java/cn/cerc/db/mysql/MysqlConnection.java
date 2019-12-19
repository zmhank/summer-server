package cn.cerc.db.mysql;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MysqlConnection extends SqlConnection {
    // IHandle中识别码
    public static final String sessionId = "sqlSession";
    // Properties中识别码
    public static final String rds_site = "rds.site";
    public static final String rds_database = "rds.database";
    public static final String rds_username = "rds.username";
    public static final String rds_password = "rds.password";

    public static String dataSource = "dataSource";

    @Override
    public String getClientId() {
        return sessionId;
    }

    @Override
    protected String getConnectUrl() {
        String host = config.getProperty(MysqlConnection.rds_site, "127.0.0.1:3306");
        String db = config.getProperty(MysqlConnection.rds_database, "appdb");
        user = config.getProperty(MysqlConnection.rds_username, "appdb_user");
        pwd = config.getProperty(MysqlConnection.rds_password, "appdb_password");
        if (host == null || user == null || pwd == null || db == null)
            throw new RuntimeException("RDS配置为空，无法连接主机！");

        return String.format("jdbc:mysql://%s/%s?useSSL=false", host, db);
    }

}
