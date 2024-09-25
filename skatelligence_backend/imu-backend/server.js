const express = require('express');
const mongoose = require('mongoose');
const IMUData = require('./IMUData');
const app = express();
const port = 3000;

app.use(express.json());

// MongoDB Connection URI
const mongoURI = 'mongodb://localhost:27017/imuDB';

// Connect to MongoDB
mongoose.connect(mongoURI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch((err) => console.error('Could not connect to MongoDB:', err));

// Route to return all IMU data
app.get('/imu-data', async (req, res) => {
  try {
    const data = await IMUData.find();
    res.json(data);
  } catch (error) {
    res.status(500).send('Error fetching IMU data: ' + error.message);
  }
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
