package pt.ipp.isep.dei.project.domainTest;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.project.domain.Device;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    /**
     * Test 01 - Verifies the constructo throws an exception if invalid parameter
     */
    @Test
    void deviceConstructor_ThrowsExceptionInvalidName() {
        //Arrange
        String deviceName = " ";
        String deviceModel = "Heater";
        String deviceLocation = "Room";
        String expected = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() ->
            new Device(deviceName, deviceModel, deviceLocation));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 02 - Verifies the constructo throws an exception if invalid parameter
     */
    @Test
    void deviceCreationConstructor_ThrowsExceptionNullName() {
        //Arrange
        String deviceModel = "Heater";
        String deviceLocation = "Room";
        String expected = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class,() ->
            new Device(null, deviceModel, deviceLocation));
        String result = exception.getMessage();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 03 - Successfully able to get device Name after creation
     */
    @Test
    void getDeviceName_Success() throws InstantiationException {
        //Arrange
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        String deviceLocation = "Room";
        String expected = "Heater";
        Device newDevice = new Device(deviceName,deviceModel, deviceLocation);
        //Act
        String result = newDevice.getDeviceName();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Test 03 - Successfully able to get device Model after creation
     */
    @Test
    void getDeviceModel_Success() throws InstantiationException {
        //Arrange
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        String deviceLocation = "Room";
        String expected = "XPTO3000";
        Device newDevice = new Device(deviceName,deviceModel, deviceLocation);
        //Act
        String result = newDevice.getDeviceModel();
        //Assert
        assertEquals(expected,result);
    }

    /**
     * Changes the device attribute status to the opposite boolean value. Devices start with status = false
     * 1. Instanciates new Device (status is false as default).
     * 2. Expected the resulting status is true after method call
     * @throws InstantiationException If device parameters invalid
     */
    @Test
    void toggleDeviceStatus_returnsTrue() throws InstantiationException {
        //Arrange
        // 1.
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        String deviceLocation = "Room";
        Device newDevice = new Device(deviceName, deviceModel, deviceLocation);

        //Act
        // 2.
        boolean result = newDevice.toggleDeviceStatus();
        //Assert
        assertTrue(result);
    }
        /**
         * Changes the device attribute status to the opposite boolean value. Devices start with status = false
         * 1. Instanciates new Device (status is false as default).
         * 2. Toggles status to true
         * 3. Expected the resulting status is false after method call
         * @throws InstantiationException If device parameters invalid
         */
        @Test
        void toggleDeviceStatus_returnsFalse() throws InstantiationException {
            //Arrange
            // 1.
            String deviceName = "Heater";
            String deviceModel = "XPTO3000";
            String deviceLocation = "Room";
            Device newDevice = new Device(deviceName,deviceModel, deviceLocation);

            // 2.
            newDevice.toggleDeviceStatus();
            //Act
            // 3.
            boolean result = newDevice.toggleDeviceStatus();
            //Assert
            assertFalse(result);
    }

    /**
     * Gets the device present status with getDeviceStatus method. Devices start with status = false
     * 1. Instantiates new Device (status is false as default).
     * 2. Expected the resulting status is false after method call.
     * @throws InstantiationException If device parameters invalid
     */
    @Test
    void getDeviceStatus_Off() throws InstantiationException {
        //Arrange
        //1.
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        String deviceLocation = "Room";
        Device newDevice = new Device(deviceName,deviceModel, deviceLocation);

        //Act
        //2.
        boolean result = newDevice.getStatus();

        //Assert
        assertFalse(result);
    }

    /**
     * Gets the device present status with getDeviceStatus method. Devices start with status = false
     * 1. Instantiates new Device (status is false as default).
     * 2. Toggles status to true.
     * 3. Expected the resulting status is true after method call.
     * @throws InstantiationException If device parameters invalid
     */
    @Test
    void getDeviceStatus_On() throws InstantiationException {
        //Arrange
        //1.
        String deviceName = "Heater";
        String deviceModel = "XPTO3000";
        String deviceLocation = "Room";
        Device newDevice = new Device(deviceName,deviceModel, deviceLocation);
        //2.
        newDevice.toggleDeviceStatus();

        //Act
        //3.
        boolean result = newDevice.getStatus();

        //Assert
        assertTrue(result);
    }



}
