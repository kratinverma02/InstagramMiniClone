from datetime import datetime
from ..extensions import db

class Post(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    image_url = db.Column(db.String(255), nullable=False)
    caption = db.Column(db.Text)
    timestamp = db.Column(db.DateTime, default=datetime.utcnow)

    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)

    likes = db.relationship('Like', cascade="all,delete", lazy=True)
    comments = db.relationship('Comment', cascade="all,delete", lazy=True)

