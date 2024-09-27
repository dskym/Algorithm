class MyCalendarTwo {
    List<Interval> bookings;
    List<Interval> overLapBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overLapBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(Interval interval : overLapBookings) {
            if(isOverlap(interval, start, end)) {
                return false;
            }
        }

        for(Interval interval : bookings) {
            if(isOverlap(interval, start, end)) {
                overLapBookings.add(getOverlapInterval(interval, start, end));
            }
        }
        
        bookings.add(new Interval(start, end));

        return true;
    }

    public boolean isOverlap(Interval interval, int start, int end) {
        return Math.max(interval.getStart(), start) < Math.min(interval.getEnd(), end);
    }

    public Interval getOverlapInterval(Interval interval, int start, int end) {
        return new Interval(Math.max(interval.getStart(), start), Math.min(interval.getEnd(), end));
    }
}

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
