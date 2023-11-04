# Router-Simulation-
# Simple Router Simulation in Java

This is a simplified router simulation implemented in Java. The application uses `HashMap` to map each destination with the respective next hop at each router. When a router receives a packet, it checks the destination of the packet and routes it to the next hop.

## Setup

This application requires Java 8 or above.

To compile the Java files:
bash
javac RouterSimulation.java
## Usage

To run the RouterSimulation program:
bash
java RouterSimulation
In this sample simulation, three routers (`Router A`, `Router B`, and `Router C`) are set up. The routing table for each router is configured such that packets are routed from `Router A` to `Router B` and then to `Router C`.

When you run the simulation, a packet is created at `Router A` with `Router C` as its destination. The packet's data is `"Hello, Router C!"`. `Router A` begins routing the packet based on its routing table. It routes the packet to `Router B`, which in turn routes it to `Router C`, its final destination.

This application logs messages in the console, providing a trace of how the packet is forwarded from router to router.

## Notes

This is a highly simplified model of how routing works in a computer network. Real-world routers deal with far more complex scenarios and data structures.
