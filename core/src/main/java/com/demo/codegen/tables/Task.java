/*
 * This file is generated by jOOQ.
 */
package com.demo.codegen.tables;


import com.demo.codegen.Indexes;
import com.demo.codegen.Keys;
import com.demo.codegen.Public;
import com.demo.codegen.tables.records.TaskRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
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
public class Task extends TableImpl<TaskRecord> {

    private static final long serialVersionUID = -15481841;

    /**
     * The reference instance of <code>public.task</code>
     */
    public static final Task TASK = new Task();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TaskRecord> getRecordType() {
        return TaskRecord.class;
    }

    /**
     * The column <code>public.task.id</code>.
     */
    public final TableField<TaskRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).defaultValue(org.jooq.impl.DSL.field("gen_random_uuid()", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>public.task.origin_ftp_server_id</code>.
     */
    public final TableField<TaskRecord, String> ORIGIN_FTP_SERVER_ID = createField(DSL.name("origin_ftp_server_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.task.dest_ftp_server_id</code>.
     */
    public final TableField<TaskRecord, String> DEST_FTP_SERVER_ID = createField(DSL.name("dest_ftp_server_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.task.file_path</code>.
     */
    public final TableField<TaskRecord, String> FILE_PATH = createField(DSL.name("file_path"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.task.status</code>.
     */
    public final TableField<TaskRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.task.create_time</code>.
     */
    public final TableField<TaskRecord, Timestamp> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.task.create_account_id</code>.
     */
    public final TableField<TaskRecord, String> CREATE_ACCOUNT_ID = createField(DSL.name("create_account_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.task.finish_time</code>.
     */
    public final TableField<TaskRecord, Timestamp> FINISH_TIME = createField(DSL.name("finish_time"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.task.dest_account_id</code>.
     */
    public final TableField<TaskRecord, String> DEST_ACCOUNT_ID = createField(DSL.name("dest_account_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * Create a <code>public.task</code> table reference
     */
    public Task() {
        this(DSL.name("task"), null);
    }

    /**
     * Create an aliased <code>public.task</code> table reference
     */
    public Task(String alias) {
        this(DSL.name(alias), TASK);
    }

    /**
     * Create an aliased <code>public.task</code> table reference
     */
    public Task(Name alias) {
        this(alias, TASK);
    }

    private Task(Name alias, Table<TaskRecord> aliased) {
        this(alias, aliased, null);
    }

    private Task(Name alias, Table<TaskRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Task(Table<O> child, ForeignKey<O, TaskRecord> key) {
        super(child, key, TASK);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TASK_PK);
    }

    @Override
    public UniqueKey<TaskRecord> getPrimaryKey() {
        return Keys.TASK_PK;
    }

    @Override
    public List<UniqueKey<TaskRecord>> getKeys() {
        return Arrays.<UniqueKey<TaskRecord>>asList(Keys.TASK_PK);
    }

    @Override
    public List<ForeignKey<TaskRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TaskRecord, ?>>asList(Keys.TASK__TASK_ORIGIN_FTP_SERVER_FK, Keys.TASK__TASK_DEST_FTP_SERVER_FK, Keys.TASK__TASK_ACCOUNT_FK, Keys.TASK__TASK_DEST_ACCOUNT_FK);
    }

    public FtpServer task_TaskOriginFtpServerFk() {
        return new FtpServer(this, Keys.TASK__TASK_ORIGIN_FTP_SERVER_FK);
    }

    public FtpServer task_TaskDestFtpServerFk() {
        return new FtpServer(this, Keys.TASK__TASK_DEST_FTP_SERVER_FK);
    }

    public Account task_TaskAccountFk() {
        return new Account(this, Keys.TASK__TASK_ACCOUNT_FK);
    }

    public Account task_TaskDestAccountFk() {
        return new Account(this, Keys.TASK__TASK_DEST_ACCOUNT_FK);
    }

    @Override
    public Task as(String alias) {
        return new Task(DSL.name(alias), this);
    }

    @Override
    public Task as(Name alias) {
        return new Task(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Task rename(String name) {
        return new Task(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Task rename(Name name) {
        return new Task(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, Timestamp, String, Timestamp, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
