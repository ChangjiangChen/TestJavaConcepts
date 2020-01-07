package com.algorithm.learn.test.unit1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author : Chen Changjiang
 * @date : 2019/12/17
 * @description :
 */
@XmlRootElement(name = "sendresult")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTestEntity {
    private String errorcode;
    private String message;
    private String SMSID;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSMSID() {
        return SMSID;
    }

    public void setSMSID(String SMSID) {
        this.SMSID = SMSID;
    }

    @Override
    public String toString() {
        return "XmlTestEntity{" +
                "errorcode='" + errorcode + '\'' +
                ", message='" + message + '\'' +
                ", SMSID='" + SMSID + '\'' +
                '}';
    }
}
