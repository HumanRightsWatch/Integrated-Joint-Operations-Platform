package com.fec.report.dao;

public class InvestigateSoft {
    private String account;
    private Integer fkSDic;
    private String id;
    private Long local_fkIr;
    private Long local_id;
    private String note;

    public InvestigateSoft(Long local_id) {
        this.local_id = local_id;
    }

    public InvestigateSoft(Long local_id, String id, Long local_fkIr, Integer fkSDic, String account, String note) {
        this.local_id = local_id;
        this.id = id;
        this.local_fkIr = local_fkIr;
        this.fkSDic = fkSDic;
        this.account = account;
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

    public Integer getFkSDic() {
        return this.fkSDic;
    }

    public void setFkSDic(Integer fkSDic) {
        this.fkSDic = fkSDic;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
