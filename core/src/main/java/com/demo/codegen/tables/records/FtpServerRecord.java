/*
 * This file is generated by jOOQ.
 */
package com.demo.codegen.tables.records;


import com.demo.codegen.tables.FtpServer;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class FtpServerRecord extends UpdatableRecordImpl<FtpServerRecord> implements Record6<String, String, String, String, Timestamp, String> {

    private static final long serialVersionUID = 604093785;

    /**
     * Setter for <code>public.ftp_server.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ftp_server.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.ftp_server.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ftp_server.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.ftp_server.ip</code>.
     */
    public void setIp(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.ftp_server.ip</code>.
     */
    public String getIp() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.ftp_server.fqdn</code>.
     */
    public void setFqdn(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.ftp_server.fqdn</code>.
     */
    public String getFqdn() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.ftp_server.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.ftp_server.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.ftp_server.is_self_host</code>.
     */
    public void setIsSelfHost(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.ftp_server.is_self_host</code>.
     */
    public String getIsSelfHost() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, Timestamp, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, String, String, String, Timestamp, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return FtpServer.FTP_SERVER.ID;
    }

    @Override
    public Field<String> field2() {
        return FtpServer.FTP_SERVER.NAME;
    }

    @Override
    public Field<String> field3() {
        return FtpServer.FTP_SERVER.IP;
    }

    @Override
    public Field<String> field4() {
        return FtpServer.FTP_SERVER.FQDN;
    }

    @Override
    public Field<Timestamp> field5() {
        return FtpServer.FTP_SERVER.CREATE_TIME;
    }

    @Override
    public Field<String> field6() {
        return FtpServer.FTP_SERVER.IS_SELF_HOST;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getIp();
    }

    @Override
    public String component4() {
        return getFqdn();
    }

    @Override
    public Timestamp component5() {
        return getCreateTime();
    }

    @Override
    public String component6() {
        return getIsSelfHost();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getIp();
    }

    @Override
    public String value4() {
        return getFqdn();
    }

    @Override
    public Timestamp value5() {
        return getCreateTime();
    }

    @Override
    public String value6() {
        return getIsSelfHost();
    }

    @Override
    public FtpServerRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public FtpServerRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public FtpServerRecord value3(String value) {
        setIp(value);
        return this;
    }

    @Override
    public FtpServerRecord value4(String value) {
        setFqdn(value);
        return this;
    }

    @Override
    public FtpServerRecord value5(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public FtpServerRecord value6(String value) {
        setIsSelfHost(value);
        return this;
    }

    @Override
    public FtpServerRecord values(String value1, String value2, String value3, String value4, Timestamp value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FtpServerRecord
     */
    public FtpServerRecord() {
        super(FtpServer.FTP_SERVER);
    }

    /**
     * Create a detached, initialised FtpServerRecord
     */
    public FtpServerRecord(String id, String name, String ip, String fqdn, Timestamp createTime, String isSelfHost) {
        super(FtpServer.FTP_SERVER);

        set(0, id);
        set(1, name);
        set(2, ip);
        set(3, fqdn);
        set(4, createTime);
        set(5, isSelfHost);
    }
}
