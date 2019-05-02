package com.fec.report.dao;

public class ManualBankCard {
    private String account;
    private String bank;
    private String id;
    private Long local_fkIr;
    private Long local_id;
    private String note;
    private String passport;
    private String phone;

    public ManualBankCard(Long local_id) {
        this.local_id = local_id;
    }

    public ManualBankCard(Long local_id, String id, Long local_fkIr, String bank, String account, String phone, String passport, String note) {
        this.local_id = local_id;
        this.id = id;
        this.local_fkIr = local_fkIr;
        this.bank = bank;
        this.account = account;
        this.phone = phone;
        this.passport = passport;
        this.note = note;
    }

    public Long getLocal_id() {
        return this.local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLocal_fkIr() {
        return this.local_fkIr;
    }

    public void setLocal_fkIr(Long local_fkIr) {
        this.local_fkIr = local_fkIr;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
