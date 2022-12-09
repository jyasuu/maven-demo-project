/*
 * This file is generated by jOOQ.
 */
package com.demo.codegen.tables;


import com.demo.codegen.Indexes;
import com.demo.codegen.Keys;
import com.demo.codegen.Public;
import com.demo.codegen.tables.records.FtpServerRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class FtpServer extends TableImpl<FtpServerRecord> {

    private static final long serialVersionUID = -483007383;

    /**
     * The reference instance of <code>public.ftp_server</code>
     */
    public static final FtpServer FTP_SERVER = new FtpServer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FtpServerRecord> getRecordType() {
        return FtpServerRecord.class;
    }

    /**
     * The column <code>public.ftp_server.id</code>.
     */
    public final TableField<FtpServerRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).defaultValue(org.jooq.impl.DSL.field("gen_random_uuid()", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>public.ftp_server.name</code>.
     */
    public final TableField<FtpServerRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server.ip</code>.
     */
    public final TableField<FtpServerRecord, String> IP = createField(DSL.name("ip"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server.fqdn</code>.
     */
    public final TableField<FtpServerRecord, String> FQDN = createField(DSL.name("fqdn"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.ftp_server.create_time</code>.
     */
    public final TableField<FtpServerRecord, Timestamp> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.ftp_server.is_self_host</code>.
     */
    public final TableField<FtpServerRecord, String> IS_SELF_HOST = createField(DSL.name("is_self_host"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).defaultValue(org.jooq.impl.DSL.field("'Y'::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>public.ftp_server</code> table reference
     */
    public FtpServer() {
        this(DSL.name("ftp_server"), null);
    }

    /**
     * Create an aliased <code>public.ftp_server</code> table reference
     */
    public FtpServer(String alias) {
        this(DSL.name(alias), FTP_SERVER);
    }

    /**
     * Create an aliased <code>public.ftp_server</code> table reference
     */
    public FtpServer(Name alias) {
        this(alias, FTP_SERVER);
    }

    private FtpServer(Name alias, Table<FtpServerRecord> aliased) {
        this(alias, aliased, null);
    }

    private FtpServer(Name alias, Table<FtpServerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> FtpServer(Table<O> child, ForeignKey<O, FtpServerRecord> key) {
        super(child, key, FTP_SERVER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FTP_SERVER_PK);
    }

    @Override
    public UniqueKey<FtpServerRecord> getPrimaryKey() {
        return Keys.FTP_SERVER_PK;
    }

    @Override
    public List<UniqueKey<FtpServerRecord>> getKeys() {
        return Arrays.<UniqueKey<FtpServerRecord>>asList(Keys.FTP_SERVER_PK);
    }

    @Override
    public FtpServer as(String alias) {
        return new FtpServer(DSL.name(alias), this);
    }

    @Override
    public FtpServer as(Name alias) {
        return new FtpServer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FtpServer rename(String name) {
        return new FtpServer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FtpServer rename(Name name) {
        return new FtpServer(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, Timestamp, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}