package tasks;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<AttractionInfo> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();

    }

    public void attractionAdd(String attractionName, String attractionOpenTime, double ticketCost) {
        AttractionInfo attraction = new AttractionInfo(attractionName, attractionOpenTime, ticketCost);
        attractions.add(attraction);
    }

    public void printAttraction() {
        for (AttractionInfo attraction : attractions) {
            System.out.println(attraction);
        }
    }

    public class AttractionInfo {
        private String attractionName;
        private String attractionOpenTime;
        private double ticketCost;

        public AttractionInfo(String attractionName, String attractionOpenTime, double ticketCost) {
            this.attractionName = attractionName;
            this.attractionOpenTime = attractionOpenTime;
            this.ticketCost = ticketCost;
        }

        String getAttractionName() {
            return attractionName;
        }

        void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        String getAttractionOpenTime() {
            return attractionOpenTime;
        }

        void setAttractionOpenTime(String attractionOpenTime) {
            this.attractionOpenTime = attractionOpenTime;
        }

        double getTicketCost() {
            return ticketCost;
        }

        void setTicketCost(double ticketCost) {
            this.ticketCost = ticketCost;
        }

        public String toString() {
            return attractionName + attractionOpenTime + ticketCost;
        }
    }
}