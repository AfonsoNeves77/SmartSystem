package pt.ipp.isep.dei.project.domain;

import java.util.ArrayList;

public class ListOfRooms {
    private ArrayList<Room> roomList;

    /**
     * ListOfRooms Constructor
     */
    public ListOfRooms(){
        this.roomList = new ArrayList<>();
    }

    /**
     * Requests Room Class to instantiate a new Room
     * @param roomName Room name
     * @param houseFloor House floor to insert the Room
     * @return The new Room
     * @throws InstantiationException In case room name is not valid
     */
    private Room createRoom(String roomName, int houseFloor) throws InstantiationException {
        return new Room(roomName, houseFloor);
    }

    /**
     * Adds a room, including its dimensions (width, length, height)
     * @param roomName Room name
     * @param houseFloor Room house floor
     * @param roomWidth Room width
     * @param roomLength Room length
     * @param roomHeight Room height
     * @return Code 0: Room successfully added;
     * Code 1: Impossible to instantiate a new Room;
     * Code 2: Room already exists in the house (duplication).
     */
    public int addRoomToList(String roomName, int houseFloor, double roomWidth, double roomLength, double roomHeight) {
        if(isRoomInList(roomName)) {
            return 2;
        }
        try{
            Room newRoom = createRoom(roomName, houseFloor);
            newRoom.createRoomDimensions(roomWidth,roomLength,roomHeight);
            roomList.add(newRoom);
            return 0;
        } catch (InstantiationException e) {
            return 1;
        }
    }

    /**
     * Verifies if Room is already in the list by evaluating existing room names
     * @param roomName Room name
     * @return True if Room already exists in the list
     */
    private boolean isRoomInList(String roomName){
        for (Room singleRoom : roomList){
            if(singleRoom.getRoomName().equals(roomName)){
                return true;
            }
        }
        return false;
    }

    /**
     * @return Room list with Room objects
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }
}
