package com.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.jooq.impl.DSL.*;
import static org.jooq.SQLDialect.*;
import static com.demo.codegen.Tables.*;
import org.jooq.*;
import org.jooq.impl.*;
import java.sql.DriverManager;
import java.sql.Connection;
import org.snakeyaml.engine.v2.api.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App. https://www.jooq.org/javadoc/dev/org.jooq/org/jooq/impl/DSL.html
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void jooqSelectDemo()
    {
        System.out.println(
            select(ACCOUNT.NAME)
            .from(ACCOUNT)
            );

        assertTrue( true );
    }

    @Test
    public void jooqUpdateDemo()
    {
        System.out.println(
            update(ACCOUNT)
            .set(ACCOUNT.NAME, "bbb")
            .set(ACCOUNT.PASSWORD, "ccc")
            .where(ACCOUNT.ID.eq("aaa"))
            );
        assertTrue( true );
    }
    
    @Test
    public void jooqInsertDemo()
    {
        System.out.println(
            insertInto(ACCOUNT, ACCOUNT.NAME,ACCOUNT.PASSWORD)
            .values("asd","asd")
            .values("bas","bas")
            );

        assertTrue( true );
    }
    
    @Test
    public void jooqDeleteDemo()
    {
        System.out.println(
            deleteFrom(ACCOUNT)
            .where(ACCOUNT.ID.eq("aaa"))
            );

        assertTrue( true );
    }
    
    @Test
    public void jooqDemo()
    {
        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);

            System.out.println(
                create.deleteFrom(ACCOUNT)
                .where(ACCOUNT.NAME.eq("asd"))
                .execute()
                );
            System.out.println(
                create.deleteFrom(ACCOUNT)
                .where(ACCOUNT.NAME.eq("bas"))
                .execute()
                );


            System.out.println(
                create.insertInto(ACCOUNT, ACCOUNT.NAME,ACCOUNT.PASSWORD,ACCOUNT.EMAIL)
                .values("asd","asd","asd")
                .values("bas","bas","asd")
                .execute());

            Result<org.jooq.Record> result = create.select().from(ACCOUNT).fetch();
            
            
            String json = create.selectFrom(ACCOUNT).fetch().formatJSON();

            // ObjectMapper objectMapper = new ObjectMapper();
            // String json = objectMapper.writeValueAsString(result);

            System.out.println(json);

            // https://www.jooq.org/doc/3.10/manual/sql-execution/fetching/pojos/
            
            for (org.jooq.Record r : result) {
                Object id = r.getValue(ACCOUNT.ID);

                System.out.println("ID: " + id );
            }
        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue( true );
    }
    
    @Test
    public void yamlDemo()
    {
        LoadSettings settings = LoadSettings.builder().build();
        Load load = new Load(settings); 
        Map<String, Object> map = (Map<String, Object>) load.loadFromString("a: 1\nb: 2\nc:\n  - aaa\n  - bbb");
        System.out.println(map);

                
        DumpSettings settings2 = DumpSettings.builder().build();
        Dump dump = new Dump(settings2);
        String output = dump.dumpToString(map);
        System.out.println(output);


        assertTrue( true );
    }
    
}
