const mongoose = require('mongoose');

const imuDataSchema = new mongoose.Schema({
    jump_metadata: {
        jump_type: String,
        air_time: Number,
        height: Number,
        rotation_amount: Number
    },
    imu_data: {
        IMU1: {
            accel_x: [Number],
            accel_y: [Number],
            accel_z: [Number],
            gyro_x: [Number],
            gyro_y: [Number],
            gyro_z: [Number]
        },
        IMU2: {
            accel_x: [Number],
            accel_y: [Number],
            accel_z: [Number],
            gyro_x: [Number],
            gyro_y: [Number],
            gyro_z: [Number]
        },
        IMU3: {
            accel_x: [Number],
            accel_y: [Number],
            accel_z: [Number],
            gyro_x: [Number],
            gyro_y: [Number],
            gyro_z: [Number]
        },
        IMU4: {
            accel_x: [Number],
            accel_y: [Number],
            accel_z: [Number],
            gyro_x: [Number],
            gyro_y: [Number],
            gyro_z: [Number]
        },
        IMU5: {
            accel_x: [Number],
            accel_y: [Number],
            accel_z: [Number],
            gyro_x: [Number],
            gyro_y: [Number],
            gyro_z: [Number]
        }
    }
});

// Create a Mongoose model
const IMUData = mongoose.model('IMUData', imuDataSchema);

module.exports = IMUData;
