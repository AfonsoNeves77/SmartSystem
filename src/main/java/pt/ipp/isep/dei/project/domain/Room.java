package pt.ipp.isep.dei.project.domain;

import java.util.List;

public class Room {
    private String roomName;
    private int houseFloor;
    private RoomDimensions dimensions;
    private ListOfDevices deviceList = new ListOfDevices();

    /**
     * Room Constructor
     * @param roomName Name of the room
     * @param houseFloor Floor number
     * @throws InstantiationException if room name is not valid
     */
    public Room(String roomName, int houseFloor) throws InstantiationException{
        if(roomName == null || roomName.trim().isEmpty()){
            throw new InstantiationException("Please insert valid room data.");
        }
        this.roomName = roomName;
        this.houseFloor = houseFloor;
    }

    /**
     * Sets room dimensions to the Room
     * @param roomWidth Room width
     * @param roomLength Room length
     * @param roomHeight Room Height
     * @throws InstantiationException In case room dimensions are not valid
     */
    public void createRoomDimensions(double roomWidth, double roomLength, double roomHeight) throws InstantiationException {
        this.dimensions = new RoomDimensions(roomWidth,roomLength,roomHeight);
    }

    /**
     * Extracts room dimensions from RoomDimensions object
     * @return Array with room dimension values
     */
    public double[] extractEachDimension(RoomDimensions dimensions){
        double[] roomDimensions = new double[3];
        roomDimensions[0] = dimensions.getRoomWidth();
        roomDimensions[1] = dimensions.getRoomLength();
        roomDimensions[2] = dimensions.getRoomHeight();
        return roomDimensions;
    }

    /**
     * @return Room name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @return House floor of the Room
     */
    public int getHouseFloor() {
        return houseFloor;
    }

    /**
     * Object room dimensions
     * @return
     */
    public RoomDimensions getDimensions() {
        return dimensions;
    }

    /**
     * @return Object device list
     */
    public List<Device> getListOfDevices() {
        return deviceList.getDeviceList();
    }

    public int addDevice(String deviceName, String deviceModel, String location,FactoryListOfSensors factoryListOfSensors){
        return deviceList.addDeviceToList(deviceName,deviceModel,location,factoryListOfSensors);
    }
}
