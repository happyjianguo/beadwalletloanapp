package com.waterelephant.rongCarrier.JSonEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 月消费记录
 *
 * @author GuoKun
 * @version 1.0
 * @create_date 2017/5/16 12:01
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class MonthlyConsumption {

    /**
     * called_cnt : 6
     * talk_seconds : 623
     * talk_cnt : 11
     * msg_cnt : 2
     * called_seconds : 284
     * receive_cnt : 0
     * month : 2017-05
     * call_cnt : 5
     * unknown_cnt : 0
     * call_consumption : 21.92
     * send_cnt : 2
     * call_seconds : 339
     */

    private int called_cnt;
    private int talk_seconds;
    private int talk_cnt;
    private int msg_cnt;
    private int called_seconds;
    private int receive_cnt;
    private String month;
    private int call_cnt;
    private int unknown_cnt;
    private double call_consumption;
    private int send_cnt;
    private int call_seconds;

    public int getCalled_cnt() {
        return called_cnt;
    }

    public void setCalled_cnt(int called_cnt) {
        this.called_cnt = called_cnt;
    }

    public int getTalk_seconds() {
        return talk_seconds;
    }

    public void setTalk_seconds(int talk_seconds) {
        this.talk_seconds = talk_seconds;
    }

    public int getTalk_cnt() {
        return talk_cnt;
    }

    public void setTalk_cnt(int talk_cnt) {
        this.talk_cnt = talk_cnt;
    }

    public int getMsg_cnt() {
        return msg_cnt;
    }

    public void setMsg_cnt(int msg_cnt) {
        this.msg_cnt = msg_cnt;
    }

    public int getCalled_seconds() {
        return called_seconds;
    }

    public void setCalled_seconds(int called_seconds) {
        this.called_seconds = called_seconds;
    }

    public int getReceive_cnt() {
        return receive_cnt;
    }

    public void setReceive_cnt(int receive_cnt) {
        this.receive_cnt = receive_cnt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public int getUnknown_cnt() {
        return unknown_cnt;
    }

    public void setUnknown_cnt(int unknown_cnt) {
        this.unknown_cnt = unknown_cnt;
    }

    public double getCall_consumption() {
        return call_consumption;
    }

    public void setCall_consumption(double call_consumption) {
        this.call_consumption = call_consumption;
    }

    public int getSend_cnt() {
        return send_cnt;
    }

    public void setSend_cnt(int send_cnt) {
        this.send_cnt = send_cnt;
    }

    public int getCall_seconds() {
        return call_seconds;
    }

    public void setCall_seconds(int call_seconds) {
        this.call_seconds = call_seconds;
    }
}
