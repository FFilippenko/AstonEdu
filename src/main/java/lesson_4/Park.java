package lesson_4;

import java.time.LocalTime;

public class Park {
    private String location;
    private int parkID;
    private Attraction[] attractions;

    public Park(String location, int parkID) {
        this.location = location;
        this.parkID = parkID;
        this.attractions = new Attraction[3];
        this.attractions[0] = new Attraction("Горки", LocalTime.of(8, 0, 0), LocalTime.of(20, 0, 0), 100);
        this.attractions[1] = new Attraction("Карусель", LocalTime.of(10, 0, 0), LocalTime.of(22, 0, 0), 200);
        this.attractions[2] = new Attraction("Иллюзион", LocalTime.of(12, 0, 0), LocalTime.of(23, 59, 0), 300);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getParkID() {
        return parkID;
    }

    public void setParkID(int parkID) {
        this.parkID = parkID;
    }

    class Attraction {
        private String name;
        private LocalTime startTime;
        private LocalTime endTime;
        private int cost;

        public Attraction(String attractionName, LocalTime startTime, LocalTime endTime, int attractionCost) {
            this.name = attractionName;
            this.startTime = startTime;
            this.endTime = endTime;
            this.cost = attractionCost;
        }

        public String getName() {
            return name;
        }

        public void setName(String attractionName) {
            this.name = attractionName;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime time) {
            this.startTime = time;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime time) {
            this.endTime = time;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int attractionCost) {
            this.cost = attractionCost;
        }
    }
}

