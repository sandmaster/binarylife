package se.moondrop.binarylife.active.repo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.moondrop.binarylife.active.object.Activity;
import se.moondrop.binarylife.active.object.RepoObj;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ActivityRepo  {
    private static final Logger log = LogManager.getLogger(ActivityRepo.class.getName());

    @Autowired
    private MDDatabase db;

    public void init() {
        Connection conn = db.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS activity (id INTEGER PRIMARY KEY, name TEXT NOT NULL, description TEXT, remValue REAL NOT NULL");
            statement.close();
            conn.close();
        } catch (SQLException e) {
           log.error("Access to the database failed");
        } catch (NullPointerException npe){
            log.error("NullPointerException caught", npe);
        }
    }

    public boolean store(Activity active) {

//        if(description.isBlank()){
//            description = "No description for this activity has been put";
//        }
        Connection conn = db.getConnection();

        try {
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO activity VALUES ("+active.getName()+", " + active.getDescription() + ", " + active.getRemValue());
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public RepoObj retrieve(String userId, String name) {
        return null;
    }
}
