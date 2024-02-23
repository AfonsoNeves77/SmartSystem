//package pt.ipp.isep.dei.project.controller;
//import pt.ipp.isep.dei.project.DTO.DeviceDTO;
//import pt.ipp.isep.dei.project.DTO.DeviceDTOMapper;
//import pt.ipp.isep.dei.project.DTO.RoomDTO;
//import pt.ipp.isep.dei.project.domain.Device;
//import pt.ipp.isep.dei.project.domain.House;
//import pt.ipp.isep.dei.project.domain.Room;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map.Entry;
//
//
//public class GetDevicesByFunctionalityCTRL {
//
//    private House house;
//
//
//    /**
//     * Controller Constructor for Use Case: List devices by functionality. Include device location.
//     * @param house House to be considered
//     */
//    public GetDevicesByFunctionalityCTRL(House house) {
//        this.house = house;
//    }
//
//    /**
//     * Requests a list containing devices grouped by their functionalities (device includes location as attribute)
//     * @return A HashMap with device functionalities as keys, and DeviceDTO Objects as values
//     */
//    public HashMap<String, ArrayList<DeviceDTO>> getDevicesByFunctionality(){
//        GroupDevicesByFunctionality groupDevices = new GroupDevicesByFunctionality();
//        List<Room> listOfRooms = this.house.getListOfRooms();
//        HashMap<String,ArrayList<Device>> deviceByFunctionality = groupDevices.getDevicesMap(listOfRooms);
//        return convertHashMap(deviceByFunctionality);
//    }
//
//    /**
//     * Converts Domain Object Devices present in the HashMap into DeviceDTO Objects for external use
//     * @param devicesMap HashMap with data to be converted
//     * @return HashMap including lists of DeviceDTO Objects per functionality
//     */
//    private HashMap<String, ArrayList<DeviceDTO>> convertHashMap(HashMap<String,ArrayList<Device>> devicesMap) {
//        HashMap<String, ArrayList<DeviceDTO>> devicesDTOMap = new HashMap<>();
//        for (Entry<String, ArrayList<Device>> entry : devicesMap.entrySet()) {
//            String key = entry.getKey();
//            ArrayList<Device> list = entry.getValue();
//            CommonListOfDevices CLR = new CommonListOfDevices(house);
//            ArrayList<DeviceDTO> deviceDTOList = CLR.getDevicesFromRoom() ;
//            devicesDTOMap.put(key,deviceDTOList);
//        }
//        return devicesDTOMap;
//    }
//}
