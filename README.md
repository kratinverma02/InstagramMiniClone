# Instagram Mini Clone

A mini Instagram-style social media app built with **Kotlin + Jetpack Compose** on Android and **Python Flask** backend.  
This project demonstrates full-stack development, including user authentication, posts, likes, comments, following system, and a dynamic feed.

## Backend Setup

1. Clone the backend repository or navigate to the backend folder.
2. Create a virtual environment:
   i. python -m venv venv
   ii. source venv/bin/activate  # Linux/Mac
   iii. venv\Scripts\activate     # Windows
4. Install dependencies:
   i. pip install -r requirements.txt
5. Initialize database:
   i. flask db init
   ii. flask db migrate -m "Initial migration"
   iii. flask db upgrade
6. Run backend:
   i. python run.py

## Android Frontend Setup

1. Open the project in Android Studio.
2. Make sure your build.gradle contains required dependencies:
   ->Retrofit
   ->Kotlin Coroutines
   ->Jetpack Compose
   ->DataStore
3. Build and run the app on an emulator or device.
