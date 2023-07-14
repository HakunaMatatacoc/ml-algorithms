package greed;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingTest {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
        int n = cin.nextInt(); // n个会议
        for (int i = 0; i < n; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            Meeting meeting  = new Meeting(i+1, start, end);
            meetings.add(meeting);
        }
        meetings.sort(null);
        int curTime = 0; // 当前的时间, 从一天的0点开始
        for (int i = 0; i < n; i++){
            Meeting meeting = meetings.get(i);
            if (meeting.startTime >= curTime){  // 会议的开始时间比我们当前的要大, 表示可以开
                System.out.println(meeting.toString());
                curTime = meeting.endTime;
            }
        }
    }

}

class Meeting implements Comparable<Meeting>{

    int meNum; // 编号
    int startTime; // 开始时间
    int endTime; // 结束时间

    public int compareTo(Meeting o){
        if(this.endTime > o.endTime){
            return 1;
        }
        return -1;
    }

    public Meeting(int meNum, int startTime, int endTime) {
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meNum=" + meNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
