package us.codecraft.webmagic.utils;

import us.codecraft.webmagic.Request;

import java.util.Comparator;

public class PriorityQueueSchedulerComparator implements Comparator<Request>{
    @Override
    public int compare(Request o1, Request o2) {
        return -NumberUtils.compareLong(o1.getPriority(), o2.getPriority());
    }
}
