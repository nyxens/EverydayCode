import java.util.*;
class Router {
    private static class Packet {
        int source;
        int destination;
        int timestamp;
        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source &&
                   destination == packet.destination &&
                   timestamp == packet.timestamp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
    private Deque<Packet> queue;
    private Set<Packet> memory;
    private int memoryLimit;
    public Router(int memoryLimit) {
        this.queue = new ArrayDeque<>(memoryLimit);
        this.memory = new HashSet<>();
        this.memoryLimit = memoryLimit;
    }
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet newPacket = new Packet(source, destination, timestamp);
        if (memory.contains(newPacket)) {
            return false;
        }
        if (queue.size() == memoryLimit) {
            Packet removed = queue.pollFirst();
            if (removed != null) {
                memory.remove(removed);
            }
        }
        queue.offerLast(newPacket);
        memory.add(newPacket);
        return true;
    }
    public int[] forwardPacket() {
        Packet removed = queue.pollFirst();
        if (removed == null) {
            return new int[] {};
        }
        memory.remove(removed);
        return new int[] { removed.source, removed.destination, removed.timestamp };
    }
    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for (Packet packet : queue) {
            if (packet.destination == destination &&
                packet.timestamp >= startTime &&
                packet.timestamp <= endTime) {
                count++;
            }
        }
        return count;
    }
}
