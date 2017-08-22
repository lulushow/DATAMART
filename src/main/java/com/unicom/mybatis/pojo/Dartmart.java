package com.unicom.mybatis.pojo;

import java.math.BigDecimal;

public class Dartmart {
    private String datatype;

    private String databroadtype;

    private String factory;

    private String netelement;

    private String pointertype;

    private String datadate;

    private String province;

    private String filename;

    private BigDecimal filesize;

    private String filepath;

    private String datasource;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public BigDecimal getFilesize() {
        return filesize;
    }

    public void setFilesize(BigDecimal filesize) {
        this.filesize = filesize;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }
}