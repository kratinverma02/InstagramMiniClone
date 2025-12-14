# Instagram Mini Clone

A mini Instagram-style social media app built with **Kotlin + Jetpack Compose** on Android and **Python Flask** backend.  
This project demonstrates full-stack development, including user authentication, posts, likes, comments, following system, and a dynamic feed.

## Backend Setup

1. Clone the backend repository or navigate to the backend folder.
2. Create a virtual environment:
   1. python -m venv venv
   2. source venv/bin/activate  # Linux/Mac
   3. venv\Scripts\activate     # Windows
4. Install dependencies:
   1. pip install -r requirements.txt
6. Initialize database:
   1. flask db init
   2. flask db migrate -m "Initial migration"
   3. flask db upgrade
7. Run backend:
   1. python run.py

## Android Frontend Setup

1. Open the project in Android Studio.
2. Make sure your build.gradle contains required dependencies:
   1. Retrofit
   2. Kotlin Coroutines
   3. Jetpack Compose
   4. DataStore
4. Build and run the app on an emulator or device.
