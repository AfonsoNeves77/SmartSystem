package pt.ipp.isep.dei.project.domain;

public class RoomDimensions {
    private double roomWidth;
    private double roomLength;
    private double roomHeight;

    //Create constructor with only width and length parameters as well??

    /**
     * RoomDimensions Constructor
     * @param roomWidth Room width
     * @param roomLength Room Length
     * @param roomHeight Room Height
     * @throws InstantiationException In case any of the given dimensions is invalid
     */
    public RoomDimensions(double roomWidth, double roomLength, double roomHeight) throws InstantiationException {
        if(!areDimensionsValid(roomWidth,roomLength,roomHeight))
            throw new InstantiationException("Invalid parameters.");
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
        this.roomHeight = roomHeight;
    }

    /**
     * Validates the given room dimensions
     * @param roomWidth Room width
     * @param roomLength Room length
     * @param roomHeight Room height
     * @return True or false
     */
    private boolean areDimensionsValid(double roomWidth, double roomLength, double roomHeight) {
        return roomWidth > 0 && roomLength > 0 && roomHeight >= 0;
    }

    /**
     * @return Room width
     */
    public double getRoomWidth() {
        return roomWidth;
    }

    /**
     * @return Room Length
     */
    public double getRoomLength() {
        return roomLength;
    }

    /**
     * @return Room Height
     */
    public double getRoomHeight() {
        return roomHeight;
    }
}
