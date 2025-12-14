# Instagram Mini Clone

A mini Instagram-style social media app built with **Kotlin + Jetpack Compose** on Android and **Python Flask** backend.  
This project demonstrates full-stack development, including user authentication, posts, likes, comments, following system, and a dynamic feed.

## Backend Setup

1. Clone the backend repository or navigate to the backend folder.
2. Create a virtual environment:
   python -m venv venv
   source venv/bin/activate  # Linux/Mac
   venv\Scripts\activate     # Windows
3. Install dependencies:
   pip install -r requirements.txt
4. Initialize database:
   flask db init
   flask db migrate -m "Initial migration"
   flask db upgrade
5. Run backend:
   python run.py

## Android Frontend Setup

1. Open the project in Android Studio.
2. Make sure your build.gradle contains required dependencies:
   Retrofit
   Kotlin Coroutines
   Jetpack Compose
   DataStore
3. Build and run the app on an emulator or device.
