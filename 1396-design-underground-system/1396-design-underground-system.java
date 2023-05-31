class UndergroundSystem {
    Map<Integer, CheckInInfo> checkInMap = null;
    Map<String, TravelInfo> journeyDetails = null;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyDetails = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkInMap.remove(id);
        String journeyKey = checkInInfo.checkInStation + "," + stationName;
        Integer duration = t - checkInInfo.checkinTime;
        if(journeyDetails.get(journeyKey) != null) {
            TravelInfo travelInfo = journeyDetails.get(journeyKey);
            Integer totatlTime = travelInfo.totalTime + duration;
            Integer count = travelInfo.count + 1;
            journeyDetails.put(journeyKey, new TravelInfo(totatlTime, count));
        } else {
            journeyDetails.put(journeyKey, new TravelInfo(duration, 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        TravelInfo travelInfo = journeyDetails.get(startStation + "," + endStation);
        return (double)travelInfo.totalTime/ travelInfo.count;
    }
}

class CheckInInfo {
    String checkInStation;
    Integer checkinTime;
    
    public CheckInInfo(String checkInStation, Integer checkinTime) {
        this.checkInStation = checkInStation;
        this.checkinTime = checkinTime;
    }
}
class TravelInfo {
    Integer totalTime;
    Integer count;
    
    public TravelInfo(Integer totalTime, Integer count) {
        this.totalTime = totalTime;
        this.count = count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */