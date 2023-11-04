import java.util.HashMap;

class Packet {
    String data;
    String destination;
}

class Router {
    private String routerName;
    private HashMap<String, Router> routingTable;

    public Router(String routerName) {
        this.routerName = routerName;
        this.routingTable = new HashMap<>();
    }

    public void addRoute(String destination, Router nextHop) {
        this.routingTable.put(destination, nextHop);
    }

    public void routePacket(Packet packet) {
        if (packet.destination.equals(this.routerName)) {
            System.out.println("Packet delivered to destination: " + this.routerName);
            System.out.println("Data: " + packet.data);
        } else {
            Router nextHop = this.routingTable.get(packet.destination);
            if (nextHop != null) {
                System.out.println("Packet forwarded from " + this.routerName + " to " + nextHop.routerName);
                nextHop.routePacket(packet);
            } else {
                System.out.println("Route not found from " + this.routerName + " to " + packet.destination);
            }
        }
    }
    
    //getter
    public String getRouterName() {
        return this.routerName;
    }
}

public class RouterSimulation {
    public static void main(String[] args) {
        Router routerA = new Router("A");
        Router routerB = new Router("B");
        Router routerC = new Router("C");

        // Set up the routing table
        routerA.addRoute(routerB.getRouterName(), routerB);
        routerB.addRoute(routerC.getRouterName(), routerC);
 
        // Create a packet at Router A destined for Router C
        Packet packet = new Packet();
        packet.data = "Hello, Router C!";
        packet.destination = routerC.getRouterName();

        // Begin routing the packet from router A
        routerA.routePacket(packet);
    }
}