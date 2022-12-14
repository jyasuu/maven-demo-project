/*
 * This file is generated by jOOQ.
 */
package com.demo.codegen.tables;


import com.demo.codegen.Keys;
import com.demo.codegen.Public;
import com.demo.codegen.tables.records.FtpServerAccountRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FtpServerAccount extends TableImpl<FtpServerAccountRecord> {

    private static final long serialVersionUID = 297688333;

    /**
     * The reference instance of <code>public.ftp_server_account</code>
     */
    public static final FtpServerAccount FTP_SERVER_ACCOUNT = new FtpServerAccount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FtpServerAccountRecord> getRecordType() {
        return FtpServerAccountRecord.class;
    }

    /**
     * The column <code>public.ftp_server_account.id</code>.
     */
    public final TableField<FtpServerAccountRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.account_id</code>.
     */
    public final TableField<FtpServerAccountRecord, String> ACCOUNT_ID = createField(DSL.name("account_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.ftp_server_id</code>.
     */
    public final TableField<FtpServerAccountRecord, String> FTP_SERVER_ID = createField(DSL.name("ftp_server_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.account</code>.
     */
    public final TableField<FtpServerAccountRecord, String> ACCOUNT = createField(DSL.name("account"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.password</code>.
     */
    public final TableField<FtpServerAccountRecord, String> PASSWORD = createField(DSL.name("password"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.status</code>.
     */
    public final TableField<FtpServerAccountRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server_account.create_time</code>.
     */
    public final TableField<FtpServerAccountRecord, Timestamp> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.ftp_server_account</code> table reference
     */
    public FtpServerAccount() {
        this(DSL.name("ftp_server_account"), null);
    }

    /**
     * Create an aliased <code>public.ftp_server_account</code> table reference
     */
    public FtpServerAccount(String alias) {
        this(DSL.name(alias), FTP_SERVER_ACCOUNT);
    }

    /**
     * Create an aliased <code>public.ftp_server_account</code> table reference
     */
    public FtpServerAccount(Name alias) {
        this(alias, FTP_SERVER_ACCOUNT);
    }

    private FtpServerAccount(Name alias, Table<FtpServerAccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private FtpServerAccount(Name alias, Table<FtpServerAccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> FtpServerAccount(Table<O> child, ForeignKey<O, FtpServerAccountRecord> key) {
        super(child, key, FTP_SERVER_ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<ForeignKey<FtpServerAccountRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FtpServerAccountRecord, ?>>asList(Keys.FTP_SERVER_ACCOUNT__FTP_SERVER_ACCOUNT_FK_1, Keys.FTP_SERVER_ACCOUNT__FTP_SERVER_ACCOUNT_FK);
    }

    public Account account() {
        return new Account(this, Keys.FTP_SERVER_ACCOUNT__FTP_SERVER_ACCOUNT_FK_1);
    }

    public FtpServer ftpServer() {
        return new FtpServer(this, Keys.FTP_SERVER_ACCOUNT__FTP_SERVER_ACCOUNT_FK);
    }

    @Override
    public FtpServerAccount as(String alias) {
        return new FtpServerAccount(DSL.name(alias), this);
    }

    @Override
    public FtpServerAccount as(Name alias) {
        return new FtpServerAccount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FtpServerAccount rename(String name) {
        return new FtpServerAccount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FtpServerAccount rename(Name name) {
        return new FtpServerAccount(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
