package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {

        super(emailId, Integer.MAX_VALUE); // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar = new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        Collections.sort(calendar, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getEnd().compareTo(m2.getEnd());
            }
        });

        int maxMeetings = 0;
        LocalTime currentEndTime = LocalTime.MIN;

        // Iterate through the sorted meetings
        for (Meeting meeting : calendar) {
            // If the start time of the meeting is after or equal to the current end time,
            // attend the meeting and update the current end time
            if (meeting.getStart().compareTo(currentEndTime) >= 0) {
                maxMeetings++;
                currentEndTime = meeting.getEnd();
            }
        }

        return maxMeetings;

    }
}
