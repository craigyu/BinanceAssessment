package com.example.restbackend;

public class Message {
//    message_id: '1102354892',
//    message_content: 'New coin release',
//    telegram_group: 'All Telegram Groups',
//    status: 'Pending',
//    type: 'Scheduled',
//    send_time: '2022-03-05 11:13:22(UTC)',
//    creation_time: '2022-02-28 05:21:34(UTC)',
//    creator: 'handsomeguy@binance.us'
    private String message_id;
    private String message_content;
    private String telegram_group;
    private String status;
    private String type;
    private String send_time;
    private String creation_time;
    private String creator;

    public Message(String message_id, String message_content, String telegram_group,
                   String status, String type, String send_time, String creation_time, String creator){
        this.message_id = message_id;
        this.message_content = message_content;
        this.telegram_group = telegram_group;
        this.status = status;
        this.type = type;
        this.send_time = send_time;
        this.creation_time = creation_time;
        this.creator = creator;
    }

    public String getId(){
        return message_id;
    }

    public void setId(String message_id){
        this.message_id = message_id;
    }

    public String getContent(){
        return message_content;
    }

    public void setContent(String content){
        this.message_content = content;
    }

    public String getGroup(){
        return telegram_group;
    }

    public void setGroup(String group){
        this.telegram_group = group;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getSendTime(){
        return send_time;
    }

    public void setSendTime(String send_time){
        this.send_time = send_time;
    }

    public String getCreationTime(){
        return creation_time;
    }

    public void setCreationTime(String creation_time){
        this.send_time = creation_time;
    }

    public String getCreator(){
        return creator;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }
}
