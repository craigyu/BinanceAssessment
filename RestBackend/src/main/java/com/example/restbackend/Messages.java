package com.example.restbackend;

import java.util.ArrayList;
import java.util.List;

//    message_id: '1102354892',
//    message_content: 'New coin release',
//    telegram_group: 'All Telegram Groups',
//    status: 'Pending',
//    type: 'Scheduled',
//    send_time: '2022-03-05 11:13:22(UTC)',
//    creation_time: '2022-02-28 05:21:34(UTC)',
//    creator: 'handsomeguy@binance.us'

public class Messages {
    private List<Message> messages = new ArrayList<>();

    private long generateId(){
        long id = (long) Math.floor(Math.random() * 9_000_000_000_000_000L) + 1_000_000_000_000_000L;
        return id;
    }

    public Messages(){
        Message m1 = new Message("9360383266653429", "New coin release", "All telegram Groups",
                "Sent", "Scheduled", "2021-03-05 11:13:22(UTC)", "2021-02-28 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m2 = new Message("8529315708274648", "New promotion", "All telegram Groups",
                "Sent", "Scheduled", "2021-05-12 17:23:45(UTC)", "2021-04-11 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m3 = new Message("1708529955075789", "New coin release", "All telegram Groups",
                "Sent", "Scheduled", "2022-06-02 11:13:22(UTC)", "2022-06-01 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m4 = new Message("8756468295309768", "Coin delisted", "All telegram Groups",
                "Sent", "Scheduled", "2022-07-10 11:13:22(UTC)", "2022-07-09 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m5 = new Message("0674556648161252", "New Promotion", "All telegram Groups",
                "Sent", "Scheduled", "2022-08-15 11:13:22(UTC)", "2022-08-13 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m6 = new Message("6520611311001379", "Tips and guide", "All telegram Groups",
                "Sent", "Scheduled", "2022-09-03 11:13:22(UTC)", "2022-09-02 05:21:34(UTC)", "handsomeguy@binance.us");
        Message m7 = new Message("8893984262622496", "New coin release", "All telegram Groups",
                "Sent", "Scheduled", "2022-09-17 11:13:22(UTC)", "2022-09-15 05:21:34(UTC)", "smartgirl@binance.us");
        Message m8 = new Message("5229752626214998", "Holiday info", "All telegram Groups",
                "Pending", "Scheduled", "2022-10-20 11:13:22(UTC)", "2022-09-09 05:21:34(UTC)", "smartgirl@binance.us");
        Message m9 = new Message("5036875791783273", "Tips and guide", "All telegram Groups",
                "Pending", "Scheduled", "2022-10-22 11:13:22(UTC)", "2022-09-10 05:21:34(UTC)", "smartgirl@binance.us");
        Message m10 = new Message("0674556648161252", "New coin release", "All telegram Groups",
                "Pending", "Scheduled", "2022-10-25 11:13:22(UTC)", "2022-09-20 05:21:34(UTC)", "smartgirl@binance.us");

        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);
        messages.add(m5);
        messages.add(m6);
        messages.add(m7);
        messages.add(m8);
        messages.add(m9);
        messages.add(m10);
    }

    public List<Message> getMessages(){
        return messages;
    }

    public String addMessage(Message newMessage){
        long newId = generateId();
        String idString = Long.toString(newId);
        newMessage.setId(idString);
        messages.add(newMessage);
        return idString;
    }

    public String updateMessage(String updateId, Message updatedMessage){
        // a stupid way to make sure the ID can't be modified
        updatedMessage.setId(updateId);

        int length = messages.size();

        for (int i = 0; i < length; i++){
            Message curr_message = messages.get(i);
            String curr_id = curr_message.getId();
            if (curr_id.equals(updateId)){
                messages.set(i, updatedMessage);
                return updateId;
            }
        }
        return null;
    }

    public void deleteMessage(String delId){
        messages.removeIf(obj -> obj.getId().equals(delId));
    }


}
