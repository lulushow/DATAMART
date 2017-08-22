package com.unicom.mybatis.pojo;

import java.math.BigDecimal;

public class DartmartCata {
    private String datatype;

    private String databroadtype;

    private String factory;

    private String netelement;

    private String pointertype;

    private String datadate;

    private BigDecimal datasize;

    private String introduce;

    private String datadetail;

    private String dataexample;

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getDatabroadtype() {
        return databroadtype;
    }

    public void setDatabroadtype(String databroadtype) {
        this.databroadtype = databroadtype == null ? null : databroadtype.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getNetelement() {
        return netelement;
    }

    public void setNetelement(String netelement) {
        this.netelement = netelement == null ? null : netelement.trim();
    }

    public String getPointertype() {
        return pointertype;
    }

    public void setPointertype(String pointertype) {
        this.pointertype = pointertype == null ? null : pointertype.trim();
    }

    public String getDatadate() {
        return datadate;
    }

    public void setDatadate(String datadate) {
        this.datadate = datadate == null ? null : datadate.trim();
    }

    public BigDecimal getDatasize() {
        return datasize;
    }

    public void setDatasize(BigDecimal datasize) {
        this.datasize = datasize;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getDatadetail() {
        return datadetail;
    }

    public void setDatadetail(String datadetail) {
        this.datadetail = datadetail == null ? null : datadetail.trim();
    }

    public String getDataexample() {
        return dataexample;
    }

    public void setDataexample(String dataexample) {
        this.dataexample = dataexample == null ? null : dataexample.trim();
    }
}