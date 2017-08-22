package com.unicom.mybatis.pojo;

import java.math.BigDecimal;

/**
 * Created by Dian on 2017/7/7.
 */
public class IndexData {
    private String datatype;

    private String databroadtype;

    private String datadate;//日期

    private BigDecimal datasize;//文件大小

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDatabroadtype() {
        return databroadtype;
    }

    public void setDatabroadtype(String databroadtype) {
        this.databroadtype = databroadtype;
    }

    public String getDatadate() {
        return datadate;
    }

    public void setDatadate(String datadate) {
        this.datadate = datadate;
    }

    public BigDecimal getDatasize() {
        return datasize;
    }

    public void setDatasize(BigDecimal datasize) {
        this.datasize = datasize;
    }

}
