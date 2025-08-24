# EV Buddy App - Intern Assignment 

## Video Preview



Uploading EvBuddyAppVideo.mp4…


## Instruction to run the app

1. Clone the repository
   ```sh 
   git@github.com:BlairyDev/evbuddy-app.git
                       or
   https://github.com/BlairyDev/evbuddy-app.git

2. Add API key in `secrets-properties` to be able to make Google Maps work
    - Create a new API Key at https://developers.google.com/maps/documentation/places/android-sdk/cloud-setup and replace existing API key in `secrets-properties` then sync Gradle files
        ```kotlin
        PLACES_API_KEY="your new api key"

3. If the app doesn't run, sync Gradle files then run
