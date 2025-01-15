const express = require('express');
const fs = require('fs');
const path = require('path');
const axios = require('axios');

const app = express();
const PORT = 3000;


const IMAGE_PATH = '/data/hourly-image.jpg'; // Persisted in a Kubernetes-mounted volume
const CACHE_DURATION_MS = 60 * 60 * 1000; // 60 minutes

// Middleware to serve static files (HTML frontend)
app.use(express.static(path.join(__dirname, 'views')));

// Serve the cached image
app.get('/image', async (req, res) => {
  try {
    const fileExists = fs.existsSync(IMAGE_PATH);
    const now = new Date();

    if (fileExists) {
      const stats = fs.statSync(IMAGE_PATH);
      const lastModified = new Date(stats.mtime);

      // If the file is less than 60 minutes old, serve the cached version
      if (now - lastModified < CACHE_DURATION_MS) {
        return res.sendFile(IMAGE_PATH);
      }
    }

    // Fetch a new image and save it locally
    const response = await axios.get('https://picsum.photos/1200', {
      responseType: 'stream',
    });

    const writer = fs.createWriteStream(IMAGE_PATH);
    response.data.pipe(writer);

    writer.on('finish', () => {
      res.sendFile(IMAGE_PATH); // Serve the new image
    });

    writer.on('error', (error) => {
      console.error('Error writing image:', error);
      res.status(500).send('Failed to fetch or cache the image.');
    });
  } catch (error) {
    console.error('Error fetching image:', error);
    res.status(500).send('Failed to fetch or cache the image.');
  }
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
