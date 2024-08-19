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

        public String getAttractionName() {
            return attractionName;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        public String getAttractionOpenTime() {
            return attractionOpenTime;
        }

        public void setAttractionOpenTime(String attractionOpenTime) {
            this.attractionOpenTime = attractionOpenTime;
        }

        public double getTicketCost() {
            return ticketCost;
        }

        public void setTicketCost(double ticketCost) {
            this.ticketCost = ticketCost;
        }

        public String toString() {
            return "Название: " + attractionName + ", " + " Время работы: " + attractionOpenTime + ", " + " Стоимость билетов: " + ticketCost + " руб. ";
        }
    }
}